CREATE TRIGGER after_user_insert  
AFTER INSERT ON user  
FOR EACH ROW  
BEGIN  
    -- 插入user_role_ref表的数据，此处我们默认新用户的角色为'subscriber'（你可以根据需要修改）  
    INSERT INTO user_role_ref (`create_by`,`create_time`,`user_id`, `role_id`)  
    VALUES ('Trigger',NOW(),NEW.id,   
            (SELECT id FROM role WHERE role = NEW.role)  
           );  
END;  