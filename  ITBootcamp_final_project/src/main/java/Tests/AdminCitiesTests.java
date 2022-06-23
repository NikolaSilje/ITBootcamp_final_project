package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 10)

    public void visitsTheAdminCitiesPageAndListCitites() {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswrodInput().sendKeys(password);
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "[Error] Page URL should contain '/admin/cities' ");
    }

    @Test(priority = 20)
    public void checkInputTypesForCreateEditNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditOrCreateDialogToBeVisible();
        Assert.assertEquals(citiesPage.getInputName().getAttribute("type"),
                "text",
                "[Error] Name input field should be  'text' by type");
    }
    @Test(priority = 30)

    public void createNewCity(){
        String city = "Lost City";

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditOrCreateDialogToBeVisible();
        citiesPage.getInputName().sendKeys(city);
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForPopUpSavedSuccessfullySavedToBeVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromSuccessfullySavedMessage().getText().
                        contains("Saved successfully"),
                "[Error] Wrong message for successfully saved is displayed.");
    }
}
