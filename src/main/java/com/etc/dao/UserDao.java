package com.etc.dao;

import com.etc.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from Users where uname=#{uname} and password=#{password}")
    public User loginQuery(@Param("uname") String uname, @Param("password") String password);
    @Select("select * from Users order by uid desc")
    public List<User> find();
    @Select("select* from users where uid=#{uid}")
    public User get(Integer uid);
    @Options(useGeneratedKeys = true,keyProperty = "uid")
    public void add(User u);
    public void mod(User u);
    public void del(Integer uid);
}
