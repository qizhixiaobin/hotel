package cn.xju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;   


import cn.xju.entity.Category;
import cn.xju.mapper.CategoryMapper;
import cn.xju.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public BaseMapper<Category> getRepository() {
        return categoryMapper;
    }

    @Override
    public QueryWrapper<Category> getQueryWrapper(Category e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQueryWrapper'");
    }

    @Override
    public List<Long> selectChildCateIds(String pathTrace) {
        return categoryMapper.selectChildCateIds(pathTrace);
    }

    
}
