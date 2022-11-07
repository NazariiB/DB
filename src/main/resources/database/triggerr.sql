use labjdbc5;

DROP trigger IF EXISTS after_insert_worker;
DELIMITER //
create trigger after_insert_worker
after INSERT
ON worker FOR EACH ROW
BEGIN
declare is_exist int;
select max(id) into is_exist from work_position where work_position.position=new.position;
if is_exist is null then insert into work_position(id, position) values(default, new.position);
end if;
END //
DELIMITER ;

DROP trigger IF EXISTS after_delete_worker;
DELIMITER //
create trigger after_delete_worker
after delete
ON worker FOR EACH ROW
BEGIN
declare is_exist int;
select max(idworkers) into is_exist from worker where worker.position=old.position;
if is_exist is null then delete from work_position where work_position.position=old.position;
end if;
END //
DELIMITER ;

DROP trigger IF EXISTS after_update_worker;
DELIMITER //
create trigger after_update_worker
after update
ON worker FOR EACH ROW
BEGIN
declare is_exist int;
declare is_exist1 int;
select max(idworkers) into is_exist from worker where worker.position=old.position;
if is_exist is null then delete from work_position where work_position.position=old.position;
end if;
select max(id) into is_exist1 from work_position where work_position.position=new.position;
if is_exist is null then insert into work_position(id, position) values(default, new.position);
end if;
END //
DELIMITER ;



DROP trigger IF EXISTS before_insert_product;
DELIMITER //
create trigger before_insert_product
before INSERT
ON product FOR EACH ROW
BEGIN
declare is_normal int;
select id into is_normal from (select new.mass like '%00' as id) as temp;
-- set is_normal=select 200 like '%00';
if is_normal!=1 then SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error';
end if;
END //
DELIMITER ;



DROP trigger IF EXISTS before_delete_sold_products;
DELIMITER //
create trigger before_delete_sold_products
before delete
ON sold_products FOR EACH ROW
BEGIN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error';
END //
DELIMITER ;


DROP trigger IF EXISTS before_update_sold_products;
DELIMITER //
create trigger before_update_sold_products
before update
ON sold_products FOR EACH ROW
BEGIN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error';
END //
DELIMITER ;
