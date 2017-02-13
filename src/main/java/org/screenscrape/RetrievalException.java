package org.screenscrape;

import java.io.IOException;

/**
 *
 */
public class RetrievalException extends RuntimeException {
    public RetrievalException(String s) {
        super(s);
    }

    public RetrievalException(Exception e) {
        super(e);
    }
}
