package cn.xju.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xju.common.constant.CommonConstant;
import cn.xju.dto.JsonResult;
import cn.xju.entity.User;
import cn.xju.service.RoleService;
import cn.xju.service.UserService;
import cn.xju.util.Md5Util;



@RestController
public class UserRestController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @PostMapping("/admin/user/save")
    public JsonResult adminUserSave(@RequestParam("userName") String userName,@RequestParam("userDisplayName") String userDisplayName,@RequestParam("idCard") String idCard,@RequestParam("userDesc") String userDesc,@RequestParam("status") Integer status,HttpServletRequest request) {   
        User user = new User();
        Long id =null;
        if(request.getParameter("id")!=null){
            id = Long.parseLong(request.getParameter("id"));
            user.setId(id);
            user.setCreateTime(new Date());
        }
        user.setIdCard(idCard);
        user.setCreateTime(new Date());
        if(request.getParameter("roleId")!=null){
            Long roleId = Long.parseLong(request.getParameter("roleId"));
            user.setRole(roleService.get(roleId).getRole());
        }
        user.setUserDesc(userDesc);
        user.setUserName(userName);
        user.setUserDisplayName(userDisplayName);
        if(request.getParameter("userPass")!=null){
            String userPass =null;
            user.setUserPass(Md5Util.toMd5(userPass, CommonConstant.PASSWORD_SALT, 1));
        }
        user.setStatus(status);
        userService.insertOrUpdate(user);
        return JsonResult.success();
    }
    @PostMapping("/admin/user/delete")
    public JsonResult adminUserDelete(@RequestParam("id") Long id) {
        userService.delete(id);
        return JsonResult.success();
    }
    @PostMapping("/admin/user/batchDelete")
    public JsonResult batchDelete(@RequestParam("ids") List<Long> ids) {
        userService.batchDelete(ids);
        return JsonResult.success();
    }
    
    
    
}
