package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    public static WebDriver getDriver(){
        return driver.get();
    }
    public static void initDriver(){
        ChromeOptions options=new ChromeOptions();
        options.addExtensions(new File("./Extensions/DDKJIAHEJLHFCAFBDDMGIAHCPHECMPFH_2026_125_1931_0.crx"));
        driver.set(new ChromeDriver(options));
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static void quitDriver(){
        if(driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
    }
}