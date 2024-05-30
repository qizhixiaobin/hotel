package cn.xju.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.xju.common.base.BaseEntity;
import lombok.Data;

/**
 * 预定记录
 */
@Data
@TableName("record")
public class Record extends BaseEntity {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 房间ID
     */
    private Long postId;

    /**
     * 入店日期
     */
    private String recordDate;


}
