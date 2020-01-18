package com.charleychen.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @RequestMapping("/hello")
    public String hello(){
        // 使用slf4j打印日志
        Logger logger = LoggerFactory.getLogger(UserController.class);
        logger.info("slf4j logger output");
        log.info("output by slf4j 【@Slf4j】");
        return "api";
    }
}
