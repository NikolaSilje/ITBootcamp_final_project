package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BasicTest {

    @Test(priority = 10)
    public void visitTheLoginPage(){
        navPage.getENbutton().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[Error] Page URL should contain '/login' ");

    }


}
