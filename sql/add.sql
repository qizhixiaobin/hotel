
#role

INSERT INTO `ROLE` (`create_by`,`create_time`,`role`,`description`,`level`,`is_register_default`)
    VALUES('12345678910',NOW(),'admin','管理员',10,0);
INSERT INTO `ROLE` (`create_by`,`create_time`,`role`,`description`,`level`,`is_register_default`)
    VALUES('12345678910',NOW(),'worker','前台',5,0);
INSERT INTO `ROLE` (`create_by`,`create_time`,`role`,`description`,`level`,`is_register_default`)
    VALUES('12345678910',NOW(),'cleaner','保洁',2,0);
INSERT INTO `ROLE` (`create_by`,`create_time`,`role`,`description`,`level`,`is_register_default`)
    VALUES('12345678910',NOW(),'customer','顾客',1,1);

#user

INSERT INTO `user` (`create_by`,`create_time`,`user_name`,`user_display_name`,`user_pass`,`id_card`,`user_desc`,`role`)
    VALUES('12345678910',NOW(),'admin','管理员','df8f9f0b0b86b58735d596775220c609','123456789123456789','管理员','admin');
INSERT INTO `user` (`create_by`,`create_time`,`user_name`,`user_display_name`,`user_pass`,`id_card`,`user_desc`,`role`)
    VALUES('12345678910',NOW(),'qiantai','前台','df8f9f0b0b86b58735d596775220c609','123456789123456789','前台','worker');
INSERT INTO `user` (`create_by`,`create_time`,`user_name`,`user_display_name`,`user_pass`,`id_card`,`user_desc`,`role`)
    VALUES('12345678910',NOW(),'baojie','保洁','df8f9f0b0b86b58735d596775220c609','123456789123456789','保洁','cleaner');
INSERT INTO `user` (`create_by`,`create_time`,`user_name`,`user_display_name`,`user_pass`,`id_card`,`user_desc`,`role`)
    VALUES('12345678910',NOW(),'1234567891','顾客','df8f9f0b0b86b58735d596775220c609','123456789123456789','顾客','customer');

#category

INSERT INTO `category` (`create_by`,`create_time`,`cate_name`,`cate_sort`)
    VALUES('12345678910',NOW(),'行政房',1);
INSERT INTO `category` (`create_by`,`create_time`,`cate_name`,`cate_sort`)
    VALUES('12345678910',NOW(),'套房',2);
INSERT INTO `category` (`create_by`,`create_time`,`cate_name`,`cate_sort`)
    VALUES('12345678910',NOW(),'三人间',2);
INSERT INTO `category` (`create_by`,`create_time`,`cate_name`,`cate_sort`)
    VALUES('12345678910',NOW(),'标间',2);
INSERT INTO `category` (`create_by`,`create_time`,`cate_name`,`cate_sort`)
    VALUES('12345678910',NOW(),'大床房',2);
INSERT INTO `category` (`create_by`,`create_time`,`cate_name`,`cate_sort`)
    VALUES('12345678910',NOW(),'单间',2);
INSERT INTO `category` (`create_by`,`create_time`,`cate_name`,`cate_sort`)
    VALUES('12345678910',NOW(),'电竞房',3);

#post

INSERT INTO `post` (`create_by`,`create_time`,`post_title`,`post_content`,`post_summary`,`post_thumbnail`,`price`,`number`,`cate_id`,`post_editor`)
    VALUES('12345678910',NOW(),'总统套房','全新升级的豪华套房面积近百平方米，位于1号楼7至17层，满足您更高品质居住需求。房间包含一室一厅两卫及多个更衣间，移门分隔的客厅和卧室可平衡社交与私密需求。宽敞的客厅拥有舒适的沙发区，独立的餐桌、冰箱、微波炉、Nespresso咖啡机、写字台、储物柜，65寸高清可旋转LCD电视，贴心满足长期居住或小型社交活动需求。卧室配备超大舒适床品、无线及USB充电装置，带暗格收纳的梳妆镜台。您也可尊享行政楼层礼遇，在充满摩登老上海风情的行政酒廊尽享早餐、下午茶、欢乐时光及会议室。','全新升级的豪华套房面积近百平方米，位于1号楼7至17层，满足您更高品质居住需求。房间包含一室一厅两卫及多个更衣间，移门','/front/images/room-list/list3.jpg',900,'N220',2,'<p><br></p><p><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"></p>');

INSERT INTO `post` (`create_by`,`create_time`,`post_title`,`post_content`,`post_summary`,`post_thumbnail`,`price`,`number`,`cate_id`,`post_editor`)
    VALUES('12345678910',NOW(),'意式标准间','全新升级的豪华套房面积近百平方米，位于1号楼7至17层，满足您更高品质居住需求。房间包含一室一厅两卫及多个更衣间，移门分隔的客厅和卧室可平衡社交与私密需求。宽敞的客厅拥有舒适的沙发区，独立的餐桌、冰箱、微波炉、Nespresso咖啡机、写字台、储物柜，65寸高清可旋转LCD电视，贴心满足长期居住或小型社交活动需求。卧室配备超大舒适床品、无线及USB充电装置，带暗格收纳的梳妆镜台。您也可尊享行政楼层礼遇，在充满摩登老上海风情的行政酒廊尽享早餐、下午茶、欢乐时光及会议室。','便利设施：空调，电视，电子磁卡门锁，手动窗帘，床具 浴室：吹风机，电热水器，室内卫生间，24小时热水...','/front/images/room-list/list2.jpg',300,'N202',4,'<p><br></p><p><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"><img+src="/front/images/room-list/grid1.jpg"+style="width:+100px;"+class="fr-fic+fr-dib"></p>');
#