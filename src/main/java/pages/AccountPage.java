package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends Base {
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement dropDownMenu;

    public AccountPage(){
        PageFactory.initElements(driver,this);
    }
    public void clickOnDropdown() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='oxd-userdropdown-name']")));
        clickOnElement(dropDownMenu);
    }

}
