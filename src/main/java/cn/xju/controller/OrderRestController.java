package cn.xju.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.xju.dto.JsonResult;
import cn.xju.entity.Order;
import cn.xju.entity.Post;
import cn.xju.entity.User;
import cn.xju.service.OrderService;
import cn.xju.service.PostService;
import cn.xju.util.DateUtil;


@RestController
public class OrderRestController {
    @Autowired
    OrderService orderService;
    @Autowired
    PostService postService;

    @PostMapping("/order")
    public JsonResult order(HttpServletRequest request, Model model) {
        Long postId = Long.parseLong(request.getParameter("postId"));
        String startDate = request.getParameter("startDate");
        model.addAttribute("startDate", startDate);
        String endDate = request.getParameter("endDate");
        model.addAttribute("endDate", endDate);
        Integer quantity = DateUtil.getBetweenDates(startDate, endDate).size();
        if(quantity<=0){
            return JsonResult.error("至少预定一天");
        }
        model.addAttribute("quantity", quantity);
        Post post = postService.get(postId);
        User user = (User) request.getSession().getAttribute("user");
        Order order = new Order();
        order.setCreateBy("orderController");
        order.setCreateTime(new Date());
        order.setName(request.getParameter("userDisplayName"));
        order.setIdCard(request.getParameter("idCard"));
        order.setPhone(request.getParameter("userName"));
        order.setPostId(post.getId());
        order.setPostNumber(post.getNumber());
        order.setPostTitle(post.getPostTitle());
        order.setPrice(post.getPrice());
        order.setQuantity(quantity);
        order.setStartDate(startDate);
        order.setTotalPrice(quantity * post.getPrice());
        order.setUserId(user.getId());
        orderService.insert(order);
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("post_id", post.getId());
        queryWrapper.eq("start_date", startDate);
        order = orderService.findAll(queryWrapper).get(0);
        return JsonResult.success("创建成功", order.getId());

    }

    @GetMapping("/checkOrder")
    public JsonResult checkOrder(HttpServletRequest request) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("post_id", request.getParameter("postId"));
        queryWrapper.eq("start_date", request.getParameter("startDate"));
        if (orderService.findAll(queryWrapper).size() > 0) {
            return new JsonResult(0, "已有订单");
        } else {
            return new JsonResult(1, "");
        }
    }


    @PostMapping("/admin/order/delete")
    public JsonResult orderDelete(@RequestParam("id") Long id){
        orderService.delete(id);
        return JsonResult.success();
    }

    @PostMapping("/admin/order/finish")
    public JsonResult finish(@RequestParam("id") Long id) {
        Order order  = orderService.get(id);
        order.setStatus(2);
        orderService.insertOrUpdate(order);
        return JsonResult.success();
    }
    
}
