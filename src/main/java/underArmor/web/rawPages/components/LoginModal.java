package underArmor.web.rawPages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import underArmor.web.rawPages.UAModalBase;
import underArmor.web.rawPages.UAPageBase;

public class LoginModal extends UAModalBase {

    WebDriver driver = getDriver();

    private By emailField = By.id("email-required");

    private By passwordFeild = By.id("password-required");

    private By rememberCheckbox = By.className("PrivateSwitchBase-input");

    private By loginBtn = By.cssSelector(".btn-primary[type]");

    private By userInfo = By.cssSelector("#navbarsExampleDefault span");

    public LoginModal(WebDriver driver, Class<? extends UAPageBase> returnPage) {
        super(driver, returnPage);
    }

    public UAPageBase logIn(String uname, String password) {
        driver.findElement(emailField).sendKeys(uname);
        driver.findElement(passwordFeild).sendKeys(password);
        if (!driver.findElement(rememberCheckbox).isSelected())
        {driver.findElement(rememberCheckbox).click();}
        getDriver().findElement(loginBtn).click();
        return getReturnPage();
    }

}
