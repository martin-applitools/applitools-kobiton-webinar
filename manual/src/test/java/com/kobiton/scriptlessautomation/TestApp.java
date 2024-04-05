package com.kobiton.scriptlessautomation;
import com.applitools.eyes.appium.Target;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.html5.Location;

import static com.kobiton.scriptlessautomation.Config.eyes;

public class TestApp extends TestBase {
    @Before
    public void beforeTest() throws Exception {
        Assert.assertNotEquals(
            "Please update value for the KOBITON_API_KEY constant first. See more at README.md file.",
            "your_kobiton_api_key",
            Config.KOBITON_API_KEY
        );
    }

    @Test
    public void testOnPixel6ProAndroid12() throws Exception {
        DesiredCapabilities capabilities = Config.getPixel6ProAndroid12DesiredCapabilities();
        setup(capabilities, 1);
        runTest();
    }
    

    public void runTest() throws Exception {
        try {
           setImplicitWaitInMiliSecond(Config.IMPLICIT_WAIT_IN_MS);
           System.out.println("Performing Visual Validation Step 1");
           eyes.check("Main Screen", Target.window());
           //
           By[] locatorDowJones = new By[] {AppiumBy.accessibilityId("Dow Jones"), AppiumBy.xpath("//*[@resource-id='com.applitools.stockquote:id/dowjones_logo']"), AppiumBy.xpath("//android.widget.ImageView[@content-desc='Dow Jones']"), AppiumBy.xpath("//android.widget.ImageView[@resource-id='com.applitools.stockquote:id/dowjones_logo']")};
           WebElement elementDowJones = findElementBy(4532, locatorDowJones);
           elementDowJones.click();
           System.out.println("Performing Visual Validation Step 2");
           eyes.check("Generate Dow Jones Quote", Target.window());
           //
           By[] locatorTextViewHISTORY = new By[] {AppiumBy.xpath("//android.widget.TextView[@text='HISTORY']")};
           WebElement elementTextViewHISTORY = findElementBy(4532, locatorTextViewHISTORY);
           elementTextViewHISTORY.click();
           System.out.println("Performing Visual Validation Step 3");
           eyes.check("Click Stock History", Target.window());
           //
           By[] locatorImageView = new By[] {AppiumBy.id("delete_all_stocks_button")};
           WebElement elementImageView = findElementBy(2353, locatorImageView);
           elementImageView.click();
           System.out.println("Performing Visual Validation Step 4");
           eyes.check("Delete All Stock Quotes", Target.window());
           //
           By[] locatorTextViewUSINDEX = new By[] {AppiumBy.xpath("//android.widget.TextView[@text='U.S INDEX']")};
           WebElement elementTextViewUSINDEX = findElementBy(8154, locatorTextViewUSINDEX);
           elementTextViewUSINDEX.click();
           System.out.println("Performing Visual Validation Step 5");
           eyes.check("Click US Index", Target.window());
           eyes.closeAsync();

        } catch (Exception e) {
            e.printStackTrace();
            saveDebugResource();
            eyes.abortIfNotClosed();
            throw e;
        }
    }

    @After
    public void tearDown() {
        cleanup();
    }
}
