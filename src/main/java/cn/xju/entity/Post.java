package cn.xju.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.xju.common.base.BaseEntity;
import lombok.Data;


@Data
@TableName("post")
public class Post extends BaseEntity {

    /**
     * 客房标题
     */
    private String postTitle;

    /**
     * 客房描述
     */
    private String postContent;

    /**
     * 客房摘要
     */
    private String postSummary;

    /**
     * 客房摘要
     */
    private Integer maxPeople;

    /**
     * 缩略图
     */
    private String postThumbnail;

    /**
     * 0 正常
     * 1 已预订
     * 2 下架
     */
    private Integer postStatus;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 房间编号
     */
    private String number;

    /**
     * 分类ID
     */
    private Long cateId;

    /**
     * 图片URL
     */
    private String imgUrl;

    /**
     * 富文本
     */
    private String postEditor;

    /**
     * 客房所属分类
     */
    @TableField(exist = false)
    private Category category;

}