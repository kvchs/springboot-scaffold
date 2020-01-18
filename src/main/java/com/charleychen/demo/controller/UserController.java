package com.charleychen.demo.controller;

import com.charleychen.demo.model.SysUser;
import com.charleychen.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        // 使用slf4j打印日志
        Logger logger = LoggerFactory.getLogger(UserController.class);
        logger.info("slf4j logger output");
        log.info("output by slf4j 【@Slf4j】");
        return "api";
    }

    @GetMapping("/get")
    @ResponseBody
    public SysUser get(){
        SysUser sysUser1 = new SysUser();
        sysUser1.setStatus(2);
        sysUser1.setUsername("test");
        sysUser1.setPassword("pwd");
        iUserService.save(sysUser1);
        return sysUser1;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/index")
    public String getPage(){
        return "admin-list";
    }
}
