package pageObjects;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    //CONSTRUCTOR CREATED (THE BASE PAGE CONSTRUCTOR IS CALLED USING THE "SUPER" KEYWORD)
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    //LOCATORS

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement btn_myAccount_loc;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement btn_register_loc;



    //ACTIONS

    public void clickMyAccount()
    {
        btn_myAccount_loc.click();
    }

    public void clickRegister()
    {
        btn_register_loc.click();
    }


}
