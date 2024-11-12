package system;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestLogin extends Base {
    //WebDriver driver;  // we don't need it because we extended the base class which inherit its methods
    String validUsername = "Admin";
    String validPassword = "admin123";
    HomePage homePage;

    String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    @Test
    public void validLogin() {

        homePage = new HomePage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        homePage.doLogin("Admin", "admin123");

        String actualUrl = driver.getCurrentUrl();
        //Assertion
        Assert.assertEquals(expectedUrl, actualUrl);
//        Assert.assertTrue(false);
    }

    @Test
    public void invalidLogin() {
        homePage = new HomePage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        homePage.doLogin("Admin", "");

        homePage.clickOnLogin();
        homePage.isRequiredMSGDisplay();
////        // assertion
        Assert.assertTrue(homePage.isRequiredMSGDisplay());
    }

    @AfterMethod
    public void cleanUp() {
        driver.close();
        driver.quit();
    }

}