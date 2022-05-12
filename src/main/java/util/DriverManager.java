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
    private static final String URL = new PropertiesReader().getUrl();
    public static WebDriver getDriver() {
            return driverThread.get();
        }

public static void setDriverThread(){
    WebDriverManager.chromedriver().setup();
        driverThread.set(new ChromeDriver());
    DriverManager.getDriver().manage().window().maximize();
    DriverManager.getDriver().get(URL);
}

    public static void terminate() {
        driverThread.remove(); }
}

