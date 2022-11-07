use labjdbc5;

drop procedure if exists insert_into_team;
DELIMITER //
CREATE PROCEDURE insert_into_team(
IN new_name varchar(255))
BEGIN
insert into team(id, name) value(default, new_name);
END //
DELIMITER ;


drop procedure if exists insert_loaded_snack;
DELIMITER //
CREATE PROCEDURE insert_loaded_snack (
IN vending_machine_id int,
in product_name varchar(255)
) BEGIN
declare prod_id int;
select id into prod_id from product where product.name=product_name;
insert into loaded_snack(id, quantity, product_id, reloading_snack_machines_id) value(default, 10, prod_id, vending_machine_id);
END //
DELIMITER ;


drop procedure if exists insert_team_10_rows;
DELIMITER //
CREATE PROCEDURE insert_team_10_rows ( ) BEGIN
declare counter int;
set counter=0;
loop1: loop
	if counter > 9 then leave loop1;
    end if;
    insert into team(id, name) value(default, concat('no_name', LAST_INSERT_ID()));
    set counter=counter + 1;
END LOOP;
END //
DELIMITER ;


drop procedure if exists select_sum_money;
DELIMITER //
CREATE PROCEDURE select_sum_money () BEGIN
select sum(amount_to_earn) as amount_to_earn from money;
END //
DELIMITER ;


SET @temp_query = '';
drop procedure if exists proc_cursor;
DELIMITER //
CREATE PROCEDURE proc_cursor()
BEGIN
declare amount int;

DECLARE done int DEFAULT false;
DECLARE product_name varchar(100);

DECLARE St_Cursor10 CURSOR
FOR SELECT name FROM product;

DECLARE CONTINUE HANDLER
FOR NOT FOUND SET done = true;

OPEN St_Cursor10;
myLoop: LOOP
	FETCH St_Cursor10 INTO product_name;
	IF done=true THEN LEAVE myLoop;
	END IF;
    set amount=FLOOR(RAND()*(9-1+1)+1) + 1;
	SET @temp_query=concat('create table ', product_name, CURRENT_TIMESTAMP() + 1, ' (');
    myLoop1: LOOP
		if amount<0 then LEAVE myLoop1;
		end if;
		set @temp_query=concat(@temp_query, ' colum', amount,' int ');
        if amount!=0 then set @temp_query=concat(@temp_query,',');
        end if;
		set amount=amount - 1;
	END LOOP myLoop1;
	SET @temp_query=CONCAT(@temp_query, ' )');
	PREPARE myquery FROM @temp_query;
	EXECUTE myquery;
	DEALLOCATE PREPARE myquery;
END LOOP myLoop;
CLOSE St_Cursor10;
END //
DELIMITER ;
