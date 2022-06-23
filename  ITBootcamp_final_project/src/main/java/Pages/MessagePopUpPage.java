package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {

    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForPopUpMessageToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("v-snack__content"))));
    }
    public WebElement unsuccessfullyLoginMessage() {
        return driver.findElement(By.tagName("li"));
    }
    public void waitForVerifyYourAccountToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("v-card__title"))));
    }
    public WebElement getTextFromVerifyYourAccountPopUp(){
        return driver.findElement(By.className("v-card__title"));
    }
    public WebElement getCloseButtoneFromVerifyYourAccount(){
        return driver.findElement(By.className("btnClose"));
    }
}
