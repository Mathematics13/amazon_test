package browserfactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TestSuite extends BaseTest
{
    String baseUrl = "https://www.amazon.co.uk/";
    @Before
    public void setUp()
    {
        openBrowser(baseUrl);                                   //1. Open the url https://www.amazon.co.uk/
    }
    @Test
    public void dellLaptop() throws InterruptedException
    {
        //2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys("Dell Laptop");
        searchField.sendKeys(Keys.ENTER);                                                       //Click on search button right side that also works

        //3. Click on the checkbox brand Dell on the left side.
        WebElement dellCheckBox = driver.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']//i[@class='a-icon a-icon-checkbox'])[3]"));
        Thread.sleep(3000);
        dellCheckBox.click();

        //4. Verify that the  30(May be different) products are displayed on the page.
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']"));
        int count = products.size();
        System.out.println("Number of products  displayed" +count );

        //5. Print all product names in the console.
        List<WebElement> productNames = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (  WebElement names :  productNames )
        {
            System.out.println("Names of all products displayed: " +names.getText());
        }

        Thread.sleep(3000);

        //6. Click on the product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
         driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[12]")).click();

        //7. Verify the Product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
        //Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'

        String expectedText = "Dell XPS 15 9530 15.6\" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@id='productTitle']"));
        String actualText =  actualTextElement.getText();
        Assert.assertEquals("The user can see the name of the product displayed " ,expectedText, actualText);
    }
    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
