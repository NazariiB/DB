USE `laba1`;

-- insert vending machine models
select * from vending_machine_model;
insert into vending_machine_model (model) values ('samsung'), ('bosch'), ('javascript'),
('nokia'),('noki'),('apple'),
('spirit'), ('intenational'), ('sport');

-- insert product companies
select * from companie;
insert into companie(companie_name) values ('lays'), ('princl'), ('m&m'),
('doritos'), ('papaya'), ('sokovinka'),
('cola'), ('sprite'), ('fanta');

-- insert info of the workers
select * from  info;
insert into info (id, position, sallery) values (default, 'loader', 1000 ), 
(default, 'driver', 1100),(default, 'manager', 1600),
(default, 'cleaner', 1100), (default, 'weak_lader', 900),
(default, 'strong_loader', 1100), (default, 'secretary', 1600),
(default, 'bookkeeper', 1600), (default, 'boss', 16000), 
(default, 'director', 1600);

--  insert team 
select * from team;
insert into team(id, name) values( default, 'east'),
(default, 'west'),(default, 'north'),
(default, 'south'), (default, 'first'),
(default, 'second'), (default, 'forth'),
(default, 'west2'), (default, 'fifth'),
(default, 'ten');

-- insert workers 
select * from worker;
insert into worker (idworkers, name, surname, phone_number, info_id, team_id) values
(default, 'ivan', 'popovich', '+380989898989', 1, 1),
(default, 'popy', 'popovich', '+380989898989', 1, 2),
(default, 'roma', 'popovich', '+380989898989', 1, 1),
(default, 'mukola', 'ivanovich', '+380989898989', 1, 2),
(default, 'pavlo', 'muk', '+380989898989', 1, 1),
(default, 'marko', 'yorko', '+380989898989', 1, 2),
(default, 'bobus', 'popovich', '+380989898989', 3, 1),
(default, 'fofa', 'popovich', '+380989898989', 3, 2),
(default, 'person', 'popovich', '+380989898989', 2, 1),
(default, 'andrii', 'popovich', '+380989898989', 2, 2);

-- insert wending machine
select * from vending_machine;
insert into vending_machine (id, vendingMachine_vending_machine_model, max_amount_of_snacks, gps_cordinates, amount_of_snacks) values
(default, 'bosch', 120, '130 55 70', 90),
(default, 'apple', 120, '130 55 70', 95),
(default, 'samsung', 120, '1 55 20', 80),
(default, 'bosch', 120, '130 55 70', 95),
(default, 'apple', 120, '1 55 20', 80),
(default, 'bosch', 120, '130 55 70', 95),
(default, 'samsung', 120, '1 55 20', 80),
(default, 'nokia', 120, '130 55 70', 95),
(default, 'bosch', 120, '13 1 73', 95),
(default, 'nokia', 120, '130 55 70', 95);

--  insert products
select * from product;
insert into product (id, name, price, mass, companie_name) values
(default, 'hoot', 5.50, 200, 'doritos'),
(default, 'spacy', 10.50, 300, 'lays'),
(default, 'cool', 15.50, 200, 'princl'),
(default, 'hola', 5.50, 500, 'doritos'),
(default, 'chocolad', 9.50, 200, 'm&m'),
(default, 'hoot cool', 5.50, 200, 'doritos'),
(default, 'chiill', 10.50, 300, 'lays'),
(default, 'coolCOOOOl', 15.50, 200, 'princl'),
(default, 'holahola', 5.50, 500, 'doritos'),
(default, 'chocoladWhite', 9.50, 200, 'm&m'),
(default, 'hot cafe', 5.50, 200, 'm&m');

-- insert content of the machine
select * from content_of_the_machine;
insert into content_of_the_machine(vendingMachine_id, product_id, quantity) values 
(1, 1, 12), ( 1, 2, 4), (2, 4, 20), ( 2, 5, 30),
(3, 3, 33), (3, 1, 12), (4, 4, 14), ( 4, 7, 22),
(5, 5, 55), (5, 4, 33);

