package com.xzzt;

import com.xzzt.dao.RedisDao;
import com.xzzt.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/application.xml"})
public class RedisDaoTest{

    @Autowired
    @Qualifier("redisDao")
    private RedisDao redisDao;

    @Test
    public void tt1(){
        //String andSet = redisDao.getAndSet("xt", "aaa");
        User u = new User();
        u.setUserName("111");
        u.setPassWord("2222");
        //redisDao.set("xzzt",u);
        String xz = (String) redisDao.get("aaa");
        System.out.println(xz);
        //String andSet = redisDao.getAndSet("xzzt", "aaa");
        //System.out.println(andSet);
        //redisDao.delete("xzzt");
        //User xzzt = (User) redisDao.get("xzzt");
        //System.out.println(xzzt.toString());
    }
}
