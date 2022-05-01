package com.iteratrlearning.documentmanagementsystem;

import java.util.List;
import java.util.Map;

class TextFile {
    private final Map<String, String> attributes;
    private final List<String> lines;
    
    void addLineSuffix(final String prefix, final String attributeName) {
        for(final String line: lines) {
            if(line.startsWith(prefix)) {
                attributes.put(attributeName, line.substring(prefix.length()));
                break;
            }
        }
    }
}
