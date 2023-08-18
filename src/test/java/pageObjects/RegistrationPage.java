package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    JavascriptExecutor js = (JavascriptExecutor) driver;
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txt_firstName_loc;

    //LOCATORS
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txt_lastName_loc;
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txt_email_loc;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txt_password_loc;
    @FindBy(xpath = "//input[@id='input-newsletter-yes']")
    WebElement btn_sub_loc;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement btn_agree_loc;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement btn_continue_loc;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    //ACTIONS

    public void setFirstName(String firstName) {
        txt_firstName_loc.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        txt_lastName_loc.sendKeys(lastName);
    }

    public void setEmail(String email) {
        txt_email_loc.sendKeys(email);
    }

    public void setPassword(String password) {
        txt_password_loc.sendKeys(password);
    }

    public void clickSubscribe() {
        js.executeScript("arguments[0].click()", btn_sub_loc);
    }

    public void clickAgree() {
       js.executeScript("arguments[0].click()", btn_agree_loc);

    }

    public void clickContinue() {
        js.executeScript("arguments[0].click()", btn_continue_loc);
    }
}
