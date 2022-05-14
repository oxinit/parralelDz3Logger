package decorator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Button  {
    WebElement f;
    public Button(WebElement webEle) {
      f=webEle;
    }

public void safeClick(){
    try{
        f.click();
    }catch(ElementClickInterceptedException exception){
        f.click();
    }
}

}
