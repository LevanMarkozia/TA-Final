package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;

public class ContactPage extends BasePage{
    private By nameInput=By.xpath("//input[@data-qa=\"name\"]");
    private By emailInput=By.xpath("//input[@data-qa=\"email\"]");
    private By subjectInput=By.xpath("//input[@data-qa=\"subject\"]");
    private By messgageInput=By.xpath("//textarea[@data-qa=\"message\"]");
    private By fileInput=By.xpath("//input[@name=\"upload_file\"]");
    private By submitButton=By.xpath("//input[@data-qa=\"submit-button\"]");
    private By homeButton=By.xpath("//span[contains(.,\"Home\")]");
    public ContactPage(WebDriver driver) throws AWTException {
        super(driver);
    }
    public ContactPage fillContactForm(String name,String email,String subject,String message){
        type(nameInput,name);
        type(emailInput,email);
        type(subjectInput,subject);
        type(messgageInput,message);
        return this;
    }
    public ContactPage uploadFile(File file){
        upload(fileInput,file);
        return this;
    }
    public ContactPage clickSubmit(){
        click(submitButton);
        return this;
    }
    public ContactPage clickHome(){
        click(homeButton);
        return this;
    }
}
