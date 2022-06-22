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
}
