package system;

import base.Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class TestSearchEmployee extends Base {
    @Test
    public void validSearchEmployee() throws IOException {
        HomePage homePage = new HomePage();
        EmployeePage employeePage = new EmployeePage();
        String employeeName = "Amelia Brown";
        homePage.doLogin("Admin", "admin123");
        employeePage.setClickPIM();

        employeePage.enterEmployeeName("Amelia Brown");

        employeePage.clickSearchButton();
        Assert.assertEquals(employeeName, "Amelia Brown");
        TakesScreenshot takeScreenshot= (TakesScreenshot) driver;
        File source=takeScreenshot.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+File.separator+"screen_shot"+File.separator+"validSearchEmployee.png";
        FileUtils.copyFile(source, new File(path));

    }

    @Test
    public void invalidSearchEmployee() throws IOException {
        HomePage homePage = new HomePage();
        EmployeePage employeePage = new EmployeePage();

        homePage.doLogin("Admin", "admin123");
        employeePage.setClickPIM();

        employeePage.enterEmployeeName("justTest");

        employeePage.clickSearchButton();
        //Assertion
        Assert.assertTrue(employeePage.isNoRecordsFoundMSGDisplayed());
        TakesScreenshot takeScreenshot= (TakesScreenshot) driver;
        File source=takeScreenshot.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+File.separator+"screen_shot"+File.separator+"invalidSearchEmployee.png";
        FileUtils.copyFile(source, new File(path));


    }
}