-- insert sold products 
select * from sold_products;
insert into sold_products (vendingMachine_id, product_id, quantity, time_of_purchase) values 
(1, 1, 12, '22_02_2022 17:35:45'), ( 1, 2, 4, '22_02_2022 17:35:45'), (2, 4, 20, '22_02_2022 17:35:45'), 
( 2, 5, 30, '22_02_2022 17:35:45'),(3, 3, 33, '22_02_2022 17:35:45'), (3, 1, 12, '22_02_2022 17:35:45'),
(4, 4, 14, '22_02_2022 17:35:45'), ( 4, 7, 22, '22_02_2022 17:35:45'),
(5, 5, 55, '22_02_2022 17:35:45'), (5, 4, 33, '22_02_2022 17:35:45');

-- insert money 
select * from money;
insert into money(id, date, amount_to_earn, amount_to_put, vendingMachine_id, team_id) values 
(default, '22_02_2022 17:35:45', 1000, 1200, 1, 1), (default, '22_02_2022 17:35:45', 1000, 1200, 2, 2),
(default, '22_02_2022 17:35:45', 1000, 1200, 1, 2), (default, '22_02_2022 17:35:45', 1100, 1200, 4, 1),
(default, '22_02_2022 17:35:45', 1000, 1200, 1, 5), (default, '22_02_2022 17:35:45', 100, 1200, 2, 3),
(default, '22_02_2022 17:35:45', 1000, 1200, 5, 2), (default, '22_02_2022 17:35:45', 100, 1200, 3, 6),
(default, '22_02_2022 17:35:45', 1000, 1200, 1, 1), (default, '22_02_2022 17:35:45', 1000, 1200, 2, 7);

-- insert reloading_snacks_machine
select * from reloading_snacks_machine;
insert into reloading_snacks_machine(id, time_reloading, vendingMachine_id, team_id) values 
(default, '22_02_2022 17:35:45', 1, 3), (default, '22_02_2022 17:35:45', 2, 3), (default, '22_02_2022 17:35:45', 3, 2),
(default, '22_02_2022 17:35:45', 2, 3), (default, '22_02_2022 17:35:45', 7, 2), (default, '22_02_2022 17:35:45', 1, 6),
(default, '22_02_2022 17:35:45', 4, 3), (default, '22_02_2022 17:35:45', 6, 3), (default, '22_02_2022 17:35:45', 3, 3),
(default, '22_02_2022 17:35:45', 5, 6);

-- insert loaded_snacks
select * from loaded_snack;
insert into loaded_snack (reloading_snack_machines_id, product_id, quantity) values 
(1, 1, 12), ( 1, 2, 4), (2, 4, 20), ( 2, 5, 30),
(3, 3, 33), (3, 1, 12), (4, 4, 14), ( 4, 7, 22),
(5, 5, 55), (5, 4, 33);


-- solded products of vending Machine with id=1
select name, price from sold_products join product on product.id=sold_products.product_id where vendingMachine_id = 1;

-- content of vending Machine with id=1
select name, price, quantity from content_of_the_machine join product on product.id=content_of_the_machine.product_id where vendingMachine_id = 1;
 
-- a sum of sold product of vending Machine with id=1
select amount_to_earn, sum(quantity) sum from money join sold_products on sold_products.vendingMachine_id=1 where money.vendingMachine_id=1;

-- reloaded vending machine
select name, price, quantity from loaded_snack join product on product.id=loaded_snack.product_id where reloading_snack_machines_id = 1;

-- all workers that reload machines
select distinct
	name, surname, reloading_snacks_machine.team_id
from 
	reloading_snacks_machine 
join 
	(select 
		worker.name, surname, team_id 
	from 
		team 
    join 
		worker on team_id=id) as t;
        
-- machines that need to reload
select id from vending_machine where amount_of_snacks < 90;

-- money that bring all machines
select sum(amount_to_earn) from money;

-- the most expensive product
select name, max(price) as price from product;

-- the list of sold product;
select name, quantity from sold_products join product on product_id=product.id;

-- the list of unpopular products
select product_id from content_of_the_machine where product_id != all (select product_id from sold_products);
