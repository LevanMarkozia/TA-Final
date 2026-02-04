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

public class LoginCorrectTest extends TestBase {
    @Description("Log in using valid credentials and delete the account")
    @Test
    public void test1() throws AWTException {
        WebDriver driver=DriverFactory.getDriver();
        driver.get("https://automationexercise.com/");
        String email="tempaccount192837465@mail.com",password="12345678";
        Assert.assertEquals(driver.findElement(By.xpath("//a[@style=\"color: orange;\"][@href=\"/\"]")).getText(),"Home");
        HomePage homePage=new HomePage(driver)
                .signupLogin();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()=\"New User Signup!\"]")).isDisplayed());
        LoginPage loginPage=new LoginPage(driver)
                .loginEnterEmail(email)
                .loginEnterPassword(password)
                .clickLogin();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(.,\"Logged in as\")]")).isDisplayed());
        homePage.deleteAccount()
                .clickContinue();
    }
}
