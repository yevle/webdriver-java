package base;

import org.testng.Assert;
import org.testng.annotations.Test;
import underArmor.web.loadablePages.HomePage;

public class MainMenuTest extends BaseTest{

    @Test
    public void HoverItemsTest() {

//        homePage = homePage.acceptCookies();
//        Assert.assertTrue(homePage.isHoverOverMenuWorks(),"Hover over menu item(s) not works.");

        Assert.assertTrue(homePage.getMainMenu().isHoverOverMenuWorks("Curry"),"Hover over menu item(s) not works.");

    }

}
