package underArmor.web.loadablePages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import underArmor.web.loadablePages.UAGenericModalBase;
import underArmor.web.loadablePages.UAPageBase;

public class LoginGenericModal extends UAGenericModalBase {

    @FindBy (id = "email-required")
    private WebElement emailField;

    @FindBy (id="password-required")
    private WebElement passwordFeild;

    @FindBy(className = "PrivateSwitchBase-input")
    private WebElement rememberCheckbox;

    @FindBy(css = ".btn-primary[type]")
    private WebElement loginBtn;

    @FindBy(css = "#navbarsExampleDefault span")
    private WebElement userInfo;

    public LoginGenericModal(WebDriver driver, Class<? extends UAPageBase> returnPage) {
        super(driver, returnPage);
    }

    public underArmor.web.loadablePages.UAPageBase logIn(String uname, String password) {
        emailField.sendKeys(uname);
        passwordFeild.sendKeys(password);
        if (!rememberCheckbox.isSelected())
        {rememberCheckbox.click();}
        loginBtn.click();
        return getReturnPage();
    }

}
