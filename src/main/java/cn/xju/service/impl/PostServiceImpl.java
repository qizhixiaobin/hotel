package cn.xju.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.xju.entity.Order;
import cn.xju.entity.Post;
import cn.xju.mapper.PostMapper;
import cn.xju.service.CategoryService;
import cn.xju.service.OrderService;
import cn.xju.service.PostService;
import cn.xju.util.DateUtil;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostMapper postMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderService orderService;

    @Override
    public BaseMapper<Post> getRepository() {
        return postMapper;
    }

    @Override
    public QueryWrapper<Post> getQueryWrapper(Post e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQueryWrapper'");
    }

    @Override
    public List<Post> getAll(String cateId,String startDate,String endDate) {
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
        List <Post> posts= new ArrayList<>();
        if(cateId.equals("0")){
            posts= findAll();
        }else{
            queryWrapper.eq("cate_id", cateId);
            posts = findAll(queryWrapper);
        }
        Iterator<Post> iterator = posts.iterator();  
        while (iterator.hasNext()) {  
            Post post = iterator.next();  
            post.setCategory(categoryService.get(post.getCateId()));
            QueryWrapper<Order> orderWrapper = new QueryWrapper<>();
            orderWrapper.eq("post_id", post.getId());
            List<Order> orders = orderService.findAll(orderWrapper);
            for(Order order:orders){
                List <String> list1 = DateUtil.getBetweenDates(order.getStartDate(),order.getQuantity());
                Set<String> set1 = new HashSet<>(list1);
                List<String> list2 = DateUtil.getBetweenDates(startDate,endDate);
                Set<String> set2 = new HashSet<>(list2);
                if(!set1.retainAll(set2)){
                    iterator.remove();  
                    break;
                }
            }
        }
        return posts;
    }
    
}
