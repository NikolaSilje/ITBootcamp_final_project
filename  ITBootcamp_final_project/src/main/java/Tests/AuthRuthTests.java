package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRuthTests extends BasicTest {
    @Test(priority = 10)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/home");
        navPage.waitForLoginPageToLoadUp();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

    @Test(priority = 20)
    public void forbidsVisitsToprofileUrlifNotauthenticated() {
        driver.get(baseUrl + "/profile");
        navPage.waitForLoginPageToLoadUp();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

    @Test(priority = 30)
    public void forbidsVisitsToAdminCitiesUrlifNotAuthenticated() {
        driver.get(baseUrl + "//admin/cities");
        navPage.waitForLoginPageToLoadUp();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");

    }

    @Test(priority = 40)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl + "//admin/users");
        navPage.waitForLoginPageToLoadUp();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

    
}
