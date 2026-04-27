// LoginPage.java
package com.sweetcart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sweetcart.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

  

    @FindBy(id = "exampleInputEmail")
    WebElement emailField;

    @FindBy(id = "exampleInputPassword")
    WebElement passwordField;

    @FindBy(id = "btn_login")
    WebElement loginBtn;

    @FindBy(xpath = "//*[contains(@class,'invalid-email')]")
    WebElement errorMsg;


    

    public void openLogin() {
        click(loginLink);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginBtn);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

   

    public String getErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMsg));
            return errorMsg.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isLoginSuccessful() {
        try {
            wait.until(d -> driver.getCurrentUrl().contains("account")
                    || driver.getPageSource().toLowerCase().contains("orders")
                    || driver.getPageSource().toLowerCase().contains("logout"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
 

    @FindBy(linkText = "Logout")
    WebElement logoutLink;

    @FindBy(linkText = "Login")
    WebElement loginLink;

    public void clickLogout() {
        click(logoutLink);
    }

    public boolean isLoginLinkVisible() {
        return loginLink.isDisplayed();
    }
    
}