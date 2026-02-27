package Utilities;

import com.sun.source.tree.IfTree;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browserFactory {

    static WebDriver driver;

    public static WebDriver startBrowser(String myBrowser,String url){

        if (myBrowser.equalsIgnoreCase("chrome")){
            driver= new ChromeDriver();
        } else if (myBrowser.equalsIgnoreCase("edge")) {
            driver=new EdgeDriver();

        }

        else {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;



    }

}
