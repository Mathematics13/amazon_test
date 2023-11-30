package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;

public class BaseTest
{
    static String browser = "Chrome";
    public static WebDriver driver;
    public void openBrowser(String baseUrl)
    {
        if(browser.equalsIgnoreCase("Chrome"))
        {
            driver= new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Edge"))
        {
            driver= new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("Firefox"))
        {
            driver= new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Safari"))
        {
            driver = new SafariDriver();
        }
        else
        {
            System.out.println("Wrong browser name");
        }
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    public void closeBrowser()
    {
        driver.quit();
    }
}
