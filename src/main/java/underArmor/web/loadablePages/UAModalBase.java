package underArmor.web.loadablePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class UAModalBase {

    WebDriver driver;

    public UAModalBase(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverOver(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

}
