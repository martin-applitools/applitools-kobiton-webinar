package com.kobiton.scriptlessautomation;

import com.applitools.eyes.*;
import com.applitools.eyes.appium.AppiumRunner;
import com.applitools.eyes.appium.Eyes;
import com.applitools.eyes.selenium.Configuration;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Config {
    public static Eyes eyes;
    public static EyesRunner runner = null;
//    public static String batchName = "Kobiton-Applitools";
    public static String batchSequence = "Kobiton-Applitools";
    public static String prospectName = "Kobiton-Appium-Demo";

    enum DEVICE_SOURCE_ENUMS {KOBITON}

    public static final String KOBITON_USERNAME = System.getenv("KOBITON_USERNAME");
    public static final String KOBITON_API_KEY = System.getenv("KOBITON_ACCESS_KEY");
    public static final String APPIUM_SERVER_URL = "https://" + KOBITON_USERNAME + ":" + KOBITON_API_KEY + "@api.kobiton.com/wd/hub";
    public static final DEVICE_SOURCE_ENUMS DEVICE_SOURCE = DEVICE_SOURCE_ENUMS.KOBITON;
    public static final int IMPLICIT_WAIT_IN_MS = 10000;
    public static final int DEVICE_WAITING_MAX_TRY_TIMES = 5;
    public static final int DEVICE_WAITING_INTERVAL_IN_MS = 30000;
    public static final int VISIBILITY_TIMEOUT_IN_MS = 60000;
    public static final int SLEEP_TIME_BEFORE_SEND_KEYS_IN_MS = 3000;
    public static final String KOBITON_API_URL = "https://api.kobiton.com";
    //Baseline version = 670646
    //Changed version = 670647
    public static final String APP_VERSION = "670647";


    public static String getBasicAuthString() {
        String authString = KOBITON_USERNAME + ":" + KOBITON_API_KEY;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authEncString = new String(authEncBytes);
        return "Basic " + authEncString;
    }

    public static DesiredCapabilities getPixel6ProAndroid12DesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("sessionName", "Automation on Android");
        capabilities.setCapability("sessionDescription", "");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("captureScreenshots", true);
        capabilities.setCapability("newCommandTimeout", 900);
        capabilities.setCapability("appium:appWaitDuration", "60000");
        capabilities.setCapability("app", "kobiton-store:v" + APP_VERSION);
        capabilities.setCapability("deviceGroup", "ORGANIZATION");
        capabilities.setCapability("deviceName", "*");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        return capabilities;
    }
    public static Eyes setupEyes() {
        Configuration sconf = new Configuration();
        runner = new AppiumRunner();
        //
        eyes = new Eyes(runner);;

        sconf.setApiKey(System.getenv("APPLITOOLS_API_KEY_KW"));
        //
        //sconf.setBatch(batchname);
        //
        sconf.setMatchTimeout(0);
        //
        sconf.setSendDom(false);
        //
        sconf.setAccessibilityValidation(new AccessibilitySettings(AccessibilityLevel.AA, AccessibilityGuidelinesVersion.WCAG_2_1));
        //
        eyes.setConfiguration(sconf);
        return eyes;
    }
    

}
