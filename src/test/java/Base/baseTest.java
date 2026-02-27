package Base;

import Utilities.browserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import  Pages.loginPage;
import Pages.inventoryPage;
import org.testng.annotations.BeforeMethod;

public class baseTest {



    browserFactory browserFactory=new browserFactory();

    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public  final String myBrowser ="chrome";
    public  final WebDriver driver = browserFactory.startBrowser(myBrowser,url);

    public loginPage loginPage = PageFactory.initElements(driver,loginPage.class);

    //public inventoryPage inventoryPage = PageFactory.initElements(driver,inventoryPage.class);
    public  inventoryPage inventorypage= new inventoryPage(driver);



}