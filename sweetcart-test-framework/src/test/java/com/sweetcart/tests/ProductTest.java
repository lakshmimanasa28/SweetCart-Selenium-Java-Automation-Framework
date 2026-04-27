// ProductTest.java
package com.sweetcart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sweetcart.tests.BaseTest;
import com.sweetcart.pages.SweetsPage;

public class ProductTest extends BaseTest {

    @Test
    public void testProductModule() {

        SweetsPage sp = new SweetsPage(driver);

        sp.openSweets();

        int productCount = sp.getProductCount();
        System.out.println("Product Count: " + productCount);

        Assert.assertTrue(productCount > 0,
                "No products displayed on sweets page");

        int addBtnCount = sp.getAddButtonCount();
        System.out.println("Add Button Count: " + addBtnCount);

        Assert.assertTrue(addBtnCount > 0,
                "Add to Basket buttons not visible");

        sp.openSweets();

        int newCount = sp.getProductCount();
        System.out.println("Product Count After Reload: " + newCount);

        Assert.assertTrue(newCount > 0,
                "Products not displayed after navigation");
    }
}