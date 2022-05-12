package manager;

import org.openqa.selenium.WebDriver;
import Pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public Page getHomePage() {
        return new Page(driver);
    }
    // add more pages dto?

}
