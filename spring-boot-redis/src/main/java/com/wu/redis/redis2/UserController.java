package com.wu.redis.redis2;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 参考：http://www.ityouknow.com/springboot/2016/03/06/spring-boot-redis.html
 * Spring Redis默认使用JDK进行序列化和反序列化，因此被缓存对象需要实现java.io.Serializable接口，否则缓存出错。
 * 当被缓存对象发生改变时，可以选择更新缓存或者失效缓存，但一般而言，后者优于前者，因为执行速度更快。
 * Watchout! 在同一个Class内部调用带有缓存注解的方法，缓存并不会生效。
 */
@RestController
public class UserController {

    /**
     * @Cacheable: 插入缓存
     *      value: 缓存名称
     *      key: 缓存键，一般包含被缓存对象的主键，支持Spring EL表达式
     *      unless: 只有当查询结果不为空时，才放入缓存
     * @CacheEvict: 失效缓存
     */
    @RequestMapping("/getUser")
    @Cacheable(value="2")//先读取缓存中的数据，没有就存入
    public User getUser() {
        User user=new User("1", "1", "1", "1","1");
        //User user=new User("bb@126.com", "bb", "bb123456", "bb","123");
        //User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
        System.out.println("若没出现这行---表示测试成功");
        return user;
    }
}