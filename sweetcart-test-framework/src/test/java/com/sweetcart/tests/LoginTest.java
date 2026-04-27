package com.sweetcart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sweetcart.tests.BaseTest;
import com.sweetcart.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password, String type) {

        LoginPage lp = new LoginPage(driver);

        lp.openLogin();
        lp.login(email, password);

        if (type.equalsIgnoreCase("valid")) {

            boolean status = lp.isLoginSuccessful();
            System.out.println("Login success: " + status);

            Assert.assertTrue(status,
                    "Valid login failed for user: " + email);

        } else {

            String error = lp.getErrorMessage();
            System.out.println("Error Message: " + error);

            Assert.assertTrue(error.length() > 0,
                    "Error message not shown for invalid login");
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][] {

            {"oneorder@sweetshop.local", "qwerty", "valid"},
            {"twoorders@sweetshop.local", "qwerty", "valid"},
            {"fiveorders@sweetshop.local", "qwerty", "valid"},
            {"wrongemail@example.com", "testing", "invalid"}
        };
    }
   
}