INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#1
VALUES('12345678910',NOW(),'首页',0,'菜单','/admin',0);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'获得当前登录用户信息接口',1,'接口','/admin/currentUser',0);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'获得当前登录用户角色接口',1,'接口','/admin/currentRole',0);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'获得侧边栏菜单',1,'接口','/admin/currentMenus',0);

INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#5
VALUES('12345678910',NOW(),'客房管理',0,'菜单','/admin/post',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#6
VALUES('12345678910',NOW(),'客房列表',5,'菜单','/admin/post',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'删除客房',6,'接口','/admin/post/delete',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'批量删除客房',6,'接口','/admin/post/batchDelete',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'编辑客房信息',6,'页面','/admin/post/edit',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'还原客房',6,'接口','/admin/post/revert',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'移到回收站',6,'接口','/admin/post/throw',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#12
VALUES('12345678910',NOW(),'新增客房',5,'菜单','/admin/post/new',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'保存客房',12,'接口','/admin/post/save',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'文件上传',12,'接口','/admin/file/upload',10);

INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#15
VALUES('12345678910',NOW(),'客房类型管理',0,'菜单','/admin/category',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#16
VALUES('12345678910',NOW(),'类型列表',15,'菜单','/admin/category',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'保存类型',16,'接口','/admin/category/save',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'编辑类型',16,'接口','/admin/category/edit',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'删除类型',16,'接口','/admin/category/delete',10);

INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#20
VALUES('12345678910',NOW(),'订单管理',0,'菜单','/admin/order',1);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'删除订单',20,'接口','/admin/order/delete',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'完结订单',20,'接口','/admin/order/finish',1);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'取消订单',20,'接口','/admin/order/cancel',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'续订订单',20,'接口','/admin/order/extend',1);

INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#25
VALUES('12345678910',NOW(),'入住登记管理',0,'菜单','/admin/inrecord',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'添加入住登记',25,'接口','/admin/inrecord/new',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'编辑入住登记',25,'接口','/admin/inrecord/edit',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'删除入住登记',25,'接口','/admin/inrecord/delete',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'保存入住登记',25,'接口','/admin/inrecord/save',5);

INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#30
VALUES('12345678910',NOW(),'退房登记管理',0,'菜单','/admin/outrecord',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'添加退房登记',30,'接口','/admin/outrecord/new',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'编辑退房登记',30,'接口','/admin/outrecord/edit',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'删除退房登记',30,'接口','/admin/outrecord/delete',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'保存退房登记',30,'接口','/admin/outrecord/save',5);

INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#35
VALUES('12345678910',NOW(),'客房清洁管理',0,'菜单','/admin/clean',2);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'完成清洁',35,'接口','/admin/clean/finish',2);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'清洁删除',35,'接口','/admin/clean/delete',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'开始清洁',35,'接口','/admin/clean/start',2);

INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#39
VALUES('12345678910',NOW(),'财务管理','菜单',0,'/admin/order/finance',5);

INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#40
VALUES('12345678910',NOW(),'人员管理','菜单',0,'/admin/user/worker',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'添加工作人员',40,'接口','/admin/user/new',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'前台人员管理',40,'菜单','/admin/user/worker',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'清洁人员管理',40,'菜单','/admin/user/cleaner',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#44
VALUES('12345678910',NOW(),'客户管理',40,'菜单','/admin/user/customer',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'用户保存',44,'接口','/admin/user/save',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'删除用户',44,'接口','/admin/user/delete',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'批量删除用户',44,'接口','/admin/user/batchDelete',5);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'编辑用户',44,'接口','/admin/user/edit',5);

INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#49
VALUES('12345678910',NOW(),'角色管理',0,'菜单','/admin/role',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#50
VALUES('12345678910',NOW(),'角色列表',49,'菜单','/admin/role',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'编辑角色',50,'页面','/admin/role/edit',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'删除角色',50,'接口','/admin/role/delete',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#53
VALUES('12345678910',NOW(),'添加角色',49,'菜单','/admin/role/new',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'保存角色',53,'接口','/admin/role/save',10);

INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#55
VALUES('12345678910',NOW(),'权限管理',0,'菜单','/admin/permission',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#56
VALUES('12345678910',NOW(),'权限列表',55,'菜单','/admin/permission',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'编辑权限',56,'页面','/admin/permission/edit',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'删除权限',56,'接口','/admin/permission/delete',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#59
VALUES('12345678910',NOW(),'添加权限',55,'菜单','/admin/permission/new',10);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'保存权限',59,'接口','/admin/permission/save',10);

INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#61
VALUES('12345678910',NOW(),'个人信息',0,'页面','/admin/user/profile',0);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)
VALUES('12345678910',NOW(),'保存个人信息',61,'接口','/admin/user/profile/save',0);
INSERT INTO `permission` (`create_by`,`create_time`,`name`,`pid`,`resource_type`,`url`,`sort`)#63
VALUES('12345678910',NOW(),'修改密码',61,'接口','/admin/user/changePass',0);







