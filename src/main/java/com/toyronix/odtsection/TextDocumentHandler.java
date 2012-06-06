package com.toyronix.odtsection;

import org.odftoolkit.simple.TextDocument;

public class TextDocumentHandler {
    TextDocument textDocument;

    public TextDocumentHandler(TextDocument textDocumentToHandle) {
        this.textDocument = textDocumentToHandle;
    }

    public boolean hasEmbeddedSections() {
        //TODO implement the method
        return false;
    }
}
