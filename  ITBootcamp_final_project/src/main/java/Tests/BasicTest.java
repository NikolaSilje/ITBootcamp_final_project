package Tests;

import Pages.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;

public abstract class BasicTest {
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected SignUpPage signupPage;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;


    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        citiesPage = new CitiesPage(driver);
        loginPage = new LoginPage(driver);
        messagePopUpPage = new MessagePopUpPage(driver);
        navPage = new NavPage(driver);
        signupPage = new SignUpPage(driver);

    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }



    @AfterClass
    public void afterClass() {
    driver.quit();
    }


}
