package PageObjectTests;

import Pages.Page;
import bo.AddExpensiveItemToBasket;
import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.xml.bind.JAXBException;
import manager.PageFactoryManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.CustomTestListener;
import util.DriverManager;
import util.XMLStream;


import static java.lang.Integer.valueOf;
import static org.testng.Assert.assertTrue;

@Listeners(CustomTestListener.class)
public class BasketTest extends BaseTest {


    @DataProvider(name = "data-provider" ,parallel = true)
    public Object[][] dpMethod() throws  JAXBException {
     return XMLStream.useFilterData();
    }

   @Test(dataProvider = "data-provider" )
    public void notAtomicityMethod(String p1,String p3 , String p2) throws InterruptedException {
       AddExpensiveItemToBasket businessObjectForNAM = new AddExpensiveItemToBasket();
       businessObjectForNAM.addExpensiveItemToBasket(p1 ,p3 ,p2);
       assertTrue(valueOf(businessObjectForNAM.getSumOfGoods())<valueOf(p2));
    }

}
