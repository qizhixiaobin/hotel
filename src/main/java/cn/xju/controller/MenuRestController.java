package cn.xju.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xju.dto.JsonResult;
import cn.xju.entity.Permission;
import cn.xju.entity.User;
import cn.xju.service.PermissionService;
import cn.xju.util.PermissionUtil;




@RestController
public class MenuRestController {
    @Autowired
    PermissionService permissionService;

    @GetMapping("/admin/currentUser")
    public JsonResult currentUser(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        return JsonResult.success("获取用户成功",user);
    }
    @GetMapping("/admin/currentRole")
    public JsonResult currentRole(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String role = user.getRole();
        return JsonResult.success("获取角色成功", role);
    }
    
    @GetMapping("/admin/currentMenus")
    public JsonResult currentMenus(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<Permission> permissions=permissionService.getPermissionByUserIdAndResourceType(user.getId(), "菜单");
        return JsonResult.success("获取成功", PermissionUtil.getPermissionTree(permissions) );
    }
    
    
    
    
}
