package com.sweetcart.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sweetcart.base.BasePage;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "accountGreeting")
    WebElement userName;

    @FindBy(xpath = "//tbody[@id='transactionsBody']/tr")
    List<WebElement> orderRows;

    @FindBy(xpath = "//h4[contains(text(),'Previous Orders')]")
    WebElement orderHistoryTitle;

    public String getUserName() {
        return getText(userName);
    }

    public boolean isOrderHistoryPresent() {
        return orderHistoryTitle.isDisplayed();
    }

    public int getOrderCount() {
        return orderRows.size();
    }

    public List<WebElement> getOrderRows() {
        return orderRows;
    }

    public void printOrders() {
        for (WebElement row : orderRows) {
            System.out.println(row.getText());
        }
    }
}