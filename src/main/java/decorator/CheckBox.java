package decorator;

import org.openqa.selenium.WebElement;

public class CheckBox extends AbstractElement {
    public CheckBox(WebElement webEle) {
        super(webEle);
    }
    public void setChecked(boolean shouldBeChecked){
        if(super.isSelected()&&!shouldBeChecked){
            super.click();
        }else{
            System.out.println("Element is already been checked"+shouldBeChecked);
        }
    }
}
