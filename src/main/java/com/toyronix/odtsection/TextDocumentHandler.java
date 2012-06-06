package com.toyronix.odtsection;

import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.text.Section;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextDocumentHandler {
    TextDocument textDocument;

    public TextDocumentHandler(TextDocument textDocumentToHandle) {
        this.textDocument = textDocumentToHandle;
    }

    public TextDocument getTextDocument() {
        return textDocument;
    }

    public boolean hasEmbeddedSections() throws Exception {
        int lengthOfSectionSourceTags = getTextDocument().getContentDom().getElementsByTagName("text:section-source").getLength();

        if (lengthOfSectionSourceTags > 0)
            return true;

        return false;
    }

    public NodeList embeddedSectionList() throws Exception {
        NodeList elementsByTagName = null;
        if (hasEmbeddedSections()) {
            elementsByTagName = getTextDocument().getContentDom().getElementsByTagName("text:section-source");
        }
        return elementsByTagName;
    }

}
