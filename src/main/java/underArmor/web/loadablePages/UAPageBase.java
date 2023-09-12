package underArmor.web.loadablePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class UAPageBase extends LoadableComponent<UAPageBase> {

    WebDriver driver;

    public UAPageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverOver(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
    }

}
