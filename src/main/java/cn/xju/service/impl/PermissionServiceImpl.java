package cn.xju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.xju.entity.Permission;
import cn.xju.mapper.PermissionMapper;
import cn.xju.service.PermissionService;
import cn.xju.util.PermissionUtil;

@Service
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public BaseMapper<Permission> getRepository() {
        return permissionMapper;
    }

    @Override
    public QueryWrapper<Permission> getQueryWrapper(Permission e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQueryWrapper'");
    }

    @Override
    public List<Permission> getPermissionByUserId(Long id) {
        
        List<Permission> permissions= permissionMapper.findPermissionByUserId(id);
        
        return  PermissionUtil.getPermissionList(permissions);
    }

    @Override
    public List<Permission> getPermissionByUserIdAndResourceType(Long id, String type) {
        return permissionMapper.findPermissionByUserIdAndResourceType(id, type);
    }
    
    public List<String> findAllResourceType(){
        return permissionMapper.findAllResourceType();
    }
}
