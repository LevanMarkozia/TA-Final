package ui;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;

import java.awt.*;

public class RegisterExistingTest extends TestBase {
    @Description("Attempt to register an user using an existing account's email")
    @Test
    public void test1() throws AWTException {
        Allure.step("Open the home page");
        WebDriver driver=DriverFactory.getDriver();
        driver.get("https://automationexercise.com/");
        int dobMonth=6;
        String name="dohnjoe",email="hdfivhc7vh872htdj@mail.com";
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        Allure.step("Go to the signup/login page");
        HomePage homePage=new HomePage(driver)
                .signupLogin();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()=\"New User Signup!\"]")).isDisplayed());
        Allure.step("Attempt to register using an existing account's email address");
        LoginPage loginPage=new LoginPage(driver)
                .enterName(name)
                .enterEmail(email)
                .clickSignup();
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"Email Address already exist!\"]")).isDisplayed());
    }
}
