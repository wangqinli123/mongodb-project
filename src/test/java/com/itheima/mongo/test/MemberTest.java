package com.itheima.mongo.test;

import com.itheima.mongo.demo.MemberDao;
import com.itheima.mongo.pojo.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.core.common.mongo.QueryRule;
import java.util.List;

@ContextConfiguration(locations={"classpath*:application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberTest {

    @Autowired
    MemberDao memberDao;

   @Test
    public void findTest(){
       QueryRule queryRule = QueryRule.getInstance();
       queryRule.andEqual("nickname","tom");
       List<Member> members = memberDao.select(queryRule);
       System.out.println(members);
   }

}
