package javax.core.common.mongo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import sun.rmi.log.LogInputStream;

import java.io.Serializable;
import java.util.List;

@Repository
public abstract class BaseDaoSupport<T extends Serializable,PK extends Serializable> {

    private Logger logger = Logger.getLogger(BaseDaoSupport.class);

    private MongoTemplate mongoTemplate;

    protected void setTemplate(MongoTemplate template){
        this.mongoTemplate = template;
    }

    protected abstract String getPKColumn();

    protected List<T> find(QueryRule queryRule){
        return null;
    }
}
