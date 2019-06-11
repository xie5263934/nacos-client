package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignClientTest feignClientTest;


    @RequestMapping(value = "/consumer/{str}")
    public String hello(@PathVariable String str) {
        return restTemplate.getForObject("http://producer/echo/" + str, String.class);
    }

    @RequestMapping(value = "/consumer1/{str}")
    public String hello1(@PathVariable String str) {
        return feignClientTest.hello(str);
    }

    @RequestMapping(value = "/user")
    public User getUser() {
        User u = new User();
        u.setName("sheldon1");
        u.setAge(120);
        u.setAddress("幸福街1");
        return feignClientTest.getUser(u);
    }
}
