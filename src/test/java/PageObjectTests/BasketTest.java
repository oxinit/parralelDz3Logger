package PageObjectTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import util.CustomTestListener;

import static java.lang.Integer.valueOf;
import static org.testng.Assert.assertTrue;

@Listeners(CustomTestListener.class)
public class BasketTest extends BaseTest {

    @Test
    @Parameters({"prop1","prop2"})
    public void notAtomicityMethod(String p1, String p2) throws InterruptedException {
        getPage().searchFieldSendKeys(p1);
        getPage().clickFindButton();
        getPage().hpCHeckBoxClick();
        getPage().expensiveSortClick();
        getPage().firstElementClick();
        getPage().buyClick();
        assertTrue(valueOf(getPage().checkSumOfGoods())<valueOf(p2));

    }

}
