package system;

import base.Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class TestLogOut extends Base {
    @Test
    public void testValidLogOut() throws InterruptedException, IOException {
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        HomePage homePage = new HomePage();

        homePage.doLogin("Admin", "admin123");
        AccountPage accountPage = new AccountPage();

        accountPage.clickOnDropdown();
        homePage.clickOnLogOut();
        String actualUrl = driver.getCurrentUrl();
//        //Assertion

        Assert.assertEquals(expectedUrl, actualUrl);
        TakesScreenshot takeScreenshot= (TakesScreenshot) driver;
        File source=takeScreenshot.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+File.separator+"screen_shot"+File.separator+"testValidLogOut.png";
        FileUtils.copyFile(source, new File(path));

    }
}
