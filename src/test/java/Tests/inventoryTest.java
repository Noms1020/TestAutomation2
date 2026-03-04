package Tests;


import Base.baseTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class inventoryTest extends baseTest {


    @Test
    public void callLogin() {

        loginPage.clickloginbutton();
        loginPage.enterEmail("noms@gmail.com");
        loginPage.enterPassword("Password@2");
        loginPage.submit();
        //loginPage.AssertloginSeccess("Welcome back, Noms! \uD83D\uDC4B");
    }

    //@AfterTest
    @Test(priority = 1, dependsOnMethods = "callLogin()")
    public void accessLearningMaterials() {

        inventorypage.clickLearnButton();
        inventorypage.clickLearnMaterial();
        inventorypage.clickAdvanceAutomationButton();

    }

    @Test(dependsOnMethods = "accessLearningMaterials")
    public void VerifyIventryFormIsDisplayed() {
        Assert.assertTrue(
                inventorypage.IventryFormIsDisplayed(), "Inventory form is not displayed"
        );
        System.out.println("User is directed to Inventory form after clicking the AdvanceLearning button");

    }

    @Test(priority = 2, dependsOnMethods = "accessLearningMaterials")
    public void SelectPhoneAndVerifyPreview() {

        Assert.assertTrue(
                inventorypage.IsPhonebrandDisabled(), "Brand dropdown should be DISABLED before selecting a device type"
        );
        System.out.println("Brand dropdown is disabled before device type is selected");
        inventorypage.selectDeviceType();

        Assert.assertTrue(
                inventorypage.isPhonePreviewDisplayed(),
                "Phone preview was NOT displayed after selecting Phone from the dropdown"
        );

        System.out.println(" Phone selected and preview is displayed");

        Assert.assertTrue(
                inventorypage.IsPhonebrandEnabled(), "Brand dropdown should be enabled after selecting the devive"
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
    public void SelectStorageAndVerifySelection() {

        inventorypage.selectStorage();
        Assert.assertTrue(
                inventorypage.SelectedStorageIsDisplayed(), "Selected storage preview  was not displayed displayed"
        );
        System.out.println("Selected storage preview is displayed");

    }

    @Test(priority = 5)
    public void SelectDeviceColorAndVerifySelection() {

        inventorypage.DeviceColor();
        Assert.assertTrue(
                inventorypage.VerifySelectedColor(), "Selected color was not displayed"
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
    public void verifyUnitPriceAndSubtotal() {
        inventorypage.AssertUnitpriceAndSubtotalVelues();
        System.out.println("Unit price R480.00 and subtotal R960.00");

    }

    @Test(priority = 8)
    public void NextbuttonTakesUserToPriceBreakdown() {
        inventorypage.NavigateToPriceBreakdown();
        Assert.assertTrue(
                inventorypage.IsPriceBreakdownDispalyed(), "Price breakdown is not displayed"
        );
        System.out.println("Price breakdown is displayed");
    }

    @Test(priority = 9)
    public void selectShippingMethod_VerifyAddedAmount() {
        inventorypage.SelectShipping();
        Assert.assertTrue(
                inventorypage.ExpressAssertion(), "Express shipping price NOT displayed"
        );
        System.out.println("R25 added for express shipping");
    }

    @Test(priority = 10)
    public void selectDeviceWarranty_VerifyAddedAmount() {
        inventorypage.SelectWarranty();
        Assert.assertTrue(
                inventorypage.WarrantyAssertion(), "Inventory price is NOT displayed"
        );
        System.out.println("R49 added for 1year warranty");
    }

    @Test(priority = 11)
    public void VerifyDiscountIsAppliedAndTotalIsUpdated() {

        inventorypage.EnterDiscount("SAVE10");
        inventorypage.ApplyDiscount();


        Assert.assertTrue(
                inventorypage.IsDiscountApplied(),
                "Discount feedback label is NOT displayed after applying discount"
        );
        System.out.println("Discount feedback label is displayed");


        Assert.assertTrue(
                inventorypage.IsDiscountedTotalPriceDisplayed("R930.60"),
                "Total price does NOT reflect the discounted amount"
        );
        System.out.println("Total price is showing the discounted amount of - R103.40");
    }
    @Test(priority = 12)
    public void VerifyOrderProcessedAndToasterIsDisplayed(){
        inventorypage.clickPurchaseBtn();
        Assert.assertTrue(
                inventorypage.IsSuccessMessageDisplayed(),"Success Toaster Message is NOT displayed"
        );
        System.out.println("Success toaster message IS displayed");
    }


}
