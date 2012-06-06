package com.toyronix.odtsection;

import org.odftoolkit.simple.TextDocument;
import org.testng.annotations.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import static org.fest.assertions.Assertions.assertThat;

public class ExtractSectionTest {
    private String DOC_WITH_NO_EMBEDDED_SECTION = "src/test/resources/odt/section/docWithNoEmbeddedSection.odt";
    private String DOC_WITH_ONE_EMBEDDED_SECTION = "src/test/resources/odt/section/enclosingDocWithOneEmbeddedSection.odt";

    @Test
    public void testDocumentsSectionHasNoContent() throws Exception {
        TextDocument textDocument = TextDocument.loadDocument(DOC_WITH_ONE_EMBEDDED_SECTION);
        TextDocumentHandler textDocumentHandler = new TextDocumentHandler(textDocument);

        NodeList nodeList = textDocumentHandler.embeddedSectionList();
        String embeddedSectionPath = ((Element) nodeList.item(0)).getAttribute("xlink:href");
        String sectionName = ((Element) nodeList.item(0)).getAttribute("text:section-name");


        assertThat(TextDocument.loadDocument(embeddedSectionPath).getSectionByName(sectionName).getOdfElement().getLength()).isEqualTo(0);

    }

    @Test
    public void testDocumentsSectionHasContent() throws Exception {
        TextDocument textDocument = TextDocument.loadDocument(DOC_WITH_ONE_EMBEDDED_SECTION);
        TextDocumentHandler textDocumentHandler = new TextDocumentHandler(textDocument);

        NodeList nodeList = textDocumentHandler.embeddedSectionList();
        String embeddedSectionPath = ((Element) nodeList.item(0)).getAttribute("xlink:href");
        String sectionName = ((Element) nodeList.item(0)).getAttribute("text:section-name");


        assertThat(TextDocument.loadDocument(embeddedSectionPath).getSectionByName(sectionName).getOdfElement().getLength()).isEqualTo(1);

    }

    @Test
    public void testDocumentHasOwnSection() {

    }


}
