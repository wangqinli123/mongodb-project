package com.itheima.mongo.demo;

import com.itheima.mongo.pojo.Member;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.core.common.mongo.BaseDaoSupport;
import javax.core.common.mongo.QueryRule;
import java.util.List;

@Repository
public class MemberDao extends BaseDaoSupport<Member, ObjectId> {


    @Resource(name = "mongoTemplate")
    @Override
    protected void setTemplate(MongoTemplate template) {
        super.setTemplate(template);
    }

    @Override
    protected String getPKColumn() {
        return "_id";
    }

    public List<Member> select(QueryRule queryRule){
        return super.find(queryRule);
    }
}
