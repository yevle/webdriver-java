package underArmor.web.rawPages;

import org.openqa.selenium.WebDriver;

public abstract class UAPageBase {

    private WebDriver driver;

    public UAPageBase() {
    }

    public UAPageBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
