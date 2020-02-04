package com.liangjiange.devopsbackstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liangjiange.devopsbackstage.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {


    @Select("select * from user where username = #{username}")
    User getByUsername(@Param("username") String username);

}
