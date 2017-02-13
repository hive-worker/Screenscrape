package org.screenscrape;

import java.text.DecimalFormat;

/**
 *
 */
public class Utils {

    public static String getFormattedUnitPrice(float f) {
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        return df.format(f);
    }
}
