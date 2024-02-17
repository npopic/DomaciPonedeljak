package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddRemoveElementsPage {

    static WebDriver driver;



    WebElement deleteButton;
    WebElement addElementButton;

    public AddRemoveElementsPage(WebDriver driver) {
        AddRemoveElementsPage.driver = driver;
    }

    public WebElement getAddElementButton() {
        addElementButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        return addElementButton;
    }

    public WebElement getDeleteButton() {
        return driver.findElement(By.className("added-manually"));
    }

    public static boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

//--------------

    public void clickOnAddElementButton() {

        getAddElementButton().click();

    }

public void clickOnDeleteButton(){

        getDeleteButton().click();
}
}
