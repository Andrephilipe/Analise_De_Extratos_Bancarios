import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.iteratrlearning.documentmanagementsystem.Attributes;
import com.iteratrlearning.documentmanagementsystem.Document;
import com.iteratrlearning.documentmanagementsystem.UnknownFileTypeException;

import org.junit.jupiter.api.Test;

public class DocumentManagementSistemTest {
    private static final String RESOURCES = "src" + File.separator + 
                                            "test" + File.separator + 
                                            "resources" + File.separator;
    private static final String LETTER = RESOURCES + "patient.letter";
    private static final String REPORT = RESOURCES + "patient.report";
    private static final String XRAY = RESOURCES + "xray.jpg";
    private static final String INVOICE = RESOURCES + "patient.invoice";
    private static final String JOE_BLOGGS = RESOURCES + "Joe Bloggs";

    @Test
    public void shouldImportFile() throws Exception {
        System.importFile(LETTER);

        final Document document = onlyDocument();

        assertAttributeEquals(document, Attributes.PATH, LETTER);
    }

    @Test
    public void shouldImporteLetterAttributes() throws Exception {
        System.importFile(LETTER);

        final Document document = onlyDocument();

        assertAttributeEquals(document, PATIENT, JOE_BLOGGS);
        assertAttributeEquals(document, ADDRESS,
            "123 Fake Street\n" +
            "Westminster\n" +
            "London\n" +
            "United Kingdom");
        assertAttributeEquals(document, BODY, 
        "We are writing to you confirm the re-schedullig of your appointment\n" + 
        "with Dr. Avaj from 129th December 2016 to Sth January 2017.");
        assertTypeIs("LETTER", document);

    }
    private Document onlyDocument() {
        final List<Document> documents = System.contents();
        assertThat(documents, hasSize(1));
        return documents.get(0);
    }

    @Test
    public void shouldImporteImageAttributes() throws Exception {
        System.importFile(XRAY);

        final Document document = onlyDocument();

        assertAttributeEquals(document, WIDTH, "320");
        assertAttributeEquals(document, HEIGHT, "179");
        assertTypeIs("IMAGE", document);
    }

    public void assertAttributeEquals(
        final Document document,
        final String attributeName,
        final String expectedValue) {

            assertEquals("Document has the wrong value for " + attributeName, 
            expectedValue, document.getAttribute(attributeName));

    }

    @Test(expected = FileNotFoundException.class)
    public void shouldImportMissingFile() throws Exception {
        System.importFile("gobbledygook.txt");
    }

    @Test(expected = UnknownFileTypeException.class)
    public void shouldNotImportUnknownFile() throws Exception {
        System.importFile(RESOURCES + "unknown.txt");
    }
}
 