package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavPage {

    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getENbutton(){
        driver.findElement(By.className("btnLocaleActivation")).click();
        return driver.findElement(By.className("btnEN"));
    }

    public WebElement getESbutton() {
        driver.findElement(By.className("btnLocaleActivation")).click();
        return driver.findElement(By.className("btnES"));
    }
    public WebElement getFRbutton() {
        driver.findElement(By.className("btnLocaleActivation")).click();
        return driver.findElement(By.className("btnFR"));
    }
    public WebElement getCNbutton() {
        driver.findElement(By.className("btnLocaleActivation")).click();
        return driver.findElement(By.className("btnCN"));
    }

    public WebElement getLoginButton() {
        return this.driver.findElement(By.linkText("LOGIN"));
    }
    public WebElement getLogoutButton() {
        return this.driver.findElement(By.className("btnLogout"));
    }
    public void visibilityOfLogoutButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("btnLogout"))));
    }
    public WebElement getSignUpButton(){
        return driver.findElement(By.xpath("//*[contains(@class, 'v-toolbar__items')]/a[4]"));
    }
    public WebElement getLogOutButton(){
        return driver.findElement(By.className("btnLogout"));
    }
    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }
    public WebElement getCitiesButton(){
        return driver.findElement(By.className("btnAdminCities"));
    }
    public void waitForLoginPageToLoadUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));
    }
    public WebElement getHeaderElement(){
        return driver.findElement(By.tagName("h1"));
    }
    public WebElement getLanguageElement(){
       return driver.findElement(By.className("btnLocaleActivation"));

    }



}
