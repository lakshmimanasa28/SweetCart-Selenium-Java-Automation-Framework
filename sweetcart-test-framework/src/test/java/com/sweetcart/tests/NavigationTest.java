
package com.sweetcart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sweetcart.tests.BaseTest;
import com.sweetcart.pages.NavigationPage;

public class NavigationTest extends BaseTest {

    @Test
    public void testNavigationModule() {

        NavigationPage np = new NavigationPage(driver);

        Assert.assertTrue(np.isHomeVisible(), "Home link missing");
        Assert.assertTrue(np.isSweetsVisible(), "Sweets link missing");
        Assert.assertTrue(np.isAboutVisible(), "About link missing");
        Assert.assertTrue(np.isLoginVisible(), "Login link missing");

        np.clickAbout();

        String heading = np.getAboutHeading();
        System.out.println("About Heading: " + heading);

        Assert.assertTrue(heading.length() > 0,
                "About page heading missing");

        Assert.assertTrue(np.isFooterPresent(),
                "Footer not present");

        String footerText = np.getFooterText();
        System.out.println("Footer Text: " + footerText);

        Assert.assertTrue(footerText.length() > 0,
                "Footer content missing");
    }
}