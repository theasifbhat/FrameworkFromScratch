package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver mDriver;



public AbstractComponent(WebDriver mDriver){
this.mDriver= mDriver;
}

public void waitTillElementVisible(By locator){
    WebDriverWait webDriverWait = new WebDriverWait(mDriver,Duration.ofSeconds(6));
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

public void waitTillElementInvisible(WebElement element){
    WebDriverWait webDriverWait = new WebDriverWait(mDriver,Duration.ofSeconds(6));
    webDriverWait.until(ExpectedConditions.invisibilityOf(element));
}



}
