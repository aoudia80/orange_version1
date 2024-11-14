package system;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.HomePage;

public class TestAddEmployee extends Base {
    @Test(priority = 0)
    public void addEmployee() {
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


    }

    @Test
    public void addEmployeeWithoutFirstName() {
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


    }

}