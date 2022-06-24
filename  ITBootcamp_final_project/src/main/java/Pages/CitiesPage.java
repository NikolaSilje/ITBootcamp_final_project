package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {

    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.className("btnNewItem"));
    }

    public void waitForEditOrCreateDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("v-card__title"))));
    }

    public WebElement getInputName() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getSaveButton() {
        return driver.findElement(By.className("btnSave"));
    }

    public WebElement getSearchInput() {
        return driver.findElement(By.id("search"));
    }

    public void waitNewRowToAppear(int rowNum) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), rowNum + 1));
    }
    public WebElement getEditButton(int rowIndex) {
        return this.driver.findElements(By.id("edit")).get(rowIndex - 1);
    }
    public WebElement getTableCell(int rowIndex, int columnIndex) {
        return this.driver.findElement(By.xpath("//tbody/tr[" + rowIndex + "]/td[" + columnIndex + "]"));
    }
    public WebElement getDeleteButtonForRow(int rowIndex) {
        return this.driver.findElements(By.id("delete")).get(rowIndex - 1);
    }
    public void waitForDialogueToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("py-3")));
    }
    public WebElement getDeleteFromDialogue(){
    return  driver.findElement(By.xpath("//*[contains(@class, 'v-card__actions')]//button[2]"));
    }
    public void waitSaveButtonToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(getSaveButton()));
    }



}
