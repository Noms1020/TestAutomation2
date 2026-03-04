package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    WebDriver driver;
    WebDriverWait wait;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='app-main-content']//h2")
    WebElement WelcomeText;
    @FindBy(xpath = "//*[@id='app-root']/nav/div[1]/div[3]/button/span[2]")
    WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"login-email\"]") WebElement userNameField;
    @FindBy(xpath = "//*[@id=\"login-password\"]") WebElement passwordField;
    @FindBy(id = "login-submit") WebElement submitButton;



    public void clickloginbutton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void enterEmail(String email){

        wait.until(ExpectedConditions.visibilityOf(userNameField));
        userNameField.sendKeys(email);
    }

    public void enterPassword(String password){

        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }
    public void submit(){

        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),\"Here's who's working today\")]")));
    }

    public void AssertloginSeccess(String expectedMessage){

        WelcomeText.isDisplayed();
        String ActualText= WelcomeText.getText();
        if(!(ActualText.equals(expectedMessage))){
            throw new AssertionError("Expected text"+expectedMessage+"you got"+ActualText);
        }
    }




}
