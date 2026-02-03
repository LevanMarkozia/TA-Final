package base;

import utils.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    @BeforeMethod
    public void setup(){
        DriverFactory.initDriver();
    }
    @AfterMethod
    public void teardown(){
        DriverFactory.quitDriver();
    }
}
