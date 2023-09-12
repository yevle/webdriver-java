package underArmor.web.rawPages;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class UAModalBase {

    private Class<? extends UAPageBase> returnPage;

    private WebDriver driver;

    public UAModalBase(WebDriver driver, Class<? extends UAPageBase> returnPage) {
        this.driver = driver;
        this.returnPage = returnPage;
    }

    public UAPageBase getReturnPage() {
        try {
            Constructor<?extends UAPageBase> constructor = returnPage.getConstructor(WebDriver.class);
            return constructor.newInstance(driver);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}
