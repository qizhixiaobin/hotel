package cn.xju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.xju.dto.PostQueryCondition;
import cn.xju.entity.Post;


@Mapper
public interface PostMapper extends BaseMapper<Post> {
    /**
     * 根据标签ID查询客房
     *
     * @param condition
     * @param page
     * @return
     */
    List<Post> findPostByCondition(@Param("condition") PostQueryCondition condition, Page<Post> page);

    /**
     * 统计该分类的客房
     * @param cateId
     * @return
     */
    Integer countPostByCateId(Long cateId);
}

