package util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    protected static ThreadLocal<RemoteWebDriver> driverThread = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverThread.get() != null) {
            return driverThread.get();
        } else {
            WebDriverManager.chromedriver().setup();
            driverThread.set(new ChromeDriver());
        //    OptionsManager.getChromeOptions()
        }
        return driverThread.get();
    }

   public static void terminate() {
        driverThread.remove(); }
}

