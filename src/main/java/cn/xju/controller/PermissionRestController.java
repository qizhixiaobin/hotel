package cn.xju.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xju.entity.Permission;
import cn.xju.service.PermissionService;


@RestController
public class PermissionRestController {
    @Autowired
    PermissionService permissionService;
    @PostMapping("/admin/permission/load")
    public List<Permission> load() {
        List<Permission> permissions = permissionService.findAll();
        return permissions;
    }
    
}
