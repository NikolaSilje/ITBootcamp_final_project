package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {

    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getPasswrodInput(){
        return driver.findElement(By.id("password"));
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }

    public WebElement getConfirmPasswordInput(){
        return driver.findElement(By.id("confirmPassword"));
    }
    public WebElement getNameInput(){
        return driver.findElement(By.id("name"));
    }

}
