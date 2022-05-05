package PageObjectTests;

import PageObject.Page;
import decorator.AbstractElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import util.PropertiesReader;
import util.WebDriverSingleton;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    WebDriver driver1;
    String url = new PropertiesReader().getUrl();
   // WebDriver driver1= WebDriverSingleton.getInstance();


    @BeforeTest
               public void setUp(){chromedriver().setup();}
    @BeforeMethod
    public void testsSetUp(){
        driver1=new ChromeDriver();
         driver1.manage().window().maximize();
        driver1.get(url);
    }
    @AfterMethod
    public void tearDown(){
        driver1.close();
    }
    @AfterClass
    public WebDriver getDriver(){
        return driver1;
    }
    public Page getPage(){
        return new Page(getDriver());
    }

}
