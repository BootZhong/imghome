package com.boka.yuan.attendance.util;

import com.boka.custom.exception.CommonException;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 访问频率控制工具
 * @author bootzhong
 */
@Component
public class AccessControlUtil {
    @Resource(name = "stringRedisTemplate")
    private RedisOperations<String, String> redisTemplate;
    private static final String LIMIT_KEY = "redis:limit:";

    public void limitTime(String key, Long t, TimeUnit u){
        Boolean absent = redisTemplate.opsForValue().setIfAbsent(LIMIT_KEY + key, "-1", t, u);
        if (BooleanUtils.isFalse(absent)){
            throw new CommonException("操作过于频繁");
        }
    }
}
