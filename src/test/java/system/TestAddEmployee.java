package system;

import base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class TestAddEmployee extends Base {
    @Test(priority = 0)
    public void addEmployee() throws IOException {
        HomePage homePage = new HomePage();
        EmployeePage employerPage = new EmployeePage();
        homePage.doLogin("Admin", "admin123");
        String lastName = "test";
        String firstName = "peter";
        String employeeName = firstName + " " + lastName;

        employerPage.setClickPIM();

        employerPage.setClickAdd();

        employerPage.enterName(firstName);

        employerPage.enterMiddleName(lastName);

        employerPage.enterLastname("LastNameTest");

        employerPage.setClickSave();


        Assert.assertEquals(employeeName, "peter test");
        TakesScreenshot takeScreenshot= (TakesScreenshot) driver;
        File source=takeScreenshot.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+File.separator+"screen_shot"+File.separator+"AddEmployee_Screen_Shot.png";
        FileUtils.copyFile(source, new File(path));


    }

    @Test
    public void addEmployeeWithoutFirstName() throws IOException {
        HomePage homePage = new HomePage();
        // String firstName = "peter";

        String lastName = "test";
        EmployeePage employerPage = new EmployeePage();

        homePage.doLogin("Admin", "admin123");

        employerPage.setClickPIM();

        employerPage.setClickAdd();

        //employerPage.enterName(firstName);
        employerPage.enterMiddleName(lastName);
        employerPage.enterLastname("LastNameTest");

        employerPage.setClickSave();
        //span[text()='Required']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //span[text()='Required']")));
        Assert.assertTrue(employerPage.isRequiredMSG());
        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
        File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + File.separator + "screen_shot" + File.separator + "addEmployeeWithoutFirstName_Screen_Shot.png";
        FileUtils.copyFile(source, new File(path));


    }

}