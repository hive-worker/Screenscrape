package org.screenscrape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 */
public class TestListFruitsPageIT {

    static final String listFruitsPageUrl = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";
    static final String ripeFruit1Url = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-golden-kiwi--taste-the-difference-x4-685641-p-44.html";

    @Test
    public void testListFruitsPage() {
        ListFruitsPage listFruitsPage  = new ListFruitsPage(listFruitsPageUrl);
        listFruitsPage.visitPageAndUpdate();
        //assertTrue(listFruitsPage.getListRipeFruit().size() == 7);//too fragile a screenscrape
        assertTrue(listFruitsPage.getListRipeFruit().size() > 0);
        System.out.println(listFruitsPage.getListRipeFruit());
    }

    @Test
    public void testSingleFruitPage() {
        RipeFruit ripeFruit1 = TestRipeFruit.getPartialRipeFruit1();
        SingleFruitPage singleFruitPage = new SingleFruitPage(ripeFruit1);
        singleFruitPage.visitPageAndUpdate();//sets size and description
        assertTrue(ripeFruit1.getDescription().length() > 0);
        assertTrue(ripeFruit1.getSize() > 0);
    }


}
