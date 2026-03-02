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
import org.testng.Assert;

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
    @FindBy(id = "tab-btn-web")
    WebElement AdvanceAutomationButton;
    @FindBy(xpath = "//*[@id=\"inventory-title\"]")
    WebElement InventoryFormLabel;

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
    @FindBy(xpath = "//div[@id='device-preview']//div[3]//strong[2]")
    WebElement StorageConfirmation;
    @FindBy(id = "color")
    WebElement SelectColorDropdown;
    @FindBy(xpath = "//*[@id=\"device-preview\"]/div/div/div[3]/strong[1]")
    WebElement ColorAssertion;
    @FindBy(id = "quantity")
    WebElement DeviceQuantity;
    @FindBy(id="address")
    WebElement DeliveryAddress;
    @FindBy(id = "unit-price-value")
    WebElement UnitPrice;
    @FindBy(id="subtotal-value")
    WebElement Subtotal;
    @FindBy(id="inventory-next-btn")
    WebElement Nexbutton;
    @FindBy(id="pricing-breakdown-title")
    WebElement breakdownLabel;



    public void clickLearnButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LearnButton)).click();

    }

    public void clickLearnMaterial() {
        wait.until(ExpectedConditions.elementToBeClickable(LearnMaterialButton)).click();
    }
    public void clickAdvanceAutomationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdvanceAutomationButton)).click();
    }
    public boolean IventryFormIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(InventoryFormLabel));
        return InventoryFormLabel.isDisplayed();
    }

    public boolean IsPhonebrandDisabled(){
        wait.until(ExpectedConditions.visibilityOf(phoneBrand));
        return !phoneBrand.isEnabled();
    }
    public boolean IsPhonebrandEnabled()
    {
        wait.until(ExpectedConditions.visibilityOf(phoneBrand));
        return phoneBrand.isEnabled();
    }
    public void selectDeviceType() {
        wait.until(ExpectedConditions.elementToBeClickable(dropDown));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Phone");

    }public boolean isPhonePreviewDisplayed() {

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
    public boolean SelectedStorageIsDisplayed()
    {
        wait.until((ExpectedConditions.visibilityOf(StorageConfirmation)));
        return StorageConfirmation.isDisplayed();
    }
    public void DeviceColor(){
        wait.until(ExpectedConditions.visibilityOf(SelectColorDropdown));
        wait.until(ExpectedConditions.visibilityOf(SelectColorDropdown));
        Select select=new Select(SelectColorDropdown);
        select.selectByVisibleText("Blue");
    }
    public boolean VerifySelectedColor(){
        wait.until(ExpectedConditions.visibilityOf(ColorAssertion));
        return ColorAssertion.isDisplayed();
    }

    public boolean isAddressFieldDisabled() {

        wait.until(ExpectedConditions.visibilityOf(DeliveryAddress));
        return !DeliveryAddress.isEnabled();
    }
    public void enterQuantityAndAddress(String quantity, String address) {

        wait.until(ExpectedConditions.visibilityOf(DeviceQuantity));
        wait.until(ExpectedConditions.elementToBeClickable(DeviceQuantity));
        DeviceQuantity.clear();
        DeviceQuantity.sendKeys(quantity);

        wait.until(ExpectedConditions.elementToBeClickable(DeliveryAddress));
        DeliveryAddress.clear();
        DeliveryAddress.sendKeys(address);
    }

    public void AssertUnitpriceAndSubtotalVelues(){
        wait.until((ExpectedConditions.visibilityOf(UnitPrice)));
        String ActualUnitPrice= UnitPrice.getText().trim();

        wait.until(ExpectedConditions.visibilityOf(Subtotal));
        String ActualSubtotal= Subtotal.getText().trim();

        Assert.assertTrue(ActualUnitPrice.contains("R480.00"),"Unit price is wrong, you expected R480.00 but you got"+ActualUnitPrice
        );
        Assert.assertTrue(ActualSubtotal.contains("R960.00"),"Subtotal is wrong, you expected R960.00 but you got"+ActualSubtotal
        );

    }
    public void NavigateToPriceBreakdown()
    {
        wait.until(ExpectedConditions.visibilityOf(Nexbutton));
        wait.until(ExpectedConditions.elementToBeClickable(Nexbutton));
        Nexbutton.click();
    }

    public boolean IsPriceBreakdownDispalyed(){
        wait.until(ExpectedConditions.visibilityOf(breakdownLabel));
        return Boolean.parseBoolean(breakdownLabel.getText());
    }



}
