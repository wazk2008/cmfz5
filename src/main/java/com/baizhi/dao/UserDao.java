package com.baizhi.dao;

import com.baizhi.entity.User;
import com.baizhi.entity.UserCityAccount;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserDao extends Mapper<User> {

    List<UserCityAccount> selectUserByCity(String sex);

}
