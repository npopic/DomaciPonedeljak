package Tests;

import Base.BaseTest;
import Pages.AddRemoveElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestPages extends BaseTest {

    String username, password, expectedLogoutText, invalidUserName, invalidPassword;

    @BeforeMethod
    public void pageSetUp() {


        driver.get("https://the-internet.herokuapp.com/");

        username = "tomsmith";
        password = "SuperSecretPassword!";
        expectedLogoutText = "Welcome to the Secure Area. When you are done click logout below.";
        invalidPassword = "1efdwedw";
        invalidUserName = "djsdhid";

    }


    @Test(priority = 10)

    public void userCanLogIn() {
        welcomePage.clickOnFormAuthenticationPage();
        formAuthenticationPage.inputUserName(username);
        formAuthenticationPage.inputPassword(password);
        formAuthenticationPage.clickOnLoginButton();

        Assert.assertTrue(loggedInPage.getLogOutButton().isDisplayed());
        Assert.assertEquals(loggedInPage.getLoggedInText(), expectedLogoutText);
        Assert.assertEquals(driver.getCurrentUrl(), loggedInPage.getLoggedInURL());
    }


    @Test(priority = 20)

    public void userCanLogOut() {

        welcomePage.clickOnFormAuthenticationPage();
        formAuthenticationPage.inputUserName(username);
        formAuthenticationPage.inputPassword(password);
        formAuthenticationPage.clickOnLoginButton();
        Assert.assertTrue(loggedInPage.getLogOutButton().isDisplayed());
        loggedInPage.getLogOutButton().click();
        Assert.assertTrue(formAuthenticationPage.getLoginButton().isDisplayed());
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInPage.getLoggedInURL());

    }

    @Test(priority = 30)

    public void userCannotLoginWithInvalidUserName() {

        welcomePage.clickOnFormAuthenticationPage();
        formAuthenticationPage.inputUserName(invalidUserName);
        formAuthenticationPage.inputPassword(password);
        formAuthenticationPage.clickOnLoginButton();
        Assert.assertTrue(formAuthenticationPage.getLoginButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), formAuthenticationPage.LoginPageURL());

    }


    @Test(priority = 40)

    public void userCannotLoginWithInvalidPassword() {

        welcomePage.clickOnFormAuthenticationPage();
        formAuthenticationPage.inputUserName(username);
        formAuthenticationPage.inputPassword(invalidPassword);
        formAuthenticationPage.clickOnLoginButton();
        Assert.assertTrue(formAuthenticationPage.getLoginButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), formAuthenticationPage.LoginPageURL());

    }


    @Test(priority = 50)

    public void userCanAddElements() {

        welcomePage.clickOnAddRemoveElementsPage();

        Assert.assertFalse(AddRemoveElementsPage.isElementPresent(By.className("added-manually")));

        for (int i = 0; i < 3; i++) {
            addRemoveElementsPage.clickOnAddElementButton();
        }

        List<WebElement> elements = driver.findElements(By.className("added-manually"));
        for (WebElement delete : elements) {
            Assert.assertTrue(delete.isDisplayed());
        }

    }

    @Test(priority = 60)

    public void userCanRemoveElements() {

        welcomePage.clickOnAddRemoveElementsPage();

        Assert.assertFalse(AddRemoveElementsPage.isElementPresent(By.className("added-manually")));

        for (int i = 0; i < 3; i++) {
            addRemoveElementsPage.clickOnAddElementButton();

            Assert.assertTrue(addRemoveElementsPage.getDeleteButton().isDisplayed());}

        List<WebElement> elements = driver.findElements(By.className("added-manually"));
        for (WebElement delete : elements) {
            Assert.assertTrue(delete.isDisplayed());
            delete.click();

        }

        Assert.assertFalse(AddRemoveElementsPage.isElementPresent(By.className("added-manually")));

    }


}
