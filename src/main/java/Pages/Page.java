package Pages;
import decorator.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;
import util.CustomMethodInvokedListener;

import java.util.List;

@Listeners(CustomMethodInvokedListener.class)
public class Page extends BasePage{
    @FindBy(xpath = "//button[contains(@class,'cookie')]")
    private Button AcceptCookieAndClose;
    @FindBy(xpath = "//a[@data-id='HP']")///parent::li[contains(@class,"filter")]
    private Button hpCheckBoxClick;
    @FindBy(xpath = "//option[contains(text(),\"От дорогих\")]")
    private Button expensiveSort;
    @FindBy(xpath = "//rz-catalog//div[@data-goods-id]")
    private List<WebElement> firstElementOfQuery;
    @FindBy(xpath = "//span[text()=' Купить ']/ancestor::button[@aria-label='Купить']/ancestor::li")
    private WebElement buyButton;
    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']/span")
    private WebElement totalCartSum;
    @FindBy(xpath = "//p[@data-testid='cost']"
          //  "//span[text()=' В корзине ']"
    )
    private WebElement BasketButton;

    public Page(WebDriver driver) {
        super(driver);
    }
    public void hpCHeckBoxClick() throws InterruptedException {
        Thread.sleep(500);
        waitForPageLoading(20);
       // waitVisibilityOfElement(30,hpCheckBoxClick);
        hpCheckBoxClick.safeClick();
    }
    public void expensiveSortClick(){
        waitForPageLoading(30);
        //waitVisibilityOfElement(30,expensiveSort);
       expensiveSort.safeClick();
    }

    public void firstElementClick() throws InterruptedException {
        Thread.sleep(500);
        waitForPageLoading(20);
       waitVisibilityOfElement(60,firstElementOfQuery.get(1));
        firstElementOfQuery.get(1).click();
    }

    public void buyClick(){
        waitForPageLoading(30);
        waitVisibilityOfElement(60,buyButton);
        Actions ac = new Actions(driverFather);
        ac.moveToElement(driverFather.findElement(By.xpath("//span[text()=' Купить ']/ancestor::button[@aria-label='Купить']/ancestor::li"))).build().perform();
        buyButton.click();
    }

    public void buyBasketClick(){
        BasketButton.click();
    }

    public String checkSumOfGoods(){
       waitVisibilityOfElement(60,totalCartSum);
       return totalCartSum.getText();
    }
}
