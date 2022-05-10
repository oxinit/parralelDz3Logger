package PageObjectTests;

import Pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import manager.PageFactoryManager;

import model.Filters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.CustomTestListener;


import java.io.File;

import static java.lang.Integer.valueOf;
import static org.testng.Assert.assertTrue;

@Listeners(CustomTestListener.class)
public class BasketTest extends BaseTest {
//dat provider

    @DataProvider(name = "data-provider" ,parallel = true)
    public Object[][] dpMethod() throws  JAXBException {
      //  return new Object[][] {{"Laptop", "500000" }, {"Hp", "500002"}, {"Hp", "500002"}, {"Hp", "500002"}};
        File file = new File("src/main/resources/filter.xml");
        JAXBContext jaxbConText = JAXBContext.newInstance(Filters.class);

        Unmarshaller unmarshal =jaxbConText.createUnmarshaller();
        Filters searchFilters =(Filters) unmarshal.unmarshal(file);

        Object[][] searchFilterArray =
                searchFilters.getSearchFilterList()
                        .stream().map(
                                x-> new Object[]{
                                        x.getProduct(),x.getBrandCheckBox(),x.getMaxSum()
                                }).toArray(Object[][]::new);
        return searchFilterArray;
    }

   @Test
           (dataProvider = "data-provider" )
   // @Parameters({"prop1","prop2"})
    public void notAtomicityMethod(String p1,String p3 , String p2) throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       WebDriver d1 = new ChromeDriver();
       d1.get("https://rozetka.com.ua");
       super.driver1=d1;
       PageFactoryManager pageFactoryManager = new PageFactoryManager(driver1);
        Page page = pageFactoryManager.getHomePage();
        page.searchFieldSendKeys(p1);
        page.clickFindButton();
        page.expensiveSortClick();
        page.hpCHeckBoxClick();
        page.firstElementClick();
        page.buyClick();
        assertTrue(valueOf(page.checkSumOfGoods())<valueOf(p2));
        d1.close();



    }
// <parameter name="prop1" value="Laptop" />
   //     <parameter name="prop2" value="1000000"/>
/*
    @Test
    public void notAtomicityMethod2() throws InterruptedException {
        getPage().searchFieldSendKeys("ASUS");
        getPage().clickFindButton();
        getPage().expensiveSortClick();
        getPage().hpCHeckBoxClick();
        getPage().firstElementClick();
        getPage().buyClick();
        assertTrue(valueOf(getPage().checkSumOfGoods())<valueOf(500000));
    }


 */


}
