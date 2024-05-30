package cn.xju.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xju.common.constant.CommonConstant;
import cn.xju.dto.JsonResult;
import cn.xju.entity.User;
import cn.xju.service.UserService;
import cn.xju.util.Md5Util;




@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public JsonResult login(HttpServletRequest request) {
        User user = new User();
        user.setUserName(request.getParameter("userName"));
        user.setUserPass(request.getParameter("userPass"));
        if(userService.checkUser(user)!=null){
            user = userService.checkPass(user);
            if(user!=null){
                request.getSession().setAttribute("user", user);
                return new JsonResult(1, "密码正确");
            }else{
                return new JsonResult(0, "密码错误");
            }
        }else{
            return new JsonResult(0, "账户不存在");
        }
    }
    @PostMapping("/register")
    public JsonResult register(HttpServletRequest request){
        User user = new User();
        user.setUserName(request.getParameter("userName"));
        String md5Pass = Md5Util.toMd5(request.getParameter("userPass"), CommonConstant.PASSWORD_SALT, 1);
        user.setUserPass(md5Pass);
        user.setIdCard(request.getParameter("idCard"));
        user.setUserDisplayName(request.getParameter("userDisplayName"));
        user.setCreateTime(new Date());
        if(userService.checkUser(user)!=null){
            return new JsonResult(0, "用户已存在");
        }else{
            userService.insert(user);
            return new JsonResult(1, "注册成功");
        }
    }
    @PostMapping("/logout")
    public void logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
    }
    @PostMapping("/forget")
    public JsonResult forget(HttpServletRequest request) {
        User user = new User();
        user.setUserName(request.getParameter("userName"));
        user.setUserPass(request.getParameter("userPass"));
        user.setIdCard(request.getParameter("idCard"));
        user = userService.checkUser(user);
        if(userService.update(user)!=null){
             return new JsonResult(0, "密码已重置");
        }else{
            return new JsonResult(1, "账号不存在");
        }
    }
    @GetMapping("/checkLogin")
    public JsonResult checkLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if(user!=null){
            return new JsonResult(1, "成功");
        }else{
            return new JsonResult(0, "请登录后预定");
        }
    }
    
    
}
