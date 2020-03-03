package com.ctoeyes.mongodb;

public interface WTOperationInterface {
    void create(String a, Integer b, String c, Integer d);
    void retrieve(Integer b);
    void retrieveByIndex(Integer d);
    Integer getNumOfAll();
    void deleteAll();
}
