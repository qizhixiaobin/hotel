package cn.xju.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.xju.common.vo.PageVo;
import cn.xju.entity.Category;
import cn.xju.entity.Order;
import cn.xju.entity.Permission;
import cn.xju.entity.Post;
import cn.xju.entity.Role;
import cn.xju.entity.User;
import cn.xju.service.CategoryService;
import cn.xju.service.OrderService;
import cn.xju.service.PermissionService;
import cn.xju.service.PostService;
import cn.xju.service.RoleService;
import cn.xju.service.UserService;
import cn.xju.util.DateUtil;
import cn.xju.util.PageUtil;
import cn.xju.util.PermissionUtil;







@Controller
public class MenuController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    @GetMapping("/admin")
    public String admin() {
        return "admin/index";
    }
    @GetMapping("/admin/user/profile")
    public String getMethodName() {
        return "admin/profile";
    }
    @GetMapping("/admin/order")
    public String adminOrder(HttpServletRequest request,Model model) {
        Integer page =1;
        Integer status = -1;
        String keywords = request.getParameter("keywords");
        if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }else if(request.getParameter("status")!=null){
            status = Integer.parseInt(request.getParameter("status"));
        }
        QueryWrapper<Order> orderWrapper = new QueryWrapper<>();
        if(status>=0){
            orderWrapper.eq("status", status);
        }
        User user = (User)request.getSession().getAttribute("user");
        if(user.getRole()!="admin"){
            orderWrapper.eq("user_id", user.getId());
        }
        List<Order> orders = orderService.findAll(orderWrapper);
        PageVo pageVo = new PageVo(page,10);
        List<Order> orderpage = PageUtil.listToPage(pageVo, orders);
        model.addAttribute("orders", orderpage);
        List<String> endDates =  new ArrayList<>();
        List<String> createTime = new ArrayList<>();
        for(Order order:orderpage){
            endDates.add(DateUtil.getEndDate(order.getStartDate(), order.getQuantity()));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            createTime.add(simpleDateFormat.format(order.getCreateTime()));
        }
        model.addAttribute("endDates", endDates);
        model.addAttribute("createTime", createTime);
        Integer toatlPage = 0;
        if(orders.size()%10==0){
            toatlPage = orders.size()/10;
        }else{
            toatlPage = orders.size()/10+1;
        }
        model.addAttribute("status", status);
        model.addAttribute("page", page);
        model.addAttribute("finalPage", toatlPage);
        model.addAttribute("keyword", keywords);
        
        return "admin/order";
    }
    @GetMapping("/admin/order/finance")
    public String adminOrderFinance(HttpServletRequest request,Model model) {
        Integer page = 1;
        String startDate = null;
        String endDate = null;
        if(request.getParameter("startDate")!=null){
            startDate = request.getParameter("startDate");
        }else if(request.getParameter("endDate")!=null){
            endDate = request.getParameter("endDate");
        }else if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        List<Order> orders = orderService.getAll(startDate,endDate);
        PageVo pageVo = new PageVo(page,10);
        List<Order> orderpage = PageUtil.listToPage(pageVo, orders);
        model.addAttribute("orders", orderpage);
        Integer totalPrice = orderService.getTotalPrice(startDate, endDate);
        model.addAttribute("totalPrice", totalPrice);
        List<String> endDates =  new ArrayList<>();
        List<String> createTime = new ArrayList<>();
        for(Order order:orderpage){
            endDates.add(DateUtil.getEndDate(order.getStartDate(), order.getQuantity()));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            createTime.add(simpleDateFormat.format(order.getCreateTime()));
        }
        model.addAttribute("endDates", endDates);
        model.addAttribute("createTime", createTime);
        model.addAttribute("endDate", endDate);
        model.addAttribute("startDate", startDate);
        Integer toatlPage = 0;
        if(orders.size()%10==0){
            toatlPage = orders.size()/10;
        }else{
            toatlPage = orders.size()/10+1;
        }
        model.addAttribute("page", page);
        model.addAttribute("finalPage", toatlPage);
        return "admin/finance";
    }
    
    @GetMapping("/admin/user/{role}")
    public String adminUser(@PathVariable("role") String role,HttpServletRequest request,Model model) {
        if(role.equals("new")){
            String currentRole = request.getParameter("currentRole");
            model.addAttribute("currentRole", currentRole);
            List<Role> roles = roleService.findAll();
            model.addAttribute("roles", roles);
            return "admin/newUser";
        }
        model.addAttribute("role", role);
        Integer page =1;
        if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("user"));
        }
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.eq("role", role);
        List<User> users = userService.findAll(userWrapper);
        PageVo pageVo = new PageVo(page,10);
        List<User> userpage = PageUtil.listToPage(pageVo, users);
        model.addAttribute("users", userpage);
        List<String> createTime = new ArrayList<>();
        for(User user:userpage){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            createTime.add(simpleDateFormat.format(user.getCreateTime()));
        }
        model.addAttribute("createTime", createTime);
        Integer toatlPage = 0;
        if(users.size()%10==0){
            toatlPage = users.size()/10;
        }else{
            toatlPage = users.size()/10+1;
        }
        model.addAttribute("page", page);
        model.addAttribute("finalPage", toatlPage);
        return "admin/user";
    }
    
    @GetMapping("/admin/post")
    public String adminPost(HttpServletRequest request,Model model) {
        Integer page = 1;
        if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        Integer status = 0;
        if(request.getParameter("status")!=null){
            status = Integer.parseInt(request.getParameter("status"));
        }
        model.addAttribute("status", status);
        QueryWrapper<Post> postWrapper = new QueryWrapper<>();
        postWrapper.eq("post_status", status);
        List<Post> posts = postService.findAll(postWrapper);
        PageVo pageVo = new PageVo(page, 10);
        List<Post> postpage = PageUtil.listToPage(pageVo,posts);
        for(Post post:postpage){
            post.setCategory(categoryService.get(post.getCateId()));
        }
        model.addAttribute("posts", postpage);
        model.addAttribute("page", page);
        Integer fianlPage = 0;
        if(posts.size()%10==0){
            fianlPage = posts.size()/10;
        }else{
            fianlPage = posts.size()/10+1;
        }
        model.addAttribute("finalPage", fianlPage);
        return "admin/post";
    }
    
    @GetMapping("/admin/post/new")
    public String adminPostNew(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/newPost";
    }
    
    @GetMapping("/admin/category")
    public String adminCategory(HttpServletRequest request,Model model) {
        Integer page = 1;
        if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        model.addAttribute("page", page);
        List<Category> categories = categoryService.findAll();
        PageVo pageVo = new PageVo(page, 10);
        List<Category> catePage = PageUtil.listToPage(pageVo, categories);
        model.addAttribute("categories", catePage);
        Integer finalPage = 0;
        if(categories.size()%10==0){
            finalPage = categories.size()/10;
        }else{
            finalPage = categories.size()/10+1;
        }
        model.addAttribute("finalPage", finalPage);
        return "admin/category";
    }
    
    @GetMapping("/admin/role")
    public String getMethodName(HttpServletRequest request,Model model) {
        Integer page = 1;
        if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        model.addAttribute("page", page);
        List<Role> roles = roleService.findAll();
        PageVo pageVo = new PageVo(page, 10);
        List<Role> rolePage = PageUtil.listToPage(pageVo, roles);
        model.addAttribute("roles", rolePage);
        Integer finalPage = 0;
          if(roles.size()%10==0){
            finalPage = roles.size()/10;
        }else{
            finalPage = roles.size()/10+1;
        }
        model.addAttribute("finalPage", finalPage);
        return "admin/role";
    }
    
    @GetMapping("/admin/role/new")
    public String adminRoleNew() {
        return "admin/newRole";
    }
    
    @GetMapping("/admin/permission")
    public String adminPermission(HttpServletRequest request,Model model) {
         Integer page = 1;
        if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        model.addAttribute("page", page);
        List<Permission> permissions = permissionService.findAll();
        PageVo pageVo = new PageVo(page, 10);
        List<Permission> permissionPage = PageUtil.listToPage(pageVo, permissions);
        model.addAttribute("permissions", permissionPage);
         Integer finalPage = 0;
          if(permissions.size()%10==0){
            finalPage = permissions.size()/10;
        }else{
            finalPage = permissions.size()/10+1;
        }
        model.addAttribute("finalPage", finalPage);
        return "admin/permission";
    }
    
    @GetMapping("/admin/permission/new")
    public String adminPermissionNer(Model model) {
        QueryWrapper<Permission> permissionWrapper = new QueryWrapper<>();
        permissionWrapper.ne("resource_type","接口");
        List<Permission> permissions = PermissionUtil.getPermissionList(permissionService.findAll(permissionWrapper));
        model.addAttribute("permissions", permissions);
        return "admin/newPermission";
    }
    @GetMapping("/admin/clean")
    public String adminclean() {
        return "admin/updating";
    }
    
    @GetMapping("/admin/inrecord")
    public String adminInrecord() {
        return "admin/updating";
    }

    @GetMapping("/admin/outrecord")
    public String adminOutrecord() {
        return "admin/updating";
    }

    @GetMapping("/admin/user/edit")
    public String adminUserEdit(@RequestParam("id") Long id,Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        Role role = roleService.findByUserId(id);
        model.addAttribute("r", role);
        List<Role> roles= roleService.findAll();
        model.addAttribute("roles", roles);
        return "admin/userEdit";
    }
    
    @GetMapping("/admin/post/edit")
    public String getMethodName(@RequestParam("id") Long id,Model model) {
        Post post = postService.get(id);
        post.setCategory(categoryService.get(post.getCateId()));
        model.addAttribute("post", post);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/postEdit";
    }
    
    @GetMapping("/admin/category/edit")
    public String adminCategoryEdit(HttpServletRequest request,Model model,@RequestParam("id") Long id) {
        Integer page = 1;
        if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        model.addAttribute("page", page);
        List<Category> categories = categoryService.findAll();
        PageVo pageVo = new PageVo(page, 10);
        List<Category> catePage = PageUtil.listToPage(pageVo, categories);
        model.addAttribute("categories", catePage);
        Integer finalPage = 0;
        if(categories.size()%10==0){
            finalPage = categories.size()/10;
        }else{
            finalPage = categories.size()/10+1;
        }
        model.addAttribute("finalPage", finalPage);
        Category cate = categoryService.get(id);
        model.addAttribute("cate", cate);
        return "admin/categoryEdit";
    }
    
    
}
