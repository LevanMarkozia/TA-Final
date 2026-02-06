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
import pages.SignupPage;
import utils.DriverFactory;

import java.awt.*;

public class RegisterUserTest extends TestBase {
    @Description("Register a new user, verify that the process is successful and delete the account")
    @Test
    public void test1() throws AWTException {
        Allure.step("Open the home page");
        WebDriver driver=DriverFactory.getDriver();
        driver.get("https://automationexercise.com/");
        int dobMonth=6;
        String fname="Levan",lname="Markozia",email="levanmarkozia@mail.com",title="Mr.",password="12345678",dobDay="3",dobYear="2006",company="Company",address="Street Street 123",address2="Bldg.456 Apt.789",country="Australia",state="State",city="City",zipcode="12345",mobileNumber="123456789";
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        Allure.step("Go to the signup/login page");
        HomePage homePage=new HomePage(driver)
                .signupLogin();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()=\"New User Signup!\"]")).isDisplayed());
        Allure.step("Enter the name and email and go to the signup page");
        LoginPage loginPage=new LoginPage(driver)
                .enterName(fname+" "+lname)
                .enterEmail(email)
                .clickSignup();
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()=\"Enter Account Information\"]")).isDisplayed());
        Allure.step("Enter account information and create the account");
        SignupPage signupPage=new SignupPage(driver)
                .enterPassword(password)
                .selectTitle(title)
                .enterDoB(dobDay,dobMonth,dobYear)
                .optionalCheckmarks()
                .scrollDown(8)
                .enterData(fname,lname,company,address,address,country,state,city,zipcode,mobileNumber)
                .createAccount();
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()=\"Account Created!\"]")).isDisplayed());
        signupPage.clickContinue();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(.,\"Logged in as "+fname+" "+lname+"\")]")).isDisplayed());
        Allure.step("Delete the account");
        homePage.deleteAccount()
                .clickContinue();
    }
}
