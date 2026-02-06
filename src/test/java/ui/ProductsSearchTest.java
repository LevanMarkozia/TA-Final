package ui;

import base.TestBase;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import utils.DriverFactory;

import java.awt.*;

public class ProductsSearchTest extends TestBase {
    @Description("Verify that product search works correctly")
    @Test
    public void test1() throws AWTException {
        WebDriver driver=DriverFactory.getDriver();
        String query="Bl";
        driver.get("https://automationexercise.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        HomePage homePage=new HomePage(driver)
                .clickProducts();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/products");
        ProductsPage productsPage=new ProductsPage(driver)
                .search(query);
        for(WebElement x:driver.findElements(By.cssSelector(".product-image-wrapper .productinfo p"))){
            Assert.assertTrue(x.getText().toLowerCase().contains(query.toLowerCase()));
        }
    }
}
