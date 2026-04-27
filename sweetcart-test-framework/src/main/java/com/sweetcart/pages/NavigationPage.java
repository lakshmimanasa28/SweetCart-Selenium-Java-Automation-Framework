// NavigationPage.java
package com.sweetcart.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sweetcart.base.BasePage;

public class NavigationPage extends BasePage {

    public NavigationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@class,'navbar-brand')]")
    WebElement homeLink;

    @FindBy(linkText = "Sweets")
    WebElement sweetsLink;

    @FindBy(linkText = "About")
    WebElement aboutLink;

    @FindBy(linkText = "Login")
    WebElement loginLink;

    @FindBy(tagName = "h1")
    WebElement aboutHeading;

    @FindBy(tagName = "footer")
    WebElement footer;

    @FindBy(tagName = "a")
    List<WebElement> footerLinks;

    public boolean isHomeVisible() {
        return homeLink.isDisplayed();
    }

    public boolean isHomeClickable() {
        return homeLink.isDisplayed() && homeLink.isEnabled();
    }

    public boolean isSweetsVisible() {
        return sweetsLink.isDisplayed();
    }

    public boolean isAboutVisible() {
        return aboutLink.isDisplayed();
    }

    public boolean isLoginVisible() {
        return loginLink.isDisplayed();
    }

    public void clickAbout() {
        click(aboutLink);
    }

    public String getAboutHeading() {
        return getText(aboutHeading);
    }

    public boolean isFooterPresent() {
        return footer.isDisplayed();
    }

    public String getFooterText() {
        return footer.getText();
    }
}