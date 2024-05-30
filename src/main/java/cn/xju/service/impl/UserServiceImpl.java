package cn.xju.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.xju.common.constant.CommonConstant;
import cn.xju.entity.User;
import cn.xju.mapper.UserMapper;
import cn.xju.service.UserService;
import cn.xju.util.Md5Util;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public BaseMapper<User> getRepository() {
        return userMapper;
    }

    @Override
    public QueryWrapper<User> getQueryWrapper(User e) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //...
        return queryWrapper;
    }

    @Override
    public User checkUser(User user) {
        return userMapper.checkUser(user);
    }

    @Override
    public User checkPass(User user) {
        user.setUserPass(Md5Util.toMd5(user.getUserPass(), CommonConstant.PASSWORD_SALT, 1));
        return userMapper.checkPass(user);
    }

}
