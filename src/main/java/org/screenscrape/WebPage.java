package org.screenscrape;

import java.io.UnsupportedEncodingException;

/**.
 * could contain a field class, which would be populated by constructor to indicate which class the webpage relates to.
 */
public abstract class WebPage {

    protected String url;

    public WebPage(String url) {
        this.url = url;
    }

    /**
     * due to limitation of jsoup which encodes urls
     * @return
     */
    public String getDecodedUrl() {
        try {
            return java.net.URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace(System.err);
            throw new RetrievalException(e);
        }
    }

    public abstract void visitPageAndUpdate();

}
