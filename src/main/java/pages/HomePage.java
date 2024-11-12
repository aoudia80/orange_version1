package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    public HomePage()  { // the constructor is how we define our object of class
        //this.driver = driver;
        PageFactory.initElements(driver, this); // the page factory is going to replace the use
        //        // of FindElement and FindElements
    }

    public void enterUsername(String username) {
        //inputUsername.sendKeys(username);
        enterText(inputUsername, username);
    }

    public void enterPassword(String password) {
        enterText(inputPassword, password);
        // inputPassword.sendKeys(password);
    }

    public void clickOnLogin() {
        //clickOnElement(inputUsername);
        loginButton.click();
    }
    ////
    public boolean isRequiredMSGDisplay() {
        return requiredMSG.isDisplayed();
    }
    //
//
    public void selectLogOut() {
        selectLogOutOption.click();
    }
    //
//    public void enterEmployeeName() {
//        inputEmployeeName.sendKeys("Amelia Brown");
//    }
//
//    public void clickSearchButton() {
//        clickSearch.click();
//    }
    public void doLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickOnLogin();


    }
//
//    public AccountPage doLogin(String username, String password) {
//        enterUsername(username);
//        enterPassword(password);
//        clickOnLogin();
//        return new AccountPage();
//    }

}