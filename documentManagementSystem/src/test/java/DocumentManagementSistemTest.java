import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import com.iteratrlearning.documentmanagementsystem.Attributes;
import com.iteratrlearning.documentmanagementsystem.Document;

import org.junit.jupiter.api.Test;

public class DocumentManagementSistemTest {
    @Test
    public void shouldImportFile() throws Exception {
        System.importFile(LETTER);

        final Document document = onlyDocument();

        assertAttributeEquals(document, Attributes.PATH, LETTER);
    }
}
