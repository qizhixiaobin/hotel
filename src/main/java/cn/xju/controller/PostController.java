package cn.xju.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cn.xju.entity.Post;
import cn.xju.service.PostService;


@Controller
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("post/{id}")
    public String post(@PathVariable("id") String id,Model model,HttpServletRequest request) {
        String startDate = request.getParameter("startDate");
        model.addAttribute("startDate", startDate);
        String endDate = request.getParameter("endDate");
        model.addAttribute("endDate", endDate);
        Post post = postService.get(Long.parseLong(id));
        model.addAttribute("post", post);
        List<String> imgs = new ArrayList<>();
        String text = post.getPostEditor();
        String pattern = "(?<=src=\").*?(?=\")";  
        Pattern r = Pattern.compile(pattern);  
        Matcher m = r.matcher(text);  
        while(m.find()){
            imgs.add(m.group());
        }
        model.addAttribute("imgs", imgs);
        return "detail";
    }
    
}
