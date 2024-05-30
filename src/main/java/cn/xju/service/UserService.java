package cn.xju.service;

import cn.xju.common.base.BaseService;
import cn.xju.entity.User;

public interface UserService extends BaseService<User,Long>{
    User checkPass(User user);
    User checkUser(User user);
}
