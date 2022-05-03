package com.acc.businessrulesengine;
@FunctionalInterface
public interface  Action {
    void perform(Facts facts);
}
