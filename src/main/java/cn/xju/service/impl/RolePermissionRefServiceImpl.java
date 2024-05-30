package cn.xju.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.xju.entity.RolePermissionRef;
import cn.xju.mapper.RolePermissionRefMapper;
import cn.xju.service.RolePermissionRefService;

@Service
public class RolePermissionRefServiceImpl implements RolePermissionRefService{
    @Autowired
    RolePermissionRefMapper rolePermissionRefMapper;
    @Override
    public BaseMapper<RolePermissionRef> getRepository() {
        return rolePermissionRefMapper;
    }

    @Override
    public QueryWrapper<RolePermissionRef> getQueryWrapper(RolePermissionRef e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQueryWrapper'");
    }
    
}
