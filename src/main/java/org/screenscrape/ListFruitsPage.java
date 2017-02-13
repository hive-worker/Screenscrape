package org.screenscrape;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class ListFruitsPage extends WebPage {

    private List<RipeFruit> listRipeFruit;

    public ListFruitsPage(String url) {
        super(url);
        listRipeFruit = new LinkedList<RipeFruit>();
    }

    public List<RipeFruit> getListRipeFruit() {
        return listRipeFruit;
    }

    public void visitPageAndUpdate() {
        try {
            Document doc = Jsoup.connect(super.getDecodedUrl()).get();
            Elements productList = doc.select(ListFruitsMarkup.PRODUCT_BLOCK).select("li");

            for (Element product: productList) {
                RipeFruit ripeFruit = new RipeFruit();
                Elements productInfo = ListFruitsMarkup.getProductInfo(product);
                Elements productAnchor = ListFruitsMarkup.getProductAnchor(productInfo);
                ripeFruit.setUrl(ListFruitsMarkup.extractUrl(productAnchor));
                ripeFruit.setTitle(ListFruitsMarkup.extractTitle(productAnchor));
                ripeFruit.setUnitPrice(ListFruitsMarkup.extractUnitPrice(product));
                listRipeFruit.add(ripeFruit);
            }
        }
        catch (IOException ex) {
            throw new RetrievalException(ex);
        }
    }

}
