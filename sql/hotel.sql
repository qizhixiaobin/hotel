 


CREATE TABLE `role` (  
    `id` BIGINT NOT NULL AUTO_INCREMENT,  
    `del_flag` INT DEFAULT 0 NOT NULL COMMENT '删除状态：1删除，0未删除',  
    `create_by` VARCHAR(255) COMMENT '创建人手机号',  
    `create_time` DATETIME COMMENT '创建时间',  
    `update_by` VARCHAR(255) COMMENT '更新人',  
    `update_time` DATETIME COMMENT '更新时间',  
    `role` VARCHAR(255) NOT NULL UNIQUE COMMENT '角色名称：admin，author，subscriber',  
    `description` VARCHAR(255) COMMENT '描述：管理员，作者，订阅者',  
    `level` INT COMMENT '级别',  
    `is_register_default` INT  COMMENT '用户注册默认角色1',  
    PRIMARY KEY (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `user` (  
    `id` BIGINT NOT NULL AUTO_INCREMENT,  
    `del_flag` INT DEFAULT 0 NOT NULL COMMENT '删除状态：1删除，0未删除',  
    `create_by` VARCHAR(255) COMMENT '创建人手机号',  
    `create_time` DATETIME COMMENT '创建时间',  
    `update_by` VARCHAR(255) COMMENT '更新人',  
    `update_time` DATETIME COMMENT '更新时间',  
    `user_name` VARCHAR(255) NOT NULL COMMENT '手机号',  
    `user_display_name` VARCHAR(255) COMMENT '显示名称',  
    `user_pass` VARCHAR(255) NOT NULL COMMENT '密码',  
    `id_card` VARCHAR(255) COMMENT '身份证号码',  
    `user_avatar` VARCHAR(255) DEFAULT '\images\avatar\1.jpeg' COMMENT '头像',  
    `user_desc` TEXT COMMENT '说明',  
    `login_last` DATETIME COMMENT '最后一次登录时间',  
    `status` INT DEFAULT 0 NOT NULL COMMENT '0 正常，1 禁用，2 已删除',  
    `role` VARCHAR(255) DEFAULT 'customer' COMMENT '角色名称', 
    PRIMARY KEY (`id`) , 
    FOREIGN KEY (`role`) REFERENCES `role` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `category` (  
    `id` BIGINT NOT NULL AUTO_INCREMENT,  
    `del_flag` INT DEFAULT 0 NOT NULL COMMENT '删除状态：1删除，0未删除',  
    `create_by` VARCHAR(255) COMMENT '创建人手机号',  
    `create_time` DATETIME COMMENT '创建时间',  
    `update_by` VARCHAR(255) COMMENT '更新人',  
    `update_time` DATETIME COMMENT '更新时间',  
    `cate_name` VARCHAR(255) NOT NULL COMMENT '分类名称',  
    `cate_sort` INT COMMENT '分类排序号',  
    `cate_desc` VARCHAR(255) COMMENT '分类描述',  
    PRIMARY KEY (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `post` (  
    `id` BIGINT NOT NULL AUTO_INCREMENT,  
    `del_flag` INT DEFAULT 0 NOT NULL COMMENT '删除状态：1删除，0未删除',  
    `create_by` VARCHAR(255) COMMENT '创建人手机号',  
    `create_time` DATETIME COMMENT '创建时间',  
    `update_by` VARCHAR(255) COMMENT '更新人',  
    `update_time` DATETIME COMMENT '更新时间',  
    `post_title` VARCHAR(255) NOT NULL COMMENT '客房标题',  
    `post_content` TEXT COMMENT '客房描述',  
    `post_summary` TEXT COMMENT '客房摘要', 
    `max_people` INT NOT NULL DEFAULT 1 COMMENT'最大容纳人数', 
    `post_thumbnail` VARCHAR(255) COMMENT '缩略图',  
    `post_status` INT NOT NULL DEFAULT 0 COMMENT '状态：0正常，1已预订，2下架',  
    `price` INT NOT NULL COMMENT '价格',  
    `number` VARCHAR(255) NOT NULL COMMENT '房间编号',  
    `cate_id` BIGINT NOT NULL COMMENT '分类ID',  
    `img_url` VARCHAR(255) COMMENT '图片URL',  
    `post_editor` TEXT COMMENT '富文本',  
    PRIMARY KEY (`id`),
    FOREIGN KEY (`cate_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_order` (  
    `id` BIGINT NOT NULL AUTO_INCREMENT,  
    `del_flag` INT DEFAULT 0 NOT NULL COMMENT '删除状态：1删除，0未删除',  
    `create_by` VARCHAR(255) COMMENT '创建人手机号',  
    `create_time` DATETIME COMMENT '创建时间',  
    `update_by` VARCHAR(255) COMMENT '更新人',  
    `update_time` DATETIME COMMENT '更新时间',  
    `user_id` BIGINT NOT NULL COMMENT '用户ID',  
    `post_id` BIGINT NOT NULL COMMENT '房间ID',  
    `quantity` INT COMMENT '数量',  
    `name` VARCHAR(255) NOT NULL COMMENT '住客姓名',  
    `phone` VARCHAR(255) NOT NULL COMMENT '联系手机',  
    `id_card` VARCHAR(255) NOT NULL COMMENT '身份证',  
    `start_date` DATE NOT NULL COMMENT '入店日期',  
    `status` INT NOT NULL DEFAULT 0 COMMENT '订单状态：0待支付，1已支付，2已完结',  
    `price` INT COMMENT '价格',  
    `total_price` INT COMMENT '总价格',  
    `post_title` VARCHAR(255) COMMENT '文章标题',  
    `post_number` VARCHAR(255) COMMENT '房间号',  
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `link` (  
    `id` BIGINT NOT NULL AUTO_INCREMENT,  
    `del_flag` INT DEFAULT 0 NOT NULL COMMENT '删除状态：1删除，0未删除',  
    `create_by` VARCHAR(255) COMMENT '创建人手机号',  
    `create_time` DATETIME COMMENT '创建时间',  
    `update_by` VARCHAR(255) COMMENT '更新人',  
    `update_time` DATETIME COMMENT '更新时间',  
    `link_name` VARCHAR(255) NOT NULL COMMENT '友情链接名称',  
    `link_url` VARCHAR(255) NOT NULL COMMENT '友情链接地址',  
    `link_pic` VARCHAR(255) COMMENT '友情链接头像',  
    `link_desc` VARCHAR(255) COMMENT '友情链接描述',  
    PRIMARY KEY (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `permission` (  
    `id` BIGINT NOT NULL AUTO_INCREMENT,  
    `del_flag` INT DEFAULT 0 NOT NULL COMMENT '删除状态：1删除，0未删除',  
    `create_by` VARCHAR(255) COMMENT '创建人手机号',  
    `create_time` DATETIME COMMENT '创建时间',  
    `update_by` VARCHAR(255) COMMENT '更新人',  
    `update_time` DATETIME COMMENT '更新时间',  
    `name` VARCHAR(255) NOT NULL COMMENT '权限名称',  
    `pid` BIGINT COMMENT 'pid',  
    `resource_type` VARCHAR(255) COMMENT '资源类型',  
    `url` VARCHAR(255) COMMENT '请求URL',  
    `icon` VARCHAR(255) COMMENT '图标',  
    `sort` DOUBLE COMMENT '序号(越小越靠前)',  
    PRIMARY KEY (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `record` (  
    `id` BIGINT NOT NULL AUTO_INCREMENT,  
    `del_flag` INT DEFAULT 0 NOT NULL COMMENT '删除状态：1删除，0未删除',
    `create_by` VARCHAR(255) COMMENT '创建人手机号', 
    `create_time` DATETIME COMMENT '创建时间', 
    `update_by` VARCHAR(255) COMMENT '更新人',   
    `update_time` DATETIME COMMENT '更新时间',  
    `user_id` BIGINT NOT NULL COMMENT '用户ID',  
    `post_id` BIGINT NOT NULL COMMENT '房间ID',  
    `record_date` DATE NOT NULL COMMENT '入店日期',  
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ,
    FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `role_permission_ref` (  
    `id` BIGINT NOT NULL AUTO_INCREMENT,  
    `del_flag` INT DEFAULT 0 NOT NULL COMMENT '删除状态：1删除，0未删除', 
    `create_by` VARCHAR(255) COMMENT '创建人手机号', 
    `create_time` DATETIME COMMENT '创建时间',  
    `update_by` VARCHAR(255) COMMENT '更新人',  
    `update_time` DATETIME COMMENT '更新时间',  
    `role_id` BIGINT NOT NULL COMMENT '角色Id',  
    `permission_id` BIGINT NOT NULL COMMENT '权限Id',  
    PRIMARY KEY (`id`),  
    UNIQUE KEY `role_permission_unique` (`role_id`, `permission_id`) COMMENT '角色和权限的唯一关联',  
    FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ,
    FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `user_role_ref` (  
    `id` BIGINT NOT NULL AUTO_INCREMENT,  
    `del_flag` INT DEFAULT 0 NOT NULL COMMENT '删除状态：1删除，0未删除',  
    `create_by` VARCHAR(255) COMMENT '创建人手机号',
    `create_time` DATETIME COMMENT '创建时间',  
    `update_by` VARCHAR(255) COMMENT '更新人',  
    `update_time` DATETIME COMMENT '更新时间',  
    `user_id` BIGINT NOT NULL COMMENT '用户Id',  
    `role_id` BIGINT NOT NULL COMMENT '角色Id',  
    PRIMARY KEY (`id`),  
    UNIQUE KEY `user_role_unique` (`user_id`, `role_id`) COMMENT '用户和角色的唯一关联',
    FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;