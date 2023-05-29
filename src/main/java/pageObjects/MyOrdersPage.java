package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyOrdersPage extends AbstractComponent {
    WebDriver mDriver;


    @FindBy(xpath = "//tbody/tr/td[2]")
    List<WebElement> allCartItemNames;

    @FindBy(xpath = "//tbody/tr")
    WebElement orderedItemForCheckingwait;

    public MyOrdersPage(WebDriver mDriver) {
        super(mDriver);
        this.mDriver = mDriver;
        PageFactory.initElements(mDriver, this);
    }

    public List<WebElement> getAllOrderedItems() {
        waitTillElementVisibleUsingWebElement(orderedItemForCheckingwait);
        return allCartItemNames;
    }

    public boolean doesWebElementWithItemNameExist(String itemName) {
        return getAllOrderedItems().stream()
                .anyMatch(it -> it.getText().equalsIgnoreCase(itemName));
    }
}
