package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.priority;

public class SignUpTest extends BasicTest {


    @Test(priority = 10)
    public void visitTheSignUpPage(){

        navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[Error] Page URL should contain '/signup' ");

    }

    @Test(priority = 20)
    public void checkInputTypes(){
        navPage.getSignUpButton().click();
        Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"),
                "email",
                "[Error] Email input field should be  'email' by type");
        Assert.assertEquals(signupPage.getPasswrodInput().getAttribute("type"),
                "password",
                "[Error] Password input field should be 'password' by type");
        Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("type"),
                "password",
                "[Error] Confirm password input field should be 'confirmPassword' by type");
    }
    @Test(priority = 30)

    public void displayErrorsWhenUserAlreadyExists(){
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[Error] Page URL should contain '/signup' ");

        signupPage.getNameInput().sendKeys(name);
        signupPage.getEmailInput().sendKeys(email);
        signupPage.getPasswrodInput().sendKeys(password);
        signupPage.getConfirmPasswordInput().sendKeys(confirmPassword);
        signupPage.getSigneMeUpButton().click();
        messagePopUpPage.waitForPopUpMessageToBeVisible();
        Assert.assertEquals(messagePopUpPage.unsuccessfullyLoginMessage().getText(),
                "E-mail already exists",
                "[Error] Proper error message is not displayed, it shoud be 'E-mail already exists'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[Error] Page URL should contain '/signup' ");


    }
}
