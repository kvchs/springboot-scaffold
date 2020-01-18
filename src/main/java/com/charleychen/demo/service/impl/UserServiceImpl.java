package com.charleychen.demo.service.impl;

import com.charleychen.demo.dao.UserDao;
import com.charleychen.demo.model.SysUser;
import com.charleychen.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Transactional用法
 * 可以用于接口，接口方法，类，类方法
 * 当作用在类上时，该类当所有public方法都将具有该类型都事务属性
 * 类内部方法调用本类都其他方法，并不会引起事务行为
 * 注解应该只被应用到public方法上
 */

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int save(SysUser sysUser) {
        return userDao.saveOption(sysUser);
    }
}
