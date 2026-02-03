package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class LoginPage extends BasePage {
    private By nameInput=By.xpath("//input[@data-qa=\"signup-name\"]");
    private By emailInput=By.xpath("//input[@data-qa=\"signup-email\"]");
    private By signupButton=By.xpath("//button[@data-qa=\"signup-button\"]");
    private By loginEmailInput=By.xpath("//input[@data-qa=\"login-email\"]");
    private By loginPasswordInput=By.xpath("//input[@data-qa=\"login-password\"]");
    private By loginButton=By.xpath("//button[@data-qa=\"login-button\"]");
    public LoginPage(WebDriver driver) throws AWTException{
        super(driver);
    }
    public LoginPage enterName(String name){
        type(nameInput,name);
        return this;
    }
    public LoginPage enterEmail(String email){
        type(emailInput,email);
        return this;
    }
    public LoginPage clickSignup(){
        click(signupButton);
        return this;
    }
    public LoginPage loginEnterEmail(String email){
        type(loginEmailInput,email);
        return this;
    }
    public LoginPage loginEnterPassword(String password){
        type(loginPasswordInput,password);
        return this;
    }
    public LoginPage clickLogin(){
        click(loginButton);
        return this;
    }
}
