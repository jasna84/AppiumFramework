package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Capabilities {

    public static Capabilities instance = null;
    public ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    private static final Logger log = LogManager.getLogger(Capabilities.class.getName());

    private Capabilities(){

    }

    public static Capabilities getInstance() {
        if (instance == null) {
            instance = new Capabilities();
        }
        return instance;
    }

    public void setCapabilities() {

        try {

            DesiredCapabilities cap = new DesiredCapabilities();

            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "JasnaPhone");
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
            cap.setCapability(MobileCapabilityType.UDID, "52009016b408451f");

            cap.setCapability("appPackage", "co.cvik.user");
            cap.setCapability("appActivity", "co.cvik.user.ui.screens.intro.IntroActivity");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver.set(new AndroidDriver(url, cap));
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            log.info("Device connected to Appium server.");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception found: " + e);
        }
    }

    public AndroidDriver getDriver() {
        return driver.get();
    }

    public void closeDriver() {
        try {
            getDriver().quit();
            log.info("Driver closed.");
        } catch (Exception e) {
            log.error("Driver could not be closed!");
        }
    }
}
