package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class registerToNdosiWebsite {

    WebDriver driver;
    WebElement dropdown;
    Select select;
@Test
    public void registerToPlayground(){
        driver= new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[contains(.,'Login')]")).click();
        driver.findElement(By.id("signup-toggle")).click();
        driver.findElement(By.id("register-firstName")).sendKeys("Azande");
        driver.findElement(By.id("register-lastName")).sendKeys("Mdhluli");
        driver.findElement(By.id("register-email")).sendKeys("aza@gmail.com");
        driver.findElement(By.id("register-password")).sendKeys("azi123@2");
        driver.findElement(By.id("register-confirmPassword")).sendKeys("azi123@2");
        dropdown= driver.findElement(By.id("register-group"));
        select= new Select(dropdown);
        select.selectByVisibleText("1st Group 2026 (2026)");
        driver.findElement(By.id("register-submit")).click();
    }
}
