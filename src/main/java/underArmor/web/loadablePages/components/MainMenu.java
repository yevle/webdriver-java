package underArmor.web.loadablePages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import underArmor.web.loadablePages.UAModalBase;

import java.util.List;
import java.util.stream.Collectors;

public class MainMenu extends UAModalBase {

    @FindBy(css = "#menu > li > a")
    private List<WebElement> menuItems;

    @FindBy(css = "#menu img.b-navigation_banner-image")
    private List<WebElement> menuItemImages;

    public MainMenu(WebDriver driver) {
        super(driver);
    }


    public boolean isHoverOverMenuWorks(String elementToFilter){
        List<WebElement> filteredMenuItems = menuItems.stream()
                .filter(i -> !i.getText().contains(elementToFilter))
                .collect(Collectors.toList());
        filteredMenuItems.forEach(i-> System.out.println(i.getText()));
        return filteredMenuItems.stream().allMatch(i -> {
            hoverOver(i);
            return menuItemImages.get(filteredMenuItems.indexOf(i)).isDisplayed();
        });
    }

}
