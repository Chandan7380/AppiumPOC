package sandbox.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import sandbox.utils.MobileUtil;
import sandbox.utils.ThreadLocalDriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;


public class BaseClass {
    public static AndroidDriver<MobileElement> getAppiumDriver() {
        return (AndroidDriver) ThreadLocalDriver.getTLDriver();
    }
    @BeforeMethod
    public void setup()  {
        MobileUtil sand = new MobileUtil();
        sand.desireCapabilities();
    }

@AfterMethod
    public void tearDown(Method method){
    screenshot(method.getName());
}
public void screenshot(String fileName) {
    TakesScreenshot takesScreenshot = (TakesScreenshot) getAppiumDriver();
    File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
    File file1 = new File("appium-cucumber-testng-poc\\target"+ "/" + fileName + ".png");
    try {
        FileUtils.copyFile(file, file1);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }


}}
