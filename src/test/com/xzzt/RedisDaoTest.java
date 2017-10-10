package com.xzzt;

import com.xzzt.dao.RedisDao;
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
        redisDao.set("xzzt","xzzt");
        //String xz = redisDao.get("");
        //System.out.println(xz);
        //String andSet = redisDao.getAndSet("xzzt", "aaa");
        //System.out.println(andSet);
        //redisDao.delete("xzzt");
    }
}
