package carpaccio;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class OrderSteps {
    private Order order = new Order();

    @When("^I order (\\d+) items with price (.+\\$)$")
    public void iOrderItemsWithPrice(int items, String price) {
        order.setItems(items).setPrice(price);
    }

    @Then("^the order basic price is (.+)$")
    public void the_order_basic_price_is(String price) {
        assertThat(order.basicPriceFormatted()).isEqualTo(price);
    }

    @When("^I order (\\d+) items with price (.+\\$) to be delivered in UT$")
    public void i_order_items_with_price_$_to_be_delivered_in_UT(int items, String price) {
        order.setItems(items).setPrice(price);
    }

    @When("^I order (\\d+) items with price (.+\\$) to be delivered in state (.+)$")
    public void i_order_items_with_price_$_to_be_delivered_in_state(int items, String price, String state) {
        order.setItems(items).setPrice(price).setState(state);
    }


    @Then("^the price with tax is (.+)$")
    public void the_price_with_tax_is_$(String price) {
        assertThat(order.priceWithTaxFormatted()).isEqualTo(price);
    }

    @And("^the tax rate is (.+)$")
    public void theTaxRateIsTax_rate(String rate) {
        assertThat(order.taxRateFormatted()).isEqualTo(rate);
    }


    @And("^the tax amount is (.+)$")
    public void theTaxAmountIsTax_amount(String amount) throws Throwable {
        assertThat(order.taxAmountFormatted()).isEqualTo(amount);
    }
}
