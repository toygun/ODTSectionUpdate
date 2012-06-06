package com.toyronix.odtsection;

import org.odftoolkit.simple.TextDocument;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class FindEmbeddedSectionsTest {
    private String DOC_WITH_NO_EMBEDDED_SECTION = "src/test/resources/odt/section/docWithNoEmbeddedSection.odt";
    private String DOC_WITH_ONE_EMBEDDED_SECTION = "src/test/resources/odt/section/enclosingDocWithOneEmbeddedSection.odt";
    private String DOC_WITH_TWO_EMBEDDED_SECTION = "src/test/resources/odt/section/enclosingDocWithTwoEmbeddedSections.odt";

    @Test
    public void testDocumentHasNoEmbeddedSections() throws Exception {
        TextDocument textDocument = TextDocument.loadDocument(DOC_WITH_NO_EMBEDDED_SECTION);
        TextDocumentHandler textDocumentHandler = new TextDocumentHandler(textDocument);

        assertThat(textDocumentHandler.hasEmbeddedSections()).isFalse();
    }

    @Test
    public void testDocumentHaEmbeddedSections() throws Exception {
        TextDocument textDocument = TextDocument.loadDocument(DOC_WITH_TWO_EMBEDDED_SECTION);
        TextDocumentHandler textDocumentHandler = new TextDocumentHandler(textDocument);

        assertThat(textDocumentHandler.hasEmbeddedSections()).isTrue();
    }


    @Test
    public void testDocumentHasOneSection() throws Exception {
        TextDocument textDocument = TextDocument.loadDocument(DOC_WITH_ONE_EMBEDDED_SECTION);
        TextDocumentHandler textDocumentHandler = new TextDocumentHandler(textDocument);

        assertThat(textDocumentHandler.embeddedSectionList().getLength()).isEqualTo(1);
    }

    @Test
    public void testTextDocumentHasMoreThanOneSections() throws Exception {
        TextDocument textDocument = TextDocument.loadDocument(DOC_WITH_TWO_EMBEDDED_SECTION);
        TextDocumentHandler textDocumentHandler = new TextDocumentHandler(textDocument);

        assertThat(textDocumentHandler.embeddedSectionList().getLength()).isEqualTo(2);

    }


}