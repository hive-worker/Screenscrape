package org.screenscrape;

import org.json.simple.JSONValue;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 */
public class ConsoleApplication {

    private static final String listFruitsPageUrl = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";


    public static void main(String[] args) {
        try {
            String listUrl = listFruitsPageUrl;
            if (args.length > 0) {
                listUrl = args[0];
            }
            ListFruitsPage listFruitsPage = new ListFruitsPage(listUrl);
            listFruitsPage.visitPageAndUpdate();
            List<RipeFruit> listRipeFruit = listFruitsPage.getListRipeFruit();
            float totalUnitPrices = 0;
            for (RipeFruit ripeFruit : listRipeFruit) { //todo: make this execute concurrently in separate threads to speed up
                SingleFruitPage singleFruitPage = new SingleFruitPage(ripeFruit);
                singleFruitPage.visitPageAndUpdate();
                totalUnitPrices += ripeFruit.getUnitPrice();
            }
            LinkedHashMap result = new LinkedHashMap();
            //String results = JSONArray.toJSONString(listRipeFruit);
            result.put("results", listRipeFruit);
            result.put("total", org.screenscrape.Utils.getFormattedUnitPrice(totalUnitPrices));
            System.out.println(JSONValue.toJSONString(result));
        }
        catch (Exception e) {
            /* not specified so just leaving it simple */
            LinkedHashMap error = new LinkedHashMap();
            error.put("code", e.getCause());
            error.put("message", e.getMessage());
            System.out.println(JSONValue.toJSONString(error));
        }
    }


}
