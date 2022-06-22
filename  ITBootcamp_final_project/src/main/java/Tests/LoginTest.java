package Tests;

import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BasicTest {

    @Test(priority = 10)
    public void visitTheLoginPage() {
        navPage.getENbutton().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[Error] Page URL should contain '/login' ");

    }

    @Test(priority = 20)
    public void checksInputTypes() {
        navPage.getLoginButton().click();
        Assert.assertEquals(
                loginPage.getEmailInput().getAttribute("type"),
                "email",
                "[Error] Email input field should be  'email' by type"
        );
        Assert.assertEquals(
                loginPage.getPasswrodInput().getAttribute("type"),
                "password",
                "[Error] Password input field should be 'password' by type"
        );
    }

    @Test(priority = 30)
    public void displayErrorsWhenUserDoesNotExist(){
        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswrodInput().sendKeys(password);
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpMessageToBeVisible();

        Assert.assertEquals(messagePopUpPage.unsuccessfullyLoginMessage().getText(),
                "User does not exists",
                "[Error] Wrong error message for unsuccessfully login is displayed.");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[Error] Page URL should contain '/login' ");
    }

    @Test(priority = 40)
    public void displayErrorsWhenPassIsWrong(){
        String email = "admin@admin.com";
        String password = "password123";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswrodInput().sendKeys(password);
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpMessageToBeVisible();
        Assert.assertEquals(messagePopUpPage.unsuccessfullyLoginMessage().getText(),
                "Wrong password",
                "[Error] Wrong error message for wrong password login is displayed.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[Error] Page URL should contain '/login' ");
    }
    @Test(priority = 50)

    public void successfulLogin() throws InterruptedException {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswrodInput().sendKeys(password);
        loginPage.getLoginButton().click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "[Error] Page URL should contain '/home' ");;
    }
    @Test(priority = 60)
    public void logout (){
        navPage.visibilityOfLogoutButton();
        navPage.getLogoutButton().click();
    }



}
