package demo;

import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CupSteps {
    Belly belly = new Belly();

    @Step
    public void my_belly_should_growl() throws Exception {
        assertTrue(belly.isHungry());
    }

    @Step
    public void iWaitMinutes(int min) throws Throwable {
        belly.waitFor(min);
    }

    @Step
    public void myBellyShouldNotGrowl() throws Throwable {
        assertFalse(belly.isHungry());
    }

    @Step
    public void iEatCukes(int count) throws Throwable {
        belly.eat(count);
    }
}
