package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class DriverFactory {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
    }
    public static void initDriver(){
        ChromeOptions options=new ChromeOptions();
        options.addExtensions(new File("./Extensions/DDKJIAHEJLHFCAFBDDMGIAHCPHECMPFH_2026_125_1931_0.crx"));
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static void quitDriver(){
//        if(driver!=null){
//            driver.quit();
//            driver=null;
//        }
    }
}