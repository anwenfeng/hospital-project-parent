package com.jk.dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select count(1) from t_userinfo")
    long queryDataTotal();

    @Select("select user_id ,user_name ,password from t_userinfo limit #{startPos},#{pageSize}")
    List<Map<String,Object>> findUser(@Param("startPos") Integer startPos, @Param("pageSize") Integer pageSize);
}
