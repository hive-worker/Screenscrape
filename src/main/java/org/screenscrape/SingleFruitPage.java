package org.screenscrape;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 */
public class SingleFruitPage extends WebPage {

    private RipeFruit ripeFruit;

    public void setRipeFruit(RipeFruit ripeFruit) {
        this.ripeFruit = ripeFruit;
    }

    public RipeFruit getRipeFruit() {
        return ripeFruit;
    }


    public SingleFruitPage(RipeFruit ripeFruit) {
        super(ripeFruit.getUrl());
        this.ripeFruit = ripeFruit;
    }

    public void visitPageAndUpdate() {
        try {
            Document doc = Jsoup.connect(super.getDecodedUrl()).get();
            Elements productText = doc.select(SingleFruitMarkup.INFORMATION + " " + SingleFruitMarkup.PRODUCT_TEXT);
            Elements descriptions = productText.select("p");
            String description = descriptions.get(0).text();//should improve selector rather than get 0
            //System.out.println(description);
            ripeFruit.setDescription(description);
            ripeFruit.setSize(RipeFruit.calculateSize(doc.outerHtml()));
        }
        catch (Exception e) {
            throw new RetrievalException(e);
        }
    }

}
