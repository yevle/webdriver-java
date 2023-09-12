package underArmor.web.rawPages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiesModal {

    private WebDriver driver;
    private By acceptBtn = By.id("LoginLink");

    public CookiesModal(WebDriver driver){
        this.driver=driver;
    }

}
