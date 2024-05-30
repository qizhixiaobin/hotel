package cn.xju.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xju.dto.JsonResult;
import cn.xju.entity.Category;
import cn.xju.service.CategoryService;



@RestController
public class CategoryResrController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/admin/category/save")
    public JsonResult categorySave(@RequestParam("cateName")String cateName,@RequestParam("cateSort") Integer cateSort,@RequestParam("cateDesc") String cateDesc,HttpServletRequest request) {
        Category category = new Category();
        if(request.getParameter("id")!=null){
            category.setId(Long.parseLong(request.getParameter("id")));
        }
        category.setCateDesc(cateDesc);
        category.setCateName(cateName);
        category.setCateSort(cateSort);
        categoryService.insertOrUpdate(category);
        return JsonResult.success();
    }
    @PostMapping("/admin/category/delete")
    public JsonResult categoryDelete(@RequestParam("id") Long id) {
        categoryService.delete(id);
        
        return JsonResult.success();
    }
    
}
