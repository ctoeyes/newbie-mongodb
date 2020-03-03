package com.ctoeyes.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class WTOperationImpl implements WTOperationInterface {

    @Autowired
    private MongoTemplate mongoTemplate ;

    @Override
    public void create(String a, Integer b, String c, Integer d) {
        WTObj wtObj = new WTObj(a,b,c,d);
        mongoTemplate.save(wtObj);
    }

    @Override
    public void retrieve(Integer d) {
        Query query = new Query(Criteria.where("D").is(d));
        mongoTemplate.findOne(query, WTObj.class);
    }

    @Override
    public void retrieveByIndex(Integer b) {
        Query query = new Query(Criteria.where("_id").is(b));
        mongoTemplate.findOne(query, WTObj.class);
    }

    @Override
    public Integer getNumOfAll() {
        return (int)mongoTemplate.getCollection("WiredTiger").countDocuments();
    }

    @Override
    public void deleteAll() {
        mongoTemplate.dropCollection(WTObj.class);
    }

}
