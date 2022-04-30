package com.iteratrlearning.documentmanagementsystem;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DocumentManagementSystem {
    
    private final Map<String, Importer> extensionToImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionToImporter.put("letter", new LetterImporter());
        extensionToImporter.put("report", new ReportImporter());
        extensionToImporter.put("jpg", new ImageImporter());

    }

    public void importFile(final String path) throws IOException {
        final File file = new File(path);
        if(!file.exists()) {
            throw new FileNotFoundException(path);
        }

        final int separatorIndex = path.lastIndexOf('.');
        if(separatorIndex != -1) {

            if(separatorIndex == path.length()) {
                throw new UnknowFileTypeException("No extension foun for file: " + path);
            }

            final String extension = path.substring(separatorIndex + 1);
            final Importer importer = extensionToImporter.get(extension);

            if(importer == null) {
                throw new UnknowFileTypeException("For file: " + path);
            }

            final Document document = Importer.importFile(file);
            document.add(document);
        }
        else {
            throw new UnknowFileTypeException("No extension found for file: " + path);
        }

    }

}
