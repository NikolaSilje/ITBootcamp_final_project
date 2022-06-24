package Tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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
        String city = "Nikola Vasiljevic's city";

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
    @Test(priority = 40)
    public void editCity(){
        String oldCity = "Nikola Vasiljevic's city";
        String newCity = "Nikola Vasiljevic's city Edited";


        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInput().sendKeys(oldCity);
        citiesPage.waitNewRowToAppear(1);
        citiesPage.getEditButton(1).click();
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .click()
                .sendKeys(newCity)
                .perform();
        citiesPage.waitSaveButtonToBeVisible();
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForPopUpSavedSuccessfullySavedToBeVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromSuccessfullySavedMessage().getText().
                        contains("Saved successfully"),
                "[Error] Wrong message for successfully saved is displayed.");


    }

    @Test(priority = 50)
    public void searchCity(){
        String cityName = "Nikola Vasiljevic's city Edited";
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInput().sendKeys(cityName);
        citiesPage.waitNewRowToAppear(1);
        Assert.assertTrue(citiesPage.getTableCell(1, 2).getText().contains(cityName),
                "[Error] - City does not exist.");
    }

    @Test(priority = 60)
    public void deleteCity(){
        String cityName = "Nikola Vasiljevic's city Edited";
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInput().sendKeys(cityName);
        citiesPage.waitNewRowToAppear(1);
        Assert.assertEquals(citiesPage.getTableCell(1, 2).getText(),
                cityName,
                "[ERROR] - City that you searched for does not exist.");
        citiesPage.getDeleteButtonForRow(1).click();
        citiesPage.waitForDialogueToBeVisible();
        citiesPage.getDeleteFromDialogue().click();
        Assert.assertTrue(
                messagePopUpPage.getTextFromDialogue().getText().contains("Deleted successfully"),
                "[Error] Wrong message for successfully saved is displayed.");

    }
}
