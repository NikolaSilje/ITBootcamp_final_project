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
}
