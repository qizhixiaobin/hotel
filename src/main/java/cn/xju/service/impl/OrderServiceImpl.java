package cn.xju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.xju.entity.Order;
import cn.xju.mapper.OrderMapper;
import cn.xju.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;

    @Override
    public BaseMapper<Order> getRepository() {
        return orderMapper;
    }

    @Override
    public QueryWrapper<Order> getQueryWrapper(Order e) {
        return new QueryWrapper<>();
    }

    @Override
    public List<Order> getAll(String startDate, String endDate) {
        return orderMapper.findAll(startDate, endDate, null);
    }

    @Override
    public Integer getTotalPrice(String startDate, String endDate) {
        return orderMapper.getTotalPriceSum(startDate, endDate);
    }

    
    
}
