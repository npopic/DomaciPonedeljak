package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {
    WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFormAuthenticationPage() {
       return driver.findElement(By.linkText("Form Authentication"));
    }

    public WebElement getAddRemoveElementsPage(){

        return driver.findElement(By.linkText("Add/Remove Elements"));
    }

    /////----------

    public void clickOnFormAuthenticationPage(){
        getFormAuthenticationPage().click();
    }

    public void clickOnAddRemoveElementsPage(){ getAddRemoveElementsPage().click();}
}
