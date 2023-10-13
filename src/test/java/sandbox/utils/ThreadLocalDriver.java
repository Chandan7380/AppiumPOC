package sandbox.utils;

import org.openqa.selenium.WebDriver;

public class ThreadLocalDriver {
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private ThreadLocalDriver(){

    }
    public static synchronized void setTLDriver(WebDriver driver) {

        tlDriver.set(driver);

    }

    public static synchronized WebDriver getTLDriver() {
        return tlDriver.get();
    }
}
