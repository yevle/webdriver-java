package base;

import org.testng.Assert;
import org.testng.annotations.Test;
import underArmor.web.loadablePages.HomePage;

public class LoginTest extends BaseTest {

    private String email = "s.grysh@gmail.com";
    private String password = "Password1!";

    @Test
    public void testSuccessfulLogin() throws InterruptedException {

        homePage = (HomePage)homePage.acceptCookies().clickLoginLink().logIn(email, password);
        Assert.assertTrue(homePage.isLoggedIn(),"Application is not logged in.");

    }

}
