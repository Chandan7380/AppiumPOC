package sandbox.pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import sandbox.utils.MobileUtil;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static sandbox.pages.BaseClass.getAppiumDriver;


public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='English'])[1]")
    private MobileElement language;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NEXT']")
    private MobileElement next;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CREATE ACCOUNT']")
    private MobileElement createAccount;
    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement mobileNumber;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SEND OTP']")
    private MobileElement opt;

    @AndroidFindBy(id = "com.truecaller:id/copy")
    private MobileElement copyOtp;
//    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@id, 'com.skyinnolabs.poslite.sandbox:id/tvBox')]")
   @AndroidFindBy(className = "android.widget.EditText")
    AndroidElement OTPvalue;
    @AndroidFindBy(id = "android:id/big_text")
    List<AndroidElement> messageText;


    public void selectLanguage() {
        MobileUtil.waitForElementToAppear(getAppiumDriver(), language);
        language.click();
    }

    public void clickNextBtn() {
        MobileUtil.waitForElementToAppear(getAppiumDriver(), next);
        next.click();
        next.click();
        next.click();
        next.click();
        next.click();
    }

    public void createAccountBtn() {
        MobileUtil.waitForElementToAppear(getAppiumDriver(), createAccount);
        createAccount.click();
    }

    public void enterMobileNu() {
        MobileUtil.waitForElementToAppear(getAppiumDriver(), mobileNumber);
        mobileNumber.sendKeys("9219329218");
    }

    public void clickOtp() {
        MobileUtil.waitForElementToAppear(getAppiumDriver(), opt);
        opt.click();

    }

    public void enterOTP() {
        waitUtl(5);
        AndroidElement and;
        char a = 0;
        String s = getOTP();
        OTPvalue.sendKeys(s);
    }


//------------ getOTP ____________________________________________________________


    public String getOTP() {
        String OTP = new String();

        try {
            getAppiumDriver().openNotifications();
            Thread.sleep(3000);
            int Size = messageText.size();
            System.out.println("Size =" + Size);
            for (int i = 0; i <= 3; i++) {
                Thread.sleep(2000);
                if (OTP.length() == 0) {
                    OTP = OTPloop(Size, messageText);
                } else {
                    System.out.println("OTP Found");
                    break;
                }
            }

            if (OTP.length() < 6) {
                System.out.println("---- Failed to retrieve OTP ----");
                getAppiumDriver().pressKey(new KeyEvent(AndroidKey.BACK));
                return "";
            } else {
                OTP = extractOTP(OTP);
            }

            if (OTP.length() == 0) {

            } else {

                System.out.println("OTP is: " + OTP);
            }
            getAppiumDriver().pressKey(new KeyEvent(AndroidKey.BACK));

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return OTP;
    }

    private String OTPloop(int size, List<AndroidElement> element) {
        System.out.println("Inside OTP Loop method");
        for (int i = 0; i < size; i++) {
            System.out.println("Current position = " + i);
            if (element.get(i).getText().contains("OTP is: ")) {
                return element.get(i).getText();
            }
        }
        return "";
    }

    //------------- extractOTP ----------------------------------------
    private String extractOTP(String OTP) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(OTP);
        while (m.find()) {
            System.out.println(m.group().length());
            System.out.println(m.group());
            if (m.group().length() == 4) {
                System.out.println("The OTP is: " + m.group());
                return m.group();
            }
        }
        return "";
    }

    public void waitUtl(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


//___________________Clear notification___________________________________________________

//    public void clearNotification() {
//        getAppiumDriver().openNotifications();
//        try {
//            MobileUtil.waitForElementToAppear(getAppiumDriver(), clearNoti);/// xpath of clear button
//            if (clearNoti.isDisplayed()) {
//                opt.click();
//            } else if (!clearNoti.isEnabled()) {
//                getAppiumDriver().pressKey(new KeyEvent(AndroidKey.BACK));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }