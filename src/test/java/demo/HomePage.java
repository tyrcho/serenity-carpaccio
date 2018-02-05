package demo;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

@DefaultUrl("http://www.google.com")
public class HomePage extends PageObject {


    private static boolean cheesed(WebDriver d) {
        return d.getTitle().toLowerCase().startsWith("cheese!");
    }

    public void login(String user) {
        WebDriver driver = getWebDriver();
        driver.get("http://www.google.com");
        WebElement q = driver.findElement(By.name("q"));
        q.sendKeys("Cheese!");
        q.submit();
//        driver.waitFor((ExpectedCondition<Boolean>) HomePage::cheesed);
//
//        System.out.println("Page title is: " + getTitle());
    }

    private WebDriver getWebDriver() {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("proxy:3128");
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.htmlUnit();
        desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);
        return new HtmlUnitDriver(desiredCapabilities);
    }
}
