package Tests;


import Base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Tests.loginTest;
import Pages.loginPage;
import Pages.inventoryPage;

public class inventoryTest extends baseTest {



    @Test(priority = 1)
    public void callLogin()throws InterruptedException {

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
    @Test(priority = 2,dependsOnMethods = "accessLearningMaterials")
    public void SelectPhoneAndVerifyPreview(){
        inventorypage.selectDeviceType();

        Assert.assertTrue(
                inventorypage.isPhonePreviewDisplayed(),
                "Phone preview was NOT displayed after selecting Phone from the dropdown"
        );

        System.out.println(" Phone selected and preview is displayed");
    }
    @Test(priority = 3,dependsOnMethods = "SelectPhoneAndVerifyPreview")
    public void SelectBrandAndVerifyBrand(){
        inventorypage.selectPhoneBrand();
        inventorypage.isBrandPreviewDisplayed();
        inventorypage.selectStorage();

     Assert.assertTrue(
               inventorypage.isBrandPreviewDisplayed(),"Brand preview was not displayed after selecting a brand"
        );
        System.out.println("Brand selected and brand preview displayed");

    }


}
