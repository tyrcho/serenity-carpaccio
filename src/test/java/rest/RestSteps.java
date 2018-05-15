package rest;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.hamcrest.Matchers.equalTo;

public class RestSteps {
    private final String PROXY_HOST = "proxy-internet.localnet";
    private final int PROXY_PORT = 3128;

    private String countrycode;
    private int day;
    private int month;

    @When("^I ask nameday in country (.*) for (.*)/(.*)$")
    public void iAskNamedayInCountryCountrycodeForDayMonth(String countrycode, int day, int month) throws Throwable {
        this.countrycode = countrycode;
        this.day = day;
        this.month = month;
    }

    @Then("^I get the name (.*)$")
    public void iGetTheNameName(String expectedName) throws Throwable {
        String url = format("https://api.abalin.net/get/namedays?day=%s&month=%s&country=%s",
                day, month, countrycode);

        given().proxy(PROXY_HOST, PROXY_PORT)
                .get(url)
                .then()
                .body("data.name_" + countrycode, equalTo(expectedName));
    }
}
