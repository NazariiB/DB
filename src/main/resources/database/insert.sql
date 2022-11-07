USE `labjdbc5`;

select * from product;
insert into product (id, name, price, mass) values
(default, 'hoot', 5.50, 200),
(default, 'spacy', 10.50, 300),
(default, 'cool', 15.50, 200),
(default, 'hola', 5.50, 500),
(default, 'chocolad', 9.50, 200),
(default, 'hoot_cool', 5.50, 200),
(default, 'chiill', 10.50, 300),
(default, 'coolCOOOOl', 15.50, 200),
(default, 'holahola', 5.50, 500),
(default, 'chocoladWhite', 9.50, 200),
(default, 'hot_cafe', 5.50, 200);

select * from vending_machine;
insert into vending_machine (id, vending_machine_model, max_amount_of_snacks, gps_cordinates, amount_of_snacks) values
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

select * from team;
insert into team(id, name) values( default, 'east'),
(default, 'west'),(default, 'north'),
(default, 'south'), (default, 'first'),
(default, 'second'), (default, 'forth'),
(default, 'west2'), (default, 'fifth'),
(default, 'ten');

select * from worker;
insert into worker (idworkers, name, surname, phone_number, team_id, position, sallery) values
(default, 'ivan', 'popovich', '+380989898989', 1, 'driver', 1100),
(default, 'popy', 'popovich', '+380989898989', 2, 'driver', 1100),
(default, 'roma', 'popovich', '+380989898989', 1, 'boss', 16000),
(default, 'mukola', 'ivanovich', '+380989898989', 2, 'strong_loader', 1100),
(default, 'pavlo', 'muk', '+380989898989', 1, 'strong_loader', 1100),
(default, 'marko', 'yorko', '+380989898989', 2, 'strong_loader', 1100),
(default, 'bobus', 'popovich', '+380989898989', 1, 'strong_loader', 1100),
(default, 'fofa', 'popovich', '+380989898989', 2, 'manager', 1600),
(default, 'person', 'popovich', '+380989898989', 1, 'cleaner', 1100),
(default, 'andrii', 'popovich', '+380989898989', 2, 'strong_loader', 1100);


select * from reloading_snacks_machine;
insert into reloading_snacks_machine(id, time_reloading, vending_machine_id, team_id) values 
(default, '22_02_2022 17:35:45', 1, 3), (default, '22_02_2022 17:35:45', 2, 3), (default, '22_02_2022 17:35:45', 3, 2),
(default, '22_02_2022 17:35:45', 2, 3), (default, '22_02_2022 17:35:45', 7, 2), (default, '22_02_2022 17:35:45', 1, 6),
(default, '22_02_2022 17:35:45', 4, 3), (default, '22_02_2022 17:35:45', 6, 3), (default, '22_02_2022 17:35:45', 3, 3),
(default, '22_02_2022 17:35:45', 5, 6);

select * from money;
insert into money(id, date, amount_to_earn, amount_to_put, vending_machine_id, team_id) values 
(default, '22_02_2022 17:35:45', 1000, 1200, 1, 1), (default, '22_02_2022 17:35:45', 1000, 1200, 2, 2),
(default, '22_02_2022 17:35:45', 1000, 1200, 1, 2), (default, '22_02_2022 17:35:45', 1100, 1200, 4, 1),
(default, '22_02_2022 17:35:45', 1000, 1200, 1, 5), (default, '22_02_2022 17:35:45', 100, 1200, 2, 3),
(default, '22_02_2022 17:35:45', 1000, 1200, 5, 2), (default, '22_02_2022 17:35:45', 100, 1200, 3, 6),
(default, '22_02_2022 17:35:45', 1000, 1200, 1, 1), (default, '22_02_2022 17:35:45', 1000, 1200, 2, 7);

select * from loaded_snack;
insert into loaded_snack (reloading_snack_machines_id, product_id, quantity) values 
(1, 1, 12), ( 1, 2, 4), (2, 4, 20), ( 2, 5, 30),
(3, 3, 33), (3, 1, 12), (4, 4, 14), ( 4, 7, 22),
(5, 5, 55), (5, 4, 33);

select * from content_of_the_machine;
insert into content_of_the_machine(vending_machine_id, product_id, quantity) values 
(1, 1, 12), ( 1, 2, 4), (2, 4, 20), ( 2, 5, 30),
(3, 3, 33), (3, 1, 12), (4, 4, 14), ( 4, 7, 22),
(5, 5, 55), (5, 4, 33);

select * from sold_products;
insert into sold_products (vending_machine_id, product_id, quantity, time_of_purchase) values 
(1, 1, 12, '22_02_2022 17:35:45'), ( 1, 2, 4, '22_02_2022 17:35:45'), (2, 4, 20, '22_02_2022 17:35:45'), 
( 2, 5, 30, '22_02_2022 17:35:45'),(3, 3, 33, '22_02_2022 17:35:45'), (3, 1, 12, '22_02_2022 17:35:45'),
(4, 4, 14, '22_02_2022 17:35:45'), ( 4, 7, 22, '22_02_2022 17:35:45'),
(5, 5, 55, '22_02_2022 17:35:45'), (5, 4, 33, '22_02_2022 17:35:45');
