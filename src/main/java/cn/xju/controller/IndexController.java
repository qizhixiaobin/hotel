package cn.xju.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cn.xju.common.constant.CommonConstant;
import cn.xju.common.vo.PageVo;
import cn.xju.entity.Category;
import cn.xju.entity.Post;
import cn.xju.service.CategoryService;
import cn.xju.service.OrderService;
import cn.xju.service.PostService;
import cn.xju.util.DateUtil;
import cn.xju.util.PageUtil;



@Controller
public class IndexController {
    @Autowired
    PostService postService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public String index(HttpServletRequest request,Model model) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.FORMAT);
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String cateId = request.getParameter("cateId");
        String page = request.getParameter("page");
        Date date = new Date();
        if(startDate == null || startDate.compareTo(simpleDateFormat.format(date))<0||startDate.equals("")){
            
            startDate = simpleDateFormat.format(date);
        }
        if(endDate == null || endDate.compareTo(simpleDateFormat.format(date))<0||endDate.equals("")){
            endDate = simpleDateFormat.format(DateUtil.getTomorrowDate());
        }
        if(cateId ==null||cateId.equals("")){
            cateId = "0";
        }
        
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("cateId", cateId);
        List <Post> postsList= postService.getAll(cateId,startDate,endDate);
        Integer totalPage = new Integer(0);
        if(postsList.size()%CommonConstant.PAGENUM!=0){
            totalPage=postsList.size()/CommonConstant.PAGENUM+1;
        }else{
            totalPage=postsList.size()/CommonConstant.PAGENUM;
        }
        if(page == null||page.equals("")){
            page = "1";
        }
        model.addAttribute("page", page);
        Integer pageNum = Integer.parseInt(page);
        PageVo pageVo = new PageVo(pageNum,CommonConstant.PAGENUM);
        List<Post> posts = PageUtil.listToPage(pageVo, postsList); 
        model.addAttribute("posts", posts);
        List<String> pages = new ArrayList<>();
        if(totalPage>5){
            if(pageNum==1||pageNum==2){
                for(int i=1;i<=5;i++){
                    pages.add(String.valueOf(i));
                }
            }else if(pageNum==totalPage||pageNum==totalPage-1){
                for(int i = 4;i>=0;i--){
                    pages.add(String.valueOf(totalPage-i));
                }
            }else{
                for(int i = -2;i<=2;i++){
                    pages.add(String.valueOf(pageNum+i));
                }
            }
        }else{
            for(int i = 1;i<=totalPage;i++){
                pages.add(String.valueOf(i));
            }
        }
        model.addAttribute("pages", pages);
        model.addAttribute("lastPage", totalPage);
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }
    
    
}
