package Tests;


import Base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class inventoryTest extends baseTest {

    @Test(priority = 1)

    public void callLogin() throws InterruptedException {

        loginPage.clickloginbutton();
        Thread.sleep(2000);
        loginPage.enterEmail("noms@gmail.com");
        Thread.sleep(2000);
        loginPage.enterPassword("Password@2");
        loginPage.submit();
        //loginPage.AssertloginSeccess("Welcome back, Noms! \uD83D\uDC4B");
    }

    @Test(dependsOnMethods = "callLogin")
    public void accessLearningMaterials() {

        inventorypage.clickLearnButton();
        inventorypage.clickLearnMaterial();
        inventorypage.clickAdvanceAutomationButton();

    }

    @Test(dependsOnMethods ="accessLearningMaterials" )
    public void VerifyIventryFormIsDisplayed(){
        Assert.assertTrue(
                inventorypage.IventryFormIsDisplayed(),"Inventory form is not displayed"
        );
        System.out.println("User is directed to Inventory form after clicking the AdvanceLearning button");

    }

    @Test(priority = 2, dependsOnMethods = "accessLearningMaterials")
    public void SelectPhoneAndVerifyPreview() {

        Assert.assertTrue(
                inventorypage.IsPhonebrandDisabled(),"Brand dropdown should be DISABLED before selecting a device type"
        );
        System.out.println("Brand dropdown is disabled before device type is selected");
        inventorypage.selectDeviceType();

        Assert.assertTrue(
                inventorypage.isPhonePreviewDisplayed(),
                "Phone preview was NOT displayed after selecting Phone from the dropdown"
        );

        System.out.println(" Phone selected and preview is displayed");

        Assert.assertTrue(
                inventorypage.IsPhonebrandEnabled(),"Brand dropdown should be enabled after selecting the devive"
        );
        System.out.println("Brand dropdown is enabled after selecting device");
    }

    @Test(priority = 3, dependsOnMethods = "SelectPhoneAndVerifyPreview")
    public void SelectBrandAndVerifyBrand() {
        inventorypage.selectPhoneBrand();
        inventorypage.isBrandPreviewDisplayed();
        

        Assert.assertTrue(
                inventorypage.isBrandPreviewDisplayed(), "Brand preview was not displayed after selecting a brand"
        );
        System.out.println("Brand selected and brand preview displayed");

    }
    @Test(priority = 4)
    public void SelectStorageAndVerifySelection(){

        inventorypage.selectStorage();
        Assert.assertTrue(
                inventorypage.SelectedStorageIsDisplayed(),"Selected storage preview  was not displayed displayed"
        );
        System.out.println("Selected storage preview is displayed");
        
    }
@Test(priority = 5)
    public void SelectDeviceColorAndVerifySelection(){

        inventorypage.DeviceColor();
        Assert.assertTrue(
                inventorypage.VerifySelectedColor(),"Selected color was not displayed"
        );
        System.out.println("Selected color preview is displayed");
    }

    @Test(priority = 6, dependsOnMethods = "SelectDeviceColorAndVerifySelection")
    public void verifyAddressDisabledThenEnterQuantityAndAddress() {
        Assert.assertTrue(
                inventorypage.isAddressFieldDisabled(),
                "Address field should be DISABLED before quantity is entered"
        );
        System.out.println("Address field is disabled before quantity is entered");


        inventorypage.enterQuantityAndAddress("2", "123 Koedoe Street");
    }
@Test(priority = 7)
    public void verifyUnitPriceAndSubtotal(){
       inventorypage.AssertUnitpriceAndSubtotalVelues();
        System.out.println("Unit price R480.00 and subtotal R960.00");

    }
    @Test(priority = 8)
    public void  NextbuttonTakesUserToPriceBreakdown()
    {
        inventorypage.NavigateToPriceBreakdown();
        Assert.assertTrue(
                inventorypage.IsPriceBreakdownDispalyed(),"Price breakdown is not displayed"
        );
        System.out.println("Price breakdown is displayed");
    }


}
