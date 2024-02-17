package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedInPage {

    WebDriver driver;

    WebElement logOutButton;




    String loggedInURL,loggedInText;

    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.cssSelector(".button.secondary.radius"));
    }

    public String getLoggedInText(){

         WebElement actualText = driver.findElement(By.className("subheader"));
         return actualText.getText();

    }

    public String getLoggedInURL() {
        return "https://the-internet.herokuapp.com/secure";
    }



    //----------------

    public void clickOnLogOutButton(){

        logOutButton.click();
    }


}
