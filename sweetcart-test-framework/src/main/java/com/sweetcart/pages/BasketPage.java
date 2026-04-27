// BasketPage.java
package com.sweetcart.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sweetcart.base.BasePage;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@class,'nav-link') and contains(.,'Basket')]")
    WebElement basketLink;

    @FindBy(xpath = "//ul[@id='basketItems']/li")
    List<WebElement> items;

    @FindBy(xpath = "//a[contains(text(),'Delete Item')]")
    List<WebElement> deleteButtons;

    @FindBy(xpath = "//li[contains(.,'Total')]//strong")
    WebElement totalPrice;

    public void openBasket() {
        click(basketLink);
    }

    public String getBasketText() {
        return basketLink.getText();
    }

    public int getItemCount() {
        return items.size() - 1;
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void removeAllItems() {

        while (deleteButtons.size() > 0) {

            click(deleteButtons.get(0));

            try {
                wait.until(org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent());
                driver.switchTo().alert().accept();
            } catch (Exception e) {
            }

            wait.until(driver -> true);
        }
    }
    

    public boolean isBasketEmpty() {
        return getItemCount() == 0;
    }
}