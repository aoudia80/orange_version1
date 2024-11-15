package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.record.formula.functions.T;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class Base {
    public static WebDriver driver;

    public static WebDriverWait wait;

    @Parameters({"browser", "url"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
    }
    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void takeScreenShot(String testName) {

        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + File.separator + "screen_shot" + File.separator +File.separator +testName+".png";
        try {
            FileUtils.copyFile(source, new File(path));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }
    @AfterMethod(alwaysRun = true)
    public void handleTestFailure(ITestResult result) {

        if (!result.isSuccess()){
            String testName=result.getName();
            takeScreenShot(testName);
        }
        driver.close();
        driver.quit();

    }
//    @AfterMethod
//    public void cleanUp() {
//        driver.close();
//        driver.quit();
//    }




}