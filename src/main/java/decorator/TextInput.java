package decorator;

import org.openqa.selenium.WebElement;

public class TextInput extends AbstractElement {
    public TextInput(WebElement webEle) {
        super(webEle);
    }
    public void sendKeys(String cSeque){
        webEle.clear();
        super.sendKeys(cSeque);
    }
}
