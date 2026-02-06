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

public class LogoutTest extends TestBase {
    @Description("Log into an account, log out and verify that the login page is displayed")
    @Test
    public void test1() throws AWTException {
        Allure.step("Open the home page");
        WebDriver driver=DriverFactory.getDriver();
        driver.get("https://automationexercise.com/");
        String email="hdfivhc7vh872htdj@mail.com",password="12345678";
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        Allure.step("Go to the signup/login page");
        HomePage homePage=new HomePage(driver)
                .signupLogin();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()=\"New User Signup!\"]")).isDisplayed());
        Allure.step("Log in using valid credentials");
        LoginPage loginPage=new LoginPage(driver)
                .loginEnterEmail(email)
                .loginEnterPassword(password)
                .clickLogin();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(.,\"Logged in as\")]")).isDisplayed());
        Allure.step("Log out and verify that the signup/login page is opened");
        homePage.clickLogout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
    }
}
