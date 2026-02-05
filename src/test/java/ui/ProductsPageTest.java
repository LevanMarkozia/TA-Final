package ui;

import base.TestBase;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import utils.DriverFactory;

import java.awt.*;

public class ProductsPageTest extends TestBase {
    @Description("Verify that the products cases page is displayed and the product detail page works correctly")
    @Test
    public void test1() throws AWTException {
        WebDriver driver= DriverFactory.getDriver();
        driver.get("https://automationexercise.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        HomePage homePage=new HomePage(driver)
                .clickProducts();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/products");
        Assert.assertTrue(driver.findElement(By.className("features_items")).isDisplayed());
        ProductsPage productsPage=new ProductsPage(driver)
                .scrollDown(3)
                .clickDetails1();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/product_details/1");
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(.,\"Blue Top\")]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(.,\"Category\")]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(.,\"Rs. \")]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(.,\"Availability\")]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(.,\"Condition\")]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(.,\"Brand\")]")).isDisplayed());
    }
}
