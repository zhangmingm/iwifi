package com.weichikj.mapper;

import com.weichikj.model.User;

import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */
public interface UserMapper {
    public User findUserInfo();
    public List<User> getUserByParam(User user);
}
