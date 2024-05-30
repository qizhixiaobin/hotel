package cn.xju.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.xju.entity.Record;
import cn.xju.mapper.RecordMapper;
import cn.xju.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService{
    @Autowired
    RecordMapper recordMapper;

    @Override
    public BaseMapper<Record> getRepository() {
        return recordMapper;
    }

    @Override
    public QueryWrapper<Record> getQueryWrapper(Record e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQueryWrapper'");
    }
    
}
