package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Robot robot;
    public BasePage(WebDriver driver) throws AWTException {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        this.robot=new Robot();
    }
    protected void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    protected void type(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
    protected void typeAlert(String text){
        wait.until(ExpectedConditions.alertIsPresent()).sendKeys(text);
    }
    protected void enter(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(Keys.ENTER);
    }
    protected String getText(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
    protected void scroll(int amount){
        robot.mouseWheel(amount);
    }
    protected void selectAll(By locator){
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
}
