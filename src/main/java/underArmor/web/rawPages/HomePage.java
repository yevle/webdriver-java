package underArmor.web.rawPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import underArmor.web.rawPages.components.LoginModal;

public class HomePage extends UAPageBase {

    final WebDriver driver = getDriver();

    private By loginLink = By.cssSelector("button[class='HeaderUtility_header-account-link__v8ydu']");
    private By cookiesModal = By.id("truste-consent-track");
    private By cookiesAcceptBtn = By.id("truste-consent-button");

    private By myAccountBtn = By.id("my-account");

    private By countrySwitcher = By.id("country-switcher");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginModal clickLoginLink() {
        driver.findElement(loginLink).click();
        return new LoginModal(getDriver(), HomePage.class);
    }

    public HomePage acceptCookies() {
        if (driver.findElement(cookiesModal).isDisplayed())
            driver.findElement(cookiesAcceptBtn).click();
        return new HomePage(driver);
    }

    public boolean isLoggedIn() {
        WaitUntil.elementDisplayed(driver, myAccountBtn, 10000);
        return driver.findElement(myAccountBtn).getText().toLowerCase().contains("my account");
    }

    public void selectCountry(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(countrySwitcher));
    }


}
