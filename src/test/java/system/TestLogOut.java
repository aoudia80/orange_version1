package system;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;

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


    }
}
