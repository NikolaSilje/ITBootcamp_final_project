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


}
