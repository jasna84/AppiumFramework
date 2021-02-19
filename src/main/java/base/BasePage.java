package base;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static Integer TIMEOUT_WEBDRIVER_WAIT = 10;

    public static final Logger log = LogManager.getLogger(BasePage.class);

    public BasePage() {
        PageFactory.initElements(Capabilities.getInstance().getDriver(), this);
        log.info("Page created: " + this.getClass().getName());
    }

    public boolean waitForElement(By by, int attempts) {

        boolean condition = false;
        int waitUntilNow = 0;
        while (!condition && waitUntilNow < attempts) {
            try {
                condition = (new WebDriverWait(Capabilities.getInstance().getDriver(), TIMEOUT_WEBDRIVER_WAIT))
                        .until(sizes -> Capabilities.getInstance().getDriver().findElements(by).size()!=0);
            } catch(TimeoutException e) {
                log.info("Element: "+by+" was not found within 10 sec. Trying again ...");
            }
            waitUntilNow = waitUntilNow + 1;
        }

        if(waitUntilNow == attempts) {
            log.error("Element was not found: "+by + " number of attempts: "+attempts+", each attempts lasted 10sec.");
        }

        return condition;
    }


    public void clickOn(By by) {

        AndroidElement element = (AndroidElement) Capabilities.getInstance().getDriver().findElement(by);
        element.click();
        log.debug("Element clicked");
    }

    public String getElementText(By by) {

        AndroidElement element = (AndroidElement) Capabilities.getInstance().getDriver().findElement(by);
        String text = element.getText();
        log.debug("Element text received: " + text);
        return text;
    }

    public void sendText(By by, String text) {

        AndroidElement element = (AndroidElement) Capabilities.getInstance().getDriver().findElement(by);
        element.click();
        element.sendKeys(text);
        log.debug("Element text entered: " + text);
    }

    public static void hardCodedWaiter(Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("Exception caught: " + e);
        }
    }

    public double getContainerHeight(By by) {

        AndroidElement element = (AndroidElement) Capabilities.getInstance().getDriver().findElement(by);
        double height = element.getSize().getHeight();
        log.debug("Element height received: " + height);
        return height;

    }

    public double getContainerWidth(By by) {

        AndroidElement element = (AndroidElement) Capabilities.getInstance().getDriver().findElement(by);
        double width = element.getSize().getWidth();
        log.debug("Element width received: " + width);
        return width;

    }

    public void swipeDown(int starty, int endy, int x) {

        new TouchAction(Capabilities.getInstance().getDriver())
                .press(PointOption.point(x, starty))
                 .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(x, endy))
                .release().
                 perform();
        log.debug("Swipe successful");
    }


    public void removeKeyboard() {
        Capabilities.getInstance().getDriver().hideKeyboard();
        log.debug("Keyboard hidden");


    }

    public boolean exist() {
        return false;
    }
}
