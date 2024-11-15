package system;

import base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class TestLogin extends Base {
    //WebDriver driver;  // we don't need it because we extended the base class which inherit its methods
    HomePage homePage;

    String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    @Test
    public void validLogin() throws IOException {

        homePage = new HomePage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        homePage.doLogin("Admin", "admin123");

        String actualUrl = driver.getCurrentUrl();
        //Assertion
        Assert.assertEquals(expectedUrl, actualUrl);
        TakesScreenshot takeScreenshot= (TakesScreenshot) driver;
        File source=takeScreenshot.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+File.separator+"screen_shot"+File.separator+"validLogin_Shot.png";
        FileUtils.copyFile(source, new File(path));

    }

    @Test
    public void invalidLogin() throws IOException {
        homePage = new HomePage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        homePage.doLogin("Admin", "");


        homePage.isRequiredMSGDisplay();
////        // assertion
        Assert.assertTrue(homePage.isRequiredMSGDisplay());
        TakesScreenshot takeScreenshot= (TakesScreenshot) driver;
        File source=takeScreenshot.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+File.separator+"screen_shot"+File.separator+"invalidLogin_Shot.png";
        FileUtils.copyFile(source, new File(path));
    }


}