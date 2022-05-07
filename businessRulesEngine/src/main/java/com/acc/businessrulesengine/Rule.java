package com.acc.businessrulesengine;

@FunctionalInterface
interface Rule {
    void perform(Facts facts);
}
