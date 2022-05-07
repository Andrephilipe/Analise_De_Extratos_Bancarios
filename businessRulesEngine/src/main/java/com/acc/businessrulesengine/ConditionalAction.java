package com.acc.businessrulesengine;

public interface ConditionalAction {
    boolean evaluate(Facts facts);
    void perform(Facts facts);
}
