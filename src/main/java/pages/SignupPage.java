package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.Objects;

public class SignupPage extends BasePage{
    private By passwordInput=By.id("password");
    private By mr=By.xpath("//label[@for=\"id_gender1\"]");
    private By mrs=By.xpath("//label[@for=\"id_gender2\"]");
    private By dobDay=By.id("days");
    private By dobMonth=By.id("months");
    private By dobYear=By.id("years");
    private By newsletter=By.xpath("//label[@for=\"newsletter\"]");
    private By optin=By.xpath("//label[@for=\"optin\"]");
    private By fnameInput=By.id("first_name");
    private By lnameInput=By.id("last_name");
    private By companyInput=By.id("company");
    private By addressInput=By.id("address1");
    private By address2Input=By.id("address2");
    private By countrySelector=By.id("country");
    private By stateInput=By.id("state");
    private By cityInput=By.id("city");
    private By zipcodeInput=By.id("zipcode");
    private By mobileNumberInput=By.id("mobile_number");
    private By createAccountButton=By.xpath("//button[@data-qa=\"create-account\"]");
    private By continueButton=By.xpath("//a[@data-qa=\"continue-button\"]");

    public SignupPage(WebDriver driver) throws AWTException {
        super(driver);
    }
    public SignupPage selectTitle(String title){
        if(Objects.equals(title, "Mr.")){
            click(mr);
        }else if(Objects.equals(title, "Mrs.")){
            click(mrs);
        }
        return this;
    }
    public SignupPage enterDoB(String day,int month,String year){
        Select selectDay=new Select(wait.until(ExpectedConditions.elementToBeClickable(dobDay)));
        selectDay.selectByValue(day);
        Select selectMonth=new Select(wait.until(ExpectedConditions.elementToBeClickable(dobMonth)));
        selectMonth.selectByIndex(month);
        Select selectYear=new Select(wait.until(ExpectedConditions.elementToBeClickable(dobYear)));
        selectYear.selectByValue(year);
        return this;
    }
    public SignupPage enterDay(String day){
        Select select=new Select(driver.findElement(dobDay));
        select.selectByValue(day);
        return this;
    }
    public SignupPage enterMonth(int month){
        Select select=new Select(driver.findElement(dobMonth));
        select.selectByIndex(month);
        return this;
    }
    public SignupPage enterYear(String year){
        Select select=new Select(driver.findElement(dobYear));
        select.selectByValue(year);
        return this;
    }
    public SignupPage enterPassword(String password){
        type(passwordInput,password);
        return this;
    }
    public SignupPage optionalCheckmarks(){
        click(newsletter);
        click(optin);
        return this;
    }
    public SignupPage scrollDown(int n){
        scroll(n);
        return this;
    }
    public SignupPage enterData(String fname,String lname,String company,String address,String address2,String country,String state,String city,String zipcode,String mobileNumber){
        type(fnameInput,fname);
        type(lnameInput,lname);
        type(companyInput,company);
        type(addressInput,address);
        type(address2Input,address2);
        Select countrySelect=new Select(driver.findElement(countrySelector));
        countrySelect.selectByValue(country);
        type(stateInput,state);
        type(cityInput,city);
        type(zipcodeInput,zipcode);
        type(mobileNumberInput,mobileNumber);
        return this;
    }
    public SignupPage createAccount(){
        click(createAccountButton);
        return this;
    }
    public SignupPage clickContinue(){
        click(continueButton);
        return this;
    }
}
