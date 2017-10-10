package com.xzzt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository(value = "redisDao")
public class RedisDao{

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<Serializable,Object> redisTemplate;
    /**
     * 设置指定 key 的值
     * @param key
     * @param vlaue
     */
    public void set(String key,Object vlaue){
        if(key == null || key.length() == 0){
            return;
        }
        ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,vlaue);
    }
    /**
     * 获取指定 key 的值
     * @param key
     * @return
     */
    public Object get(String key){
        Object value = "";
        if(key == null || key.length() == 0){
            return value;
        }
        boolean b = this.hasKey(key);
        if(b){
            ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
            value = valueOperations.get(key);
        }
        return value;
    }
    /**
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)。
     * @param key
     * @param newValue
     */
    public Object getAndSet(String key,String newValue){
        if(key == null || key.length() == 0){
            return null;
        }
        ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
        Object oldValue = valueOperations.getAndSet(key,newValue);
        return oldValue;
    }
    /**
     * 判断 key 是否 存在
     * @param key
     * @return
     */
    public boolean hasKey(String key){
        if(key == null || key.length() == 0){
            return false;
        }
        boolean hasKey = redisTemplate.hasKey(key);
        return hasKey;
    }
    /**
     * 删除 key
     * @param key
     */
    public void delete(String key){
        if(key != null && key.length() > 0){
            redisTemplate.delete(key);
        }
    }
    /**
     * 删除 多个 key
     * @param keys
     */
    public void delete(String[] keys){
        if(keys != null && keys.length > 0){
            redisTemplate.delete(keys);
        }
    }

}
