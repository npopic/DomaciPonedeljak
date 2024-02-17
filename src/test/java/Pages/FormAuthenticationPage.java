package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormAuthenticationPage {

    WebDriver driver;

    WebElement userNameBox;
    WebElement passwordBox;
    WebElement loginButton;
    String userName, password, invalidUserName, invalidPassword;

    public FormAuthenticationPage(WebDriver driver){

        this.driver=driver;
    }

    public WebElement getUserNameBox(){
        return driver.findElement(By.id("username"));

    }
   public WebElement getPasswordBox(){
        return driver.findElement(By.id("password"));
   }



    public WebElement getLoginButton() {
        return driver.findElement(By.className("radius"));
    }


    public String LoginPageURL(){

        return "https://the-internet.herokuapp.com/login";
    }

//--------------

    public void inputUserName(String name){
        getUserNameBox().clear();
        getUserNameBox().sendKeys(name);
    }

public void inputPassword(String password){
        getPasswordBox().clear();
        getPasswordBox().sendKeys(password);



}

public void clickOnLoginButton(){

        getLoginButton().click();
}



}
