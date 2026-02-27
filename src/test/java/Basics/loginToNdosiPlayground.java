package Basics;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginToNdosiPlayground {
    WebDriver driver;
    WebElement welcomeText;

    WebElement dropdown;
    Select select;
    WebElement loginButton;
    WebDriverWait wait;
    String buttonText;
    String loginErrorMessage;


    @Test(priority = 1)
    @Description("Login to Ndosi website,positive test")
    public void loginWithValidDetails() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[contains(.,'Login')]")).click();
        driver.findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys("aza@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys("azi123@2");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(1000);
        welcomeText = driver.findElement(By.xpath("//main[@id='app-main-content']/section/div/h2"));
        Assert.assertTrue(welcomeText.isDisplayed());


    }

    @Test(priority = 2)
    @Description("Access learning material page")
    public void selectLearningMaterial() throws InterruptedException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(., 'Web Automation Basic Form')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("Nontando");
        driver.findElement(By.id("email")).sendKeys("aza@gmail.com");
        driver.findElement(By.id("age")).sendKeys("20");
        dropdown=driver.findElement(By.id("gender"));
        select=new Select(dropdown);
        select.selectByVisibleText("Female");
        dropdown=driver.findElement(By.id("country"));
        select=new Select(dropdown);
        select.selectByVisibleText("Canada");
        dropdown= driver.findElement(By.id("experience"));
        select=new Select(dropdown);
        select.selectByVisibleText("Beginner (0-1 years)");


    }



}


