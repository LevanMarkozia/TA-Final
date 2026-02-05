package ui;

import base.TestBase;
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
        WebDriver driver=DriverFactory.getDriver();
        driver.get("https://automationexercise.com/");
        String email="hdfivhc7vh872htdj@mail.com",password="12345678";
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        HomePage homePage=new HomePage(driver)
                .signupLogin();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()=\"New User Signup!\"]")).isDisplayed());
        LoginPage loginPage=new LoginPage(driver)
                .loginEnterEmail(email)
                .loginEnterPassword(password)
                .clickLogin();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(.,\"Logged in as\")]")).isDisplayed());
        homePage.clickLogout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
    }
}
