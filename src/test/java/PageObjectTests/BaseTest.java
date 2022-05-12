package PageObjectTests;

import Pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import util.CustomTestListener;
import util.DriverManager;
import util.PropertiesReader;

import static io.github.bonigarcia.wdm.WebDriverManager.getInstance;
@Listeners(CustomTestListener.class)
public class BaseTest {
    @BeforeMethod
    public void testsSetUp(){
        DriverManager.setDriverThread();
    }
    @AfterMethod
    public void close(){
     DriverManager.getDriver().close();
    }
@AfterClass
    public void terminate(){
    DriverManager.terminate();
    }
}
