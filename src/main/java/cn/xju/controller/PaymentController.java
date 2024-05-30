package cn.xju.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cn.xju.entity.Order;
import cn.xju.service.OrderService;
import cn.xju.util.DateUtil;


@Controller
public class PaymentController {
    @Autowired
    OrderService orderService;
    @GetMapping("/payment/alipay/create")
    public String getMethodName(HttpServletRequest request,Model model) {
        Long orderId = Long.parseLong(request.getParameter("orderId"));
        Order order = orderService.get(orderId);
        order.setStatus(1);
        order = orderService.update(order);
        model.addAttribute("order", order);
        String endDate = DateUtil.getEndDate(order.getStartDate(), order.getQuantity());
        model.addAttribute("endDate", endDate);
        String createTime = "yyyy-MM-dd HH-MM-ss";
        SimpleDateFormat crateTimeFormat = new SimpleDateFormat(createTime);
        model.addAttribute("createTime", crateTimeFormat.format(order.getCreateTime()));
        return "payment";
    }
    
}
