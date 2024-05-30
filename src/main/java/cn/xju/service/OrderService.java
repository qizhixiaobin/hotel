package cn.xju.service;

import java.util.List;

import cn.xju.common.base.BaseService;
import cn.xju.entity.Order;

public interface OrderService extends BaseService<Order,Long>{
    List<Order> getAll(String startDate,String endDate);
    Integer getTotalPrice(String startDate,String endDate);
}
