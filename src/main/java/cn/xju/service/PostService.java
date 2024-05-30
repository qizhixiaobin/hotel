package cn.xju.service;

import java.util.List;

import cn.xju.common.base.BaseService;
import cn.xju.entity.Post;

public interface PostService extends BaseService<Post,Long>{
    //首页分页获取所有，并将category填入
    List<Post> getAll(String cateId,String startDate,String endDate);
}
