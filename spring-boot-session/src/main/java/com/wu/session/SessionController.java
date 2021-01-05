package com.wu.session;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 登录Redis管理页面打开命令界面，输入：keys '*sessions*'
 * 参考：http://www.ityouknow.com/springboot/2016/03/06/spring-boot-redis.html
 * 如何在两台或者多台中共享 Session
 * 其实就是按照上面的步骤在另一个项目中再次配置一次，启动后自动就进行了 Session 共享。
 */
@RestController
public class SessionController {

    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}