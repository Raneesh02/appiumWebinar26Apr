package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException {
        {
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
    }
}
