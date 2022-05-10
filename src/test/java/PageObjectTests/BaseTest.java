package PageObjectTests;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import util.CustomTestListener;
import util.DriverManager;
import util.PropertiesReader;

import static io.github.bonigarcia.wdm.WebDriverManager.getInstance;
@Listeners(CustomTestListener.class)
public class BaseTest {
    WebDriver driver1;
    private static final String URL = new PropertiesReader().getUrl();
  //  @BeforeMethod
    public void testsSetUp(){
    driver1 = DriverManager.getDriver();
    driver1.manage().window().maximize();
    driver1.get(URL);
    }

    //@AfterMethod
    public void close(){
        driver1.close();
        driver1.quit();
        DriverManager.terminate();
    }

    public WebDriver getDriver(){return driver1;}
    public Page getPage(){return new Page(getDriver());}

}
