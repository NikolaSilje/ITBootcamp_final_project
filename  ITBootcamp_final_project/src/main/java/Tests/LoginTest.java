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
                driver.findElement(By.id("email")).getAttribute("type"),
                "email",
                "[Error] Email input field attribute type should be - email"
        );
        Assert.assertEquals(
                driver.findElement(By.id("password")).getAttribute("type"),
                "password",
                "[Error] Email input field should be email by type"
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
    //
//    Test #4: Displays errors when password is wrong
//    Podaci:
//    email: admin@admin.com
//    password: password123
//    Koraci:
//    Klik na login dugme iz navigacije
//    Popuniti login formu podacima za logovanje
//    Klik na login dugme
//    Sacekati da popu za prikaz poruke bude vidljiv
//    Verifikovati da greska sadrzi poruku Wrong password
//    Verifikovati da se u url-u stranice javlja /login ruta
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
    //Test #5: Login
    //Podaci:
    //email: admin@admin.com
    //password: 12345
    //Koraci:
    //Klik na login dugme iz navigacije
    //Popuniti login formu podacima za logovanje
    //Verifikovati da se u url-u stranice javlja /home ruta
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
