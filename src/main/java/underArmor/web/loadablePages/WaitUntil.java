package underArmor.web.loadablePages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitUntil {

    public static void elementDisplayed(WebDriver driver, WebElement element, long timeout) {
        try {
            synchronized (driver) {
                long startTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - startTime < timeout) {
                    try {
                        if (element.isDisplayed()) {
                            return;
                        }
                    } catch (NoSuchElementException e) {
                        System.out.printf("Element not found, continue waiting more %s seconds%n",
                                (timeout - (System.currentTimeMillis() - startTime)) / 1000);
                    }
                    driver.wait(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
