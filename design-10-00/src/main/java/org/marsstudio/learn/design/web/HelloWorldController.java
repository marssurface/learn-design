package org.marsstudio.learn.design.web;

import org.marsstudio.learn.design.domain.UserInfo;
import org.marsstudio.learn.design.door.annotation.DoDoor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("8080")
    private int port;

    @DoDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"⾮⽩名单 可访问⽤户拦截！\"}")
    @RequestMapping(value = "api/queryUserInfo", method = RequestMethod.GET)
    public UserInfo queryInfo(@RequestParam String userId) {
        return new UserInfo("虫虫:" + userId, 19, "天津市南开区旮旯胡同100号");
    }
}
