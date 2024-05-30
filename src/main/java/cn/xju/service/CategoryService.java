package cn.xju.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.xju.common.base.BaseService;
import cn.xju.entity.Category;

public interface CategoryService extends BaseService<Category,Long>{
    /**
     * 获得子分类Id列表
     *
     * @param  pathTrace /138/ 这种格式
     * @return 子分类Id列表
     */
    List<Long> selectChildCateIds(@Param("pathTrace") String pathTrace);
    
}
