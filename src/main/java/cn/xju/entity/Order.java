package cn.xju.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.xju.common.base.BaseEntity;
import lombok.Data;

/**
 * 订单
 */
@Data
@TableName("t_order")
public class Order extends BaseEntity {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 房间ID
     */
    private Long postId;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 住客姓名
     */
    private String name;

    /**
     * 联系手机
     */
    private String phone;


    /**
     * 身份证
     */
    private String idCard;

    /**
     * 入店日期
     */
    private String startDate;


    /**
     * 订单状态：0待支付，1已支付，2已完结
     */
    private Integer status;

    private Integer price;
    private Integer totalPrice;
    private String postTitle;
    private String postNumber;

}
