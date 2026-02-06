package base;

import org.testng.ITestResult;
import utils.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ScreenshotUtil;

public class TestBase {
    @BeforeMethod
    public void setup(){
        DriverFactory.initDriver();
    }
    @AfterMethod
    public void teardown(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            ScreenshotUtil.attachScreenshot(DriverFactory.getDriver(),"Screenshot on failure");
        }
        DriverFactory.quitDriver();
    }
}
