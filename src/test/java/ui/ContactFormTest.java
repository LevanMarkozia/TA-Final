package ui;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;
import utils.DriverFactory;

import java.awt.*;
import java.io.File;

public class ContactFormTest extends TestBase {
    @Description("Fill the Contact Us form and verify that the process is successful")
    @Test
    public void test1() throws AWTException {
        Allure.step("Open the home page");
        WebDriver driver=DriverFactory.getDriver();
        driver.get("https://automationexercise.com/");
        String name="name",email="dahfivzcuhjfhj@mail.com",subject="subject",message="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse laoreet luctus bibendum. Pellentesque suscipit finibus metus, ac finibus nisi facilisis quis. Curabitur euismod sem nec neque mattis molestie. Nulla et rutrum ipsum, in tincidunt massa. Nullam efficitur ante at vulputate sollicitudin. Mauris aliquet mattis est, sed egestas diam vulputate vel. Nullam consequat molestie commodo. Aliquam dignissim ac diam id tincidunt. Fusce nisi velit, aliquam ac rutrum volutpat, vehicula sed dui. Sed quis lectus et nunc rutrum consequat. Nullam elementum elementum lacus ac tempus. Nulla sed mauris nisi. Cras quis bibendum odio.";
        File uploadFile=new File("src/test/resources/img/image.png");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        Allure.step("Go to the Contact Us page");
        HomePage homePage=new HomePage(driver)
                .clickContactUs();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()=\"Get In Touch\"]")).isDisplayed());
        Allure.step("Fill and submit the Contact Us form");
        ContactPage contactPage=new ContactPage(driver)
                .fillContactForm(name,email,subject,message)
                .uploadFile(uploadFile)
                .clickSubmit();
        Allure.step("Verify that the form was submitted successfully");
        Alert alert=driver.switchTo().alert();
        alert.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()=\"Success! Your details have been submitted successfully.\"]")).isDisplayed());
        Allure.step("Return to the home page");
        contactPage.clickHome();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
    }
}
