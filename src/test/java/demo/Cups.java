package demo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class Cups {
    @Steps
    CupSteps steps;

    @Then("^my belly should growl$")
    public void my_belly_should_growl() throws Exception {
        steps.my_belly_should_growl();
    }

    @When("^I wait (\\d+) minutes$")
    public void iWaitMinutes(int min) throws Throwable {
        steps.iWaitMinutes(min);
    }

    @Then("^my belly should not growl$")
    public void myBellyShouldNotGrowl() throws Throwable {
        steps.myBellyShouldNotGrowl();
    }

    @Given("^I eat (\\d+) cukes$")
    public void iEatCukes(int count) throws Throwable {
        steps.iEatCukes(count);
    }
}
