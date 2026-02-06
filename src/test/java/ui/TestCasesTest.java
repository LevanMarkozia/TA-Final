package ui;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DriverFactory;

import java.awt.*;

public class TestCasesTest extends TestBase {
    @Description("Verify that the test cases page is displayed")
    @Test
    public void test1() throws AWTException {
        Allure.step("Open the home page");
        WebDriver driver=DriverFactory.getDriver();
        driver.get("https://automationexercise.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        Allure.step("Go to the test cases page");
        HomePage homePage=new HomePage(driver)
                .clickTestCases();
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()=\"Test Cases\"]")).isDisplayed());
    }
}
