package Base;

import Utilities.browserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Pages.loginPage;
import Pages.inventoryPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class baseTest {



    browserFactory browserFactory = new browserFactory();

    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String myBrowser = "chrome";
    public final WebDriver driver = browserFactory.startBrowser(myBrowser, url);


    public loginPage loginPage = new loginPage(driver);


    public inventoryPage inventorypage = new inventoryPage(driver);


//    @BeforeTest
//    public void setUp() {
//        driver = browserFactory.startBrowser(myBrowser, url);
//        //loginPage loginPage = new loginPage(driver);
//        //inventoryPage inventorypage = new inventoryPage(driver);
//    }

}