package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(value = "producer")
public interface FeignClientTest {

    @RequestMapping(value = "/echo/{str}")
    String hello(@PathVariable("str") String str);

    @RequestMapping(value = "/user")
    User getUser(User user);
}
