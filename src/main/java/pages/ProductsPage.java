package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class ProductsPage extends BasePage {
    private By details1Button=By.xpath("//a[@href=\"/product_details/1\"][contains(.,\"View Product\")]");
    public ProductsPage(WebDriver driver) throws AWTException{
        super(driver);
    }
    public ProductsPage clickDetails1(){
        click(details1Button);
        return this;
    }
    public ProductsPage scrollDown(int n){
        scroll(n);
        return this;
    }
}
