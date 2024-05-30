package cn.xju.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.xju.entity.Role;
import cn.xju.mapper.RoleMapper;
import cn.xju.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleMapper roleMapper;

    @Override
    public BaseMapper<Role> getRepository() {
        return roleMapper;
    }

    @Override
    public QueryWrapper<Role> getQueryWrapper(Role e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQueryWrapper'");
    }

    @Override
    public Role findByUserId(Long userId) {
        return roleMapper.findByUserId(userId);
    }
    
}
