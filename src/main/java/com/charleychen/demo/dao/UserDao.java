package com.charleychen.demo.dao;

import com.charleychen.demo.model.SysUser;
import org.apache.ibatis.annotations.*;

/**
 *  @Mapper 注解
 *  为了把mapper这个Dao交给Spring管理
 *  为了不再写Mapper映射文件
 *  添加@Mapper注解的接口生成一个实现类
 *
 *
 */
@Mapper
public interface UserDao {

    /**
     *  表字段和Java属性字段映射问题
     * @param username
     * @return
     *
     *  mapUnderscoreToCamelCase方式
     *  数据库字段别名方式
     *  @Results/@ResultMap注解方式
     *
     *  #{} ${} 预编译的处理不一样，占位符/字符串拼接
     */

    @Select("select * from sys_user t where t.username = #{username}")
    SysUser getUser(String username);

    // 不需要返回主键
    @Insert("insert into sys_user(username, password, nickname, headImgUrl, phone, telephone, email, birthday, sex, " +
            "status, createTime, updateTime) " + "values(#{username}, #{password}, #{nickname}, #{headImgUrl}, " +
            "#{phone}, #{telephone}, #{email}, #{birthday}, #{sex}, #{status}, now(), now())")
    int save(SysUser user);

    // 返回自增主键
    @Insert("insert into sys_user(username, password, nickname, headImgUrl, phone, telephone, email, birthday, sex, " +
            "status, createTime, updateTime) " + "values(#{username}, #{password}, #{nickname}, #{headImgUrl}, " +
            "#{phone}, #{telephone}, #{email}, #{birthday}, #{sex}, #{status}, now(), now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveOption(SysUser user);

    // 返回自定义主键
    @Insert("insert into sys_user(username, password, nickname, headImgUrl, phone, telephone, email, birthday, sex, " +
            "status, createTime, updateTime) " + "values(#{username}, #{password}, #{nickname}, #{headImgUrl}, " +
            "#{phone}, #{telephone}, #{email}, #{birthday}, #{sex}, #{status}, now(), now())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", resultType = Long.class, before = false)
    int saveSelectKey(SysUser user);

    @Delete("delete from sys_user where id = #{id}")
    int deleteUser(Long id);

    int updateUser(SysUser user);

}
