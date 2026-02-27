package Tests;
import Base.baseTest;
import jdk.jfr.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Pages.loginPage;

public class loginTest extends baseTest{

    //protected loginPage loginPage;
    //public loginPage loginPage = PageFactory.initElements(driver,loginPage.class);

    @Test
 //   @Description("Login to Ndosi Website with valid credentials")
    public void loginWithValidCredentialss()throws InterruptedException{

        loginPage.clickloginbutton();
        Thread.sleep(2000);
        loginPage.enterEmail("noms@gmail.com");
        Thread.sleep(2000);
        loginPage.enterPassword("Password@2");
        Thread.sleep(2000);
        loginPage.submit();
        //driver.quit();
    }


}


