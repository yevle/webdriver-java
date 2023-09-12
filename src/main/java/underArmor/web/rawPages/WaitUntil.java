package underArmor.web.rawPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class WaitUntil {

    public static void elementDisplayed(WebDriver driver, By elementLocator, long timeout) {
        try {
            synchronized (driver) {
                long startTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - startTime < timeout) {
                    try {
                        if (driver.findElement(elementLocator).isDisplayed()) {
                            return;
                        }
                    } catch (NoSuchElementException e) {
                        System.out.println("Element not found, continue waiting more " +
                                (timeout - (System.currentTimeMillis() - startTime)) / 1000);
                    }
                    driver.wait(500);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
