package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 

{

    @Test
    public void testApp() throws MalformedURLException {
        //Set capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "14");
        capabilities.setCapability("appium:automationName", "UIAutomator2");
        capabilities.setCapability("appium:deviceName", "Android Emulator");
        capabilities.setCapability("appium:appPackage", "com.android.settings");
        capabilities.setCapability("appium:appActivity", "com.android.settings.Settings");
        capabilities.setCapability("appium:newCommandTimeout", 120);

        //intialize driver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

        //setting implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //search battery
        driver.findElement(By.id("com.android.settings:id/search_action_bar_title")).click();
        WebElement searchBar = driver.findElement(By.id("com.google.android.settings.intelligence:id/open_search_view_edit_text"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBar.sendKeys("Battery");

        //Click toggle
        driver.findElement(By.id("android:id/switch_widget")).click();
        driver.quit();
    }

    @Test
    public void testBrowserStackApp() throws MalformedURLException {
        //Set capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

// Required Appium caps
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "Samsung Galaxy S23");
        capabilities.setCapability("appium:os_version", "13.0");
        capabilities.setCapability("appium:automationName", "UIAutomator2");
        capabilities.setCapability("appium:app", "bs://sample.app");

// W3C-compliant BrowserStack options
        Map<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("userName", "USER_NAME");
        browserstackOptions.put("accessKey", "ACCESS_KEY");
        browserstackOptions.put("projectName", "My Test Project");
        browserstackOptions.put("buildName", "Build 1.0");
        browserstackOptions.put("sessionName", "Settings App Launch Test");

        capabilities.setCapability("bstack:options", browserstackOptions);

        //intialize driver
        AndroidDriver driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);

        //setting implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebElement searchBar = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Search Wikipedia\")"));
        WebDriverWait webDriverWait= new WebDriverWait(driver,Duration.ofSeconds(60));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchBar));

        searchBar.click();

        driver.quit();
    }
}
