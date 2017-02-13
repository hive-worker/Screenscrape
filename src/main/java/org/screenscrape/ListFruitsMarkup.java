package org.screenscrape;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 */
public class ListFruitsMarkup {

    public static final String PRODUCT_BLOCK = "ul.productLister.listView";
    public static final String PRODUCT_INFO = "div.productInfo";
    public static final String PRICE_PER_UNIT = "p.pricePerUnit";


    /* these can be moved to a separate class if they need to be re-used */
    static Elements getProductInfo(Element product) {
        return product.select(PRODUCT_INFO);
    }

    static Elements getProductAnchor(Elements productInfo) {
        return productInfo.select("a");
    }

    static String extractUrl(Elements productAnchor) {
        String result = "";
        if (productAnchor.hasAttr("href")) {
            result = productAnchor.attr("href").trim();
            //System.out.println(ripeFruit.getUrl());
        }
        return result;
    }

    static String extractTitle(Elements productAnchor) {
        String result = "";
        if (productAnchor.hasText()) {
            result = productAnchor.text().trim();
            //System.out.println(ripeFruit.getTitle());
        }
        return result;
    }

    static final String extractUnitPrice(Element productInfo) {
        String result = "";
        Elements pricePerUnitE = productInfo.select(PRICE_PER_UNIT);
        if (pricePerUnitE.hasText()) {
            result = pricePerUnitE.text().trim();
        }
        return result;
    }
}

