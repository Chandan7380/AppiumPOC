package sandbox.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.MalformedURLException;
import java.net.URL;

public class MobileUtil {

    AndroidDriver driver;
    public  void desireCapabilities(){
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"IVEIW4GYX4VG5H7T");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.skyinnolabs.poslite.sandbox");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.skyinnolabs.poslite.views.changelanguage.ChangeLanguageActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/apps/android/sandbox.apk");

        URL  url = null;

        try {
            url = new URL("http://127.0.0.1:4750/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
         driver=new AndroidDriver(url,desiredCapabilities);
        ThreadLocalDriver.setTLDriver(driver);

 }

    public static void waitForElementToAppear(AppiumDriver driver, MobileElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOf(webElement));

    }
    public static void waitForElementsToAppear(AppiumDriver driver, MobileElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfAllElements(webElement));

}}
