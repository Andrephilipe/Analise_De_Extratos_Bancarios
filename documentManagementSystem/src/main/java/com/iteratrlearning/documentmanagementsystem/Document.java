package com.iteratrlearning.documentmanagementsystem;

import java.util.Map;

public class Document {
    
    private final Map<String, String> attributes;

    Document(final Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(final String attribyteName) {
        return attributes.get(attribyteName);
    }
}
