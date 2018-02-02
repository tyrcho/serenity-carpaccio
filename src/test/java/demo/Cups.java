package demo;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Cups {
    Belly belly = new Belly();


    @Then("^my belly should growl$")
    public void my_belly_should_growl() throws Exception {
        assertTrue(belly.isHungry());
    }

    @When("^I wait (\\d+) minutes$")
    public void iWaitMinutes(int min) throws Throwable {
        belly.waitFor(min);
    }

    @Then("^my belly should not growl$")
    public void myBellyShouldNotGrowl() throws Throwable {
        assertFalse(belly.isHungry());
    }

    @Given("^I eat (\\d+) cukes$")
    public void iEatCukes(int count) throws Throwable {
        belly.eat(count);
    }
}
