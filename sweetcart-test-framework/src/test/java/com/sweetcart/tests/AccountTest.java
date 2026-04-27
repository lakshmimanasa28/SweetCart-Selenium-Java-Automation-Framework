package com.sweetcart.tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sweetcart.tests.BaseTest;
import com.sweetcart.pages.AccountPage;
import com.sweetcart.pages.LoginPage;

public class AccountTest extends BaseTest {

    @Test
    public void testAccountAndOrderHistory() {

        LoginPage lp = new LoginPage(driver);
        AccountPage ap = new AccountPage(driver);

        lp.openLogin();
        lp.login("oneorder@sweetshop.local", "qwerty");

        String name = ap.getUserName();
        System.out.println("User Name: " + name);

        Assert.assertTrue(name.length() > 0,
                "User name not displayed");

        Assert.assertTrue(ap.isOrderHistoryPresent(),
                "Order history section not found");

        int orders = ap.getOrderCount();
        System.out.println("Total Orders: " + orders);

        if (orders > 0) {

            for (WebElement row : ap.getOrderRows()) {

                String text = row.getText();
                System.out.println(text);

                Pattern datePattern = Pattern.compile("\\d{4}");
                Matcher dateMatcher = datePattern.matcher(text);
                Assert.assertTrue(dateMatcher.find(),
                        "Date not found");

                Pattern amtPattern = Pattern.compile("\\d+\\.\\d+");
                Matcher amtMatcher = amtPattern.matcher(text);
                Assert.assertTrue(amtMatcher.find(),
                        "Amount not found");
            }

        } else {
            System.out.println("No previous orders found");
        }

        ap.printOrders();
    }
}