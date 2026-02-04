package ui;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;
import utils.DriverFactory;

import java.awt.*;

public class RegisterExistingTest extends TestBase {
    @Description("Attempt to register an user using an existing account's email")
    @Test
    public void test1() throws AWTException {
        WebDriver driver=DriverFactory.getDriver();
        driver.get("https://automationexercise.com/");
        int dobMonth=6;
        String name="dohnjoe",email="hdfivhc7vh872htdj@mail.com";
        Assert.assertEquals(driver.findElement(By.xpath("//a[@style=\"color: orange;\"][@href=\"/\"]")).getText(),"Home");
        HomePage homePage=new HomePage(driver)
                .signupLogin();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()=\"New User Signup!\"]")).isDisplayed());
        LoginPage loginPage=new LoginPage(driver)
                .enterName(name)
                .enterEmail(email)
                .clickSignup();
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"Email Address already exist!\"]")).isDisplayed());
    }
}
