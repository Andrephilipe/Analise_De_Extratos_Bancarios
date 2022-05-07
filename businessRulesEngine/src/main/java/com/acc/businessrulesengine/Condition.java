package com.acc.businessrulesengine;

@FunctionalInterface
public interface Condition {
    boolean evaluate(Facts facts);
}
