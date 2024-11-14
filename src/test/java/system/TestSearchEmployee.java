package system;

import base.Base;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.HomePage;

public class TestSearchEmployee extends Base {
    @Test
    public void validSearchEmployee() {
        HomePage homePage = new HomePage();
        EmployeePage employeePage = new EmployeePage();
        String employeeName = "Amelia Brown";
        homePage.doLogin("Admin", "admin123");
        employeePage.setClickPIM();

        employeePage.enterEmployeeName("Amelia Brown");

        employeePage.clickSearchButton();
        Assert.assertEquals(employeeName, "Amelia Brown");

    }

    @Test
    public void invalidSearchEmployee() {
        HomePage homePage = new HomePage();
        EmployeePage employeePage = new EmployeePage();

        homePage.doLogin("Admin", "admin123");
        employeePage.setClickPIM();

        employeePage.enterEmployeeName("justTest");

        employeePage.clickSearchButton();
        //Assertion
        Assert.assertTrue(employeePage.isNoRecordsFoundMSGDisplayed());


    }
}

