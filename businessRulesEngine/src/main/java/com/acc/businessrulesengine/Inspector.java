package com.acc.businessrulesengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inspector {
    private  final List<ConditionalAction> conditionalActionsList;

    public Inspector(final ConditionalAction conditionalActions) {
        this.conditionalActionsList = Arrays.asList(conditionalActions);
    }

    public List<Report> inspect(final Facts facts) {
        final List<Report> reportList = new ArrayList<>();
        for (ConditionalAction conditionalAction : conditionalActionsList) {
            final boolean conditionResult = conditionalAction.evaluate(facts);
            reportList.add(new Report(facts, conditionalAction, conditionResult));
        }
        return reportList;
    }
}
