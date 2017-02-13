package org.screenscrape;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;

/**
 *
 */
public class TestRipeFruit {
    private static final String ripeFruit1Title = "title1";
    private static final String ripeFruit1Description = "description1";
    private static final String ripeFruit1UnitPrice = "3.50";
    private static final int ripeFruit1Size = 2048;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testToJSONString() {
        RipeFruit ripeFruit = getCompleteRipeFruit1();
        String s = ripeFruit.toJSONString();
        System.out.println(s);
        assert true;
    }

    @Test
    public void testGetFormattedUnitPrice() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat.setMaximumFractionDigits(2);
        RipeFruit ripeFruit = getPartialRipeFruit1();
        System.out.println(ripeFruit.getFormattedUnitPrice());
    }



    /**
     * represents state of a RipeFruit object after parse of 'listripefruits' page.
     * @return
     */
    static RipeFruit getPartialRipeFruit1() {
        RipeFruit ripeFruit = new RipeFruit();
        ripeFruit.setTitle(ripeFruit1Title);
        ripeFruit.setUnitPrice(ripeFruit1UnitPrice);
        ripeFruit.setUrl(TestListFruitsPageIT.ripeFruit1Url);
        return ripeFruit;
    }

    static RipeFruit getCompleteRipeFruit1() {
        RipeFruit ripeFruit = getPartialRipeFruit1();
        ripeFruit.setSize(ripeFruit1Size);
        ripeFruit.setDescription(ripeFruit1Description);
        return ripeFruit;
    }


}