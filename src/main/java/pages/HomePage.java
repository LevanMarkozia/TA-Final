package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class HomePage extends BasePage{
    private By signupLoginButton=By.xpath("//a[@href=\"/login\"]");
    private By deleteAccountButton=By.xpath("//a[@href=\"/delete_account\"]");
    private By continueButton=By.xpath("//a[@data-qa=\"continue-button\"]");
    private By logoutButton=By.xpath("//a[@href=\"/logout\"]");
    private By contactUsButton=By.xpath("//a[@href=\"/contact_us\"]");
    private By testCasesButton=By.xpath("//a[@href=\"/test_cases\"]");
    private By productsButton=By.xpath("//a[@href=\"/products\"]");
    private By subscriptionInput=By.id("susbscribe_email");
    private By subscriptionButton=By.id("subscribe");
    public HomePage(WebDriver driver) throws AWTException {
        super(driver);
    }
    public HomePage signupLogin(){
        click(signupLoginButton);
        return this;
    }
    public HomePage deleteAccount(){
        click(deleteAccountButton);
        return this;
    }
    public HomePage clickContinue(){
        click(continueButton);
        return this;
    }
    public HomePage clickLogout(){
        click(logoutButton);
        return this;
    }
    public HomePage clickContactUs(){
        click(contactUsButton);
        return this;
    }
    public HomePage clickTestCases(){
        click(testCasesButton);
        return this;
    }
    public HomePage clickProducts(){
        click(productsButton);
        return this;
    }
    public HomePage scrollToBottom(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
        return this;
    }
    public HomePage subscribeToNewsletter(String email){
        type(subscriptionInput,email);
        click(subscriptionButton);
        return this;
    }
}
