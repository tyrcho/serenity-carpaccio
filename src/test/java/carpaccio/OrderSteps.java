package carpaccio;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class OrderSteps {
    Order order = new Order();

    @When("^I order (\\d+) items with price (\\d+)\\$$")
    public void iOrderItemsWithPrice(int items, int price) throws Throwable {
        order.setItems(items).setPrice(price);
    }

    @Then("^the order basic price is (\\d+)\\$$")
    public void the_order_basic_price_is(int price) throws Exception {
        assertThat(order.basicPrice()).isEqualTo(price);
    }
}
