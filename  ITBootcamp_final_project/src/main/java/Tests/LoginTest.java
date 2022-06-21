package Tests;

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



}
