package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmployeePage extends Base {
    public EmployeePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='PIM']")
    WebElement clickPIM;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement clickAdd;
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement inputFirstName;
    @FindBy(xpath = "//input[@name='middleName']")
    WebElement inputMiddleName;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement inputLastName;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickSave;
    @FindBy(xpath = "//span[text()='Required']")
    WebElement requiredMSG;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
    WebElement inputEmployeeName;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickSearch;
    @FindBy(xpath = "//span[text()='No Records Found']")
    WebElement NoRecordsFoundMSG;

    public void setClickPIM() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='PIM']")));
        clickOnElement(clickPIM);
    }

    public void setClickAdd() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")));
        clickOnElement(clickAdd);
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstName']")));
        enterText(inputFirstName, name);
    }

    public void enterMiddleName(String middleName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='middleName']")));
        enterText(inputMiddleName, middleName);

    }

    public void enterLastname(String lastName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='lastName']")));
        enterText(inputLastName, lastName);

    }

    public void setClickSave() {
        clickOnElement(clickSave);
    }

    public boolean isRequiredMSG() {
        return requiredMSG.isDisplayed();
    }

    public void enterEmployeeName(String employeeName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[5]/div/div[2]/div/div/input")));
        enterText(inputEmployeeName, employeeName);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
        clickOnElement(clickSearch);
    }

    public boolean isNoRecordsFoundMSGDisplayed() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='No Records Found']")));
        return NoRecordsFoundMSG.isDisplayed();
    }
}
