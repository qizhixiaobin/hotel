package cn.xju.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xju.common.constant.CommonConstant;
import cn.xju.dto.JsonResult;
import cn.xju.entity.User;
import cn.xju.service.UserService;
import cn.xju.util.Md5Util;



@RestController
public class AdminUserRestController {
    @Autowired
    UserService userService;

    @PostMapping("/admin/user/deleteBind")
    public JsonResult adminUserDeleteBind(@RequestParam("id") Long id) {
        //TODO: process POST request
        
        return JsonResult.success(null);
    }
    
    @PostMapping("/admin/user/changePass")
    public JsonResult adminUserChangePass(@RequestParam("beforePass") String beforePass,@RequestParam("newPass") String newPass,HttpServletRequest request) {
        User user = new User();
        user = (User)request.getSession().getAttribute("user");
        if(user.getUserPass().equals(Md5Util.toMd5(beforePass, CommonConstant.PASSWORD_SALT, 1))){
            user.setUserPass(Md5Util.toMd5(newPass, CommonConstant.PASSWORD_SALT, 1));
            userService.update(user);
            return JsonResult.success();
        }else{
            return JsonResult.error("旧密码不正确");
        }


    }
    @PostMapping("/admin/user/profile/save")
    public JsonResult postMethodName(@RequestParam("userName")String userName,@RequestParam("userAvatar") String userAvatar,@RequestParam("userDisplayName") String userDisplayName, @RequestParam("idCard") String idCard,@RequestParam("userDesc") String userDesc,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        user.setUserAvatar(userAvatar);
        user.setUserName(userName);
        user.setUserDisplayName(userDisplayName);
        user.setUserDesc(userDesc);
        user.setIdCard(idCard);
        user.setUpdateTime(new Date());
        user.setUpdateBy(user.getUserName());
        userService.update(user);
        return JsonResult.success();
    }
    
    
}
