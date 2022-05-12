package decorator;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button extends AbstractElement {
    public Button(WebElement webEle) {
        super(webEle);
    }
    @Override
    public void click(){
        webEle.click();
    }
    public void safeClick(){
        try{
            super.click();
        }catch(ElementClickInterceptedException exception){
            super.click();
        }
    }
}
