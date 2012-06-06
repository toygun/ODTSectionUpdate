package com.toyronix.odtsection;

import org.odftoolkit.simple.TextDocument;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class FindEmbeddedSectionsTest {
    private String DOC_WITH_NO_EMBEDDED_SECTION = "src/test/resources/odt/section/docWithNoEmbeddedSection.odt";

@Test
public void testDocumentHasNoEmbeddedSections() throws Exception {
    TextDocument textDocument = TextDocument.loadDocument(DOC_WITH_NO_EMBEDDED_SECTION);
    TextDocumentHandler textDocumentHandler = new TextDocumentHandler(textDocument);

    assertThat(textDocumentHandler.hasEmbeddedSections()).isFalse();
}
}