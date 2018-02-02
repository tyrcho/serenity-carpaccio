package demo;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://kazan.priv.atos.fr/portal/")
public class HomePage extends PageObject {

    @FindBy(css = "input[id='userLogin']")
    WebElement userField;

    public void searchFor(String keywords) {
        userField.sendKeys("hello");
    }
}
