package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Base {

    // WebDriver driver; // it will be the intermediate between the java code and the browser
    // we don't need it because we extended the base class which inherit its methods

    // web element
    @FindBy(name = "username")
    WebElement inputUsername;
    @FindBy(name = "password")
    WebElement inputPassword;
    @FindBy(xpath = "//button")
    WebElement loginButton;
    @FindBy(xpath = "//span[text()='Required']")
    WebElement requiredMSG;
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement selectLogOutOption;

    // constructor
    public HomePage() { // the constructor is how we define our object of class
        //this.driver = driver;
        PageFactory.initElements(driver, this); // the page factory is going to replace the use
        //        // of FindElement and FindElements
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        enterText(inputUsername, username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        enterText(inputPassword, password);

    }

    public void clickOnLogin() {
        clickOnElement(loginButton);

    }

    public boolean isRequiredMSGDisplay() {
        return requiredMSG.isDisplayed();
    }

    public void clickOnLogOut() {
        clickOnElement(selectLogOutOption);
    }

    public void doLogin(String username, String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        enterUsername(username);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        enterPassword(password);
        clickOnLogin();
    }

}