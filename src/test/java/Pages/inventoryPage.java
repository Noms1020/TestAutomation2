package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class inventoryPage {

    WebDriver driver;
    WebDriverWait wait;


    //Constructor
    public inventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Learn']")
    WebElement LearnButton;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")
    WebElement LearnMaterialButton;
    @FindBy(xpath = "//*[@id=\"tab-btn-web\"]/span[2]")
    WebElement AdvanceAutomationButton;
    @FindBy(xpath = "//*[@id=\"deviceType\"]")
    WebElement dropDown;

    @FindBy(xpath = "//*[@id='device-preview']//*[name()='svg']//*[name()='rect'][2]")
    WebElement previewDevice;
    @FindBy(id = "brand")
    WebElement phoneBrand;
    @FindBy(xpath = "//*[@id=\"device-preview\"]/div/img")
    WebElement previewBrand;
    @FindBy(xpath = "//*[@id=\"storage-128GB\"]")
    WebElement storage;


    public void clickLearnButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LearnButton)).click();

    }

    public void clickLearnMaterial() {
        wait.until(ExpectedConditions.elementToBeClickable(LearnMaterialButton)).click();
    }
    public void clickAdvanceAutomationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdvanceAutomationButton)).click();
    }

    public void selectDeviceType() {
        wait.until(ExpectedConditions.elementToBeClickable(dropDown));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Phone");

    }

    public boolean isPhonePreviewDisplayed() {

        wait.until(ExpectedConditions.visibilityOf(previewDevice));
        return previewDevice.isDisplayed();
    }
    public void selectPhoneBrand(){
        wait.until(ExpectedConditions.elementToBeClickable(phoneBrand));
        Select select= new Select(phoneBrand);
        select.selectByVisibleText("Apple");
    }
    public boolean isBrandPreviewDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(previewBrand));
        return previewBrand.isDisplayed();
    }
    public  void selectStorage(){
        wait.until((ExpectedConditions.elementToBeClickable(storage)));
        storage.click();
    }




}
