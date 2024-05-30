package cn.xju.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cn.xju.entity.Post;
import cn.xju.service.OrderService;
import cn.xju.service.PostService;
import cn.xju.util.DateUtil;




@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    PostService postService;

    @GetMapping("/checkout")
    public String checkout(HttpServletRequest request, Model model) {
        Long id = Long.parseLong(request.getParameter("postId"));
        String startDate = request.getParameter("startDate");
        model.addAttribute("startDate", startDate);
        String endDate = request.getParameter("endDate");
        model.addAttribute("endDate", endDate);
        Integer quantity = DateUtil.getBetweenDates(startDate, endDate).size();
        model.addAttribute("quantity",quantity);
        Post post = postService.get(id);
        model.addAttribute("post", post);
        return "order";
    }


    
}
