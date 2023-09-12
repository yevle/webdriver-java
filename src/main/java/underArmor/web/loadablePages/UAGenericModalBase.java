package underArmor.web.loadablePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class UAGenericModalBase extends LoadableComponent<UAGenericModalBase> {

    private Class<? extends UAPageBase> returnPage;

    WebDriver driver;

    public UAGenericModalBase(WebDriver driver, Class<? extends UAPageBase> returnPage) {
        this.driver = driver;
        this.returnPage = returnPage;
        PageFactory.initElements(driver, this);
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

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

}
