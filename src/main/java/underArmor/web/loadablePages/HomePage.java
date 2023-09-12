package underArmor.web.loadablePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import underArmor.web.loadablePages.components.LoginGenericModal;
import underArmor.web.loadablePages.components.MainMenu;

import java.time.Duration;
import java.util.List;

public class HomePage extends UAPageBase {

    @FindBy(css = "button[class='HeaderUtility_header-account-link__v8ydu']")
    private WebElement loginLink;

    @FindBy(id = "truste-consent-track")
    private WebElement cookiesModal;
    @FindBy(id = "truste-consent-button")
    private WebElement cookiesAcceptBtn;

    @FindBy(id = "my-account")
    private WebElement myAccountBtn;

    @FindBy(id = "country-switcher")
    private WebElement countrySwitcher;

    @FindBy(css = "#menu > li")
    private List<WebElement> menuItems;

    @FindBy(css = "#menu img.b-navigation_banner-image")
    private List<WebElement> menuItemImages;

    @FindBy(id = "menu")
    private MainMenu mainMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginGenericModal clickLoginLink() {
        loginLink.click();
        return new LoginGenericModal(getDriver(), HomePage.class);
    }

    public HomePage acceptCookies() {
        if (cookiesModal.isDisplayed())
            cookiesAcceptBtn.click();
        return new HomePage(driver);
    }

    public boolean isLoggedIn() {
//        WaitUntil.elementDisplayed(driver, myAccountBtn, 10000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(myAccountBtn));
        return myAccountBtn.getText().toLowerCase().contains("my account");
    }

    public void selectCountry(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    private Select findDropDownElement(){
        return new Select(countrySwitcher);
    }

    public boolean isHoverOverMenuWorks(){
        return menuItems.stream().allMatch(i->{
            hoverOver(i);
            return menuItemImages.get(menuItems.indexOf(i)).isDisplayed();
        });
    }

    public MainMenu getMainMenu(){
        return mainMenu = new MainMenu(driver);
    }

}
