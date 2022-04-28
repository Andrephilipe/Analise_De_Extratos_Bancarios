package com.iteratrlearning.realsoftwaredevelopment;

public class HtmlExporter implements Exporter {
    
    @Override
    public String export(final SummaryStatistics summaryStatistics) {

        String result = "<!DOCTYPE HTML>";
        result += "<html lang='en'>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is</strong>: </li>" + summaryStatistics.getSum() + "</li>";
        result += "<li><strong>The average is</strong>: </li>" + summaryStatistics.getAverage() + "</li>";
        result += "<li><strong>The max is</strong>: </li>" + summaryStatistics.getMax() + "</li>";
        result += "<li><strong>The min is</strong>: </li>" + summaryStatistics.getMin() + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }

}
