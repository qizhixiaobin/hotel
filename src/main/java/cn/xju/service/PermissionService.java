package cn.xju.service;

import java.util.List;

import cn.xju.common.base.BaseService;
import cn.xju.entity.Permission;

public interface PermissionService extends BaseService<Permission,Long>{
    List<Permission> getPermissionByUserId(Long id);
    List<Permission> getPermissionByUserIdAndResourceType(Long id, String type);
    List<String> findAllResourceType();
}
