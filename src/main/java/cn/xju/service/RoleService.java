package cn.xju.service;

import cn.xju.common.base.BaseService;
import cn.xju.entity.Role;

public interface RoleService extends BaseService<Role,Long>{
    Role findByUserId(Long userId);
}
