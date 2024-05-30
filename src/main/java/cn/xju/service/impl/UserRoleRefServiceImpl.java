package cn.xju.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.xju.entity.UserRoleRef;
import cn.xju.mapper.UserRoleRefMapper;
import cn.xju.service.UserRoleRefService;

@Service
public class UserRoleRefServiceImpl implements UserRoleRefService{
    @Autowired
    UserRoleRefMapper userRoleRefMapper;

    @Override
    public BaseMapper<UserRoleRef> getRepository() {
        return userRoleRefMapper;
    }

    @Override
    public QueryWrapper<UserRoleRef> getQueryWrapper(UserRoleRef e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQueryWrapper'");
    }
    
}
