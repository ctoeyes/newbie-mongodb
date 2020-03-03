package com.ctoeyes.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "WiredTiger")
public class WTObj {
    @Field("A")
    private String a;

    @Id
    private Integer b;

    @Field("C")
    private String c;

    @Field("D")
    private Integer d;

    public WTObj() {
    }

    public WTObj(String a,
                 Integer b,
                 String c,
                 Integer d) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }
}
