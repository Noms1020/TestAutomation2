package Tests;
import Base.baseTest;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Pages.loginPage;

import java.time.Duration;

public class loginTest extends baseTest{


    @Test

    public void loginWithValidCredentialss(){

        loginPage.clickloginbutton();
        loginPage.enterEmail("noms@gmail.com");
        loginPage.enterPassword("Password@2");
        loginPage.submit();
        //driver.quit();
    }


}


