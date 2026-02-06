package ui;

import base.TestBase;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DriverFactory;

import java.awt.*;

public class VerifySubscriptionHomeTest extends TestBase {
    @Description("Attempt to subscribe to the newsletter from the Home page")
    @Test
    public void test1() throws AWTException {
        WebDriver driver=DriverFactory.getDriver();
        String email="iahivuhcuyzcvni@mail.com";
        driver.get("https://automationexercise.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        HomePage homePage=new HomePage(driver)
                .scrollToBottom();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(.,\"Subscription\")]")).isDisplayed());
        homePage.subscribeToNewsletter(email);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(.,\"You have been successfully subscribed!\")]")).isDisplayed());
    }
}
