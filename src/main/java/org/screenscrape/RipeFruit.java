package org.screenscrape;

import org.json.simple.JSONAware;
import org.json.simple.JSONValue;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;

/**
 * //typically would extend fruit which would extend grocery item
 */
public class RipeFruit implements JSONAware {

    String url = "";

    String title = "";

    float unitPrice;

    int size; //kb no assets

    String description = "";


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

/*    public Float getFormattedUnitPrice() {
        NumberFormat formatter = NumberFormat.getInstance(Locale.UK);
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
        return new Float(formatter.format(unitPrice));
    }*/

    public String getFormattedUnitPrice() {
        return org.screenscrape.Utils.getFormattedUnitPrice(unitPrice);
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitPrice(String pricePerUnit) {
        if (pricePerUnit.equals("")) {
            // do nothing - default is 0 anyway
        }
        else if (pricePerUnit.startsWith("&pound") && pricePerUnit.endsWith("/unit")) {
            setUnitPrice(Float.parseFloat(pricePerUnit.substring(6, pricePerUnit.length()-5)));
        }
        else {
            setUnitPrice(Float.parseFloat(pricePerUnit));
        }
    }

    public static int calculateSize(String s) {
        try {
            long sizeInBytes =  sizeInBytes = s.getBytes("UTF-8").length;
            float sizeInKB = sizeInBytes / 1024;
            int result = Math.round(sizeInKB);
            return result;
        } catch (UnsupportedEncodingException e) {
            throw new RetrievalException(e);
        }
    }


    public String toJSONString() {
        LinkedHashMap map = new LinkedHashMap();
        map.put("title", title);
        map.put("size", size + "kb");
        map.put("unit_price", getFormattedUnitPrice());
        map.put("description", description);
        return JSONValue.toJSONString(map);
    }

/*    public void visitPageAndUpdate() {
        if (this.url==null || this.url.equals("")) {
            throw new RetrievalException("RipeFruit URL cannot be null");
        }
        try {
            Document doc = Jsoup.connect(url).get();
            Elements productList = doc.select(ListFruitsMarkup.PRODUCT_BLOCK).select("li");


        } catch (IOException e) {
            throw new RetrievalException(e);
        }

    }*/
}
