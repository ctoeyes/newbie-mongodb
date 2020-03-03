package com.ctoeyes.mongodb;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class MongodbApplicationTests {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SSS");
    private String time;

    @Autowired
    private WTOperationInterface wiredTiger;

    @Test
    public void create() throws Exception {

        Integer tableRecordNum = 50000;

        System.out.println("清空表");
        wiredTiger.deleteAll();

        System.out.println("WiredTiger 开始插入");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("开始时间："+time);

        for(int i=0;i<tableRecordNum;i++) {
            wiredTiger.create("a", i, "b", i);
        }

        System.out.println("WiredTiger 插入结束");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("结束时间："+time);

        Assert.assertEquals(tableRecordNum.intValue(), wiredTiger.getNumOfAll().intValue());
    }

    @Test
    public void retrieve() throws Exception {

        Integer retrieveNum = 10000;

        System.out.println("WiredTiger 开始查询");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("开始时间："+time);

        for(int i=0;i<retrieveNum;i++) {
            wiredTiger.retrieve(i);
        }

        System.out.println("WiredTiger 查询结束");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("结束时间："+time);
    }

    @Test
    public void retrieveByIndex() throws Exception {

        Integer retrieveNum = 10000;

        System.out.println("WiredTiger 开始查询 by Index");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("开始时间："+time);

        for(int i=0;i<retrieveNum;i++) {
            wiredTiger.retrieveByIndex(i);
        }

        System.out.println("WiredTiger 查询结束 by Index");
        time = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.println("结束时间："+time);
    }


}
