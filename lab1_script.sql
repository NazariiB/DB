drop database if exists `laba1`;

CREATE SCHEMA IF NOT EXISTS `laba1` DEFAULT CHARACTER SET utf8 ;
USE `laba1` ;

DROP TABLE IF EXISTS `vending_machine_model` ;

CREATE TABLE IF NOT EXISTS `vending_machine_model` (
  `model` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`model`))
ENGINE = InnoDB;


DROP TABLE IF EXISTS `vending_machine` ;

CREATE TABLE IF NOT EXISTS `vending_machine` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `vending_machine_model` VARCHAR(45) NOT NULL,
  `max_amount_of_snacks` INT UNSIGNED NOT NULL,
  `gps_cordinates` VARCHAR(45) NOT NULL,
  `amount_of_snacks` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

CREATE INDEX idx_model ON vending_machine(vending_machine_model);
CREATE INDEX idx_gps ON vending_machine(gps_cordinates);

ALTER TABLE vending_machine
ADD FOREIGN KEY (`vending_machine_model`)
    REFERENCES `vending_machine_model` (`model`)
    ON DELETE CASCADE
    ON UPDATE CASCADE;



DROP TABLE IF EXISTS `companie` ;

CREATE TABLE IF NOT EXISTS `companie` (
  `companie_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`companie_name`))
ENGINE = InnoDB;


DROP TABLE IF EXISTS `product` ;

CREATE TABLE IF NOT EXISTS `product` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(6,2) UNSIGNED NOT NULL,
  `mass` INT UNSIGNED NOT NULL,
  `companie_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `companie_name`)
  ) ENGINE = InnoDB;

ALTER TABLE product
ADD FOREIGN KEY (`companie_name`)
    REFERENCES `laba1`.`companie` (`companie_name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

CREATE INDEX idx_name ON product(name);
CREATE INDEX idx_price ON product(price);

DROP TABLE IF EXISTS `content_of_the_machine` ;

CREATE TABLE IF NOT EXISTS `content_of_the_machine` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `vendingMachine_id` INT UNSIGNED NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  `quantity` INT UNSIGNED NULL,
  PRIMARY KEY (`id`, `vendingMachine_id`, `product_id`))
ENGINE = InnoDB;

ALTER TABLE content_of_the_machine
ADD FOREIGN KEY (`vendingMachine_id`)
    REFERENCES `laba1`.`vending_machine` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE;
    
ALTER TABLE content_of_the_machine
ADD FOREIGN KEY (`product_id`)
    REFERENCES `laba1`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


DROP TABLE IF EXISTS `sold_products` ;

CREATE TABLE IF NOT EXISTS `sold_products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `vendingMachine_id` INT UNSIGNED NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  `quantity` INT UNSIGNED NOT NULL,
  `time_of_purchase` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `vendingMachine_id`, `product_id`))
ENGINE = InnoDB;

ALTER TABLE sold_products
ADD FOREIGN KEY (`vendingMachine_id`)
    REFERENCES `laba1`.`vending_machine` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
ADD FOREIGN KEY (`product_id`)
    REFERENCES `laba1`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

create index idx_wm_id on sold_products(vendingMachine_id);
create index idx_p_id on sold_products(product_id);

DROP TABLE IF EXISTS `info` ;

CREATE TABLE IF NOT EXISTS `info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `position` VARCHAR(45) NULL,
  `sallery` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



DROP TABLE IF EXISTS `team` ;

CREATE TABLE IF NOT EXISTS `team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



DROP TABLE IF EXISTS `worker` ;

CREATE TABLE IF NOT EXISTS `worker` (
  `idworkers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `phone_number` VARCHAR(45) NULL,
  `info_id` INT NOT NULL,
  `team_id` INT NOT NULL,
  PRIMARY KEY (`idworkers`, `info_id`, `team_id`))
ENGINE = InnoDB;

ALTER TABLE worker
ADD FOREIGN KEY (`info_id`)
    REFERENCES `laba1`.`info` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
ADD FOREIGN KEY (`team_id`)
    REFERENCES `laba1`.`team` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


DROP TABLE IF EXISTS `reloading_snacks_machine` ;

CREATE TABLE IF NOT EXISTS `reloading_snacks_machine` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `time_reloading` VARCHAR(45) NOT NULL,
  `vendingMachine_id` INT UNSIGNED NOT NULL,
  `team_id` INT NOT NULL,
  PRIMARY KEY (`id`, `vendingMachine_id`, `team_id`))
ENGINE = InnoDB;

ALTER TABLE reloading_snacks_machine
ADD FOREIGN KEY (`vendingMachine_id`)
    REFERENCES `laba1`.`vending_machine` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
ADD FOREIGN KEY (`team_id`)
    REFERENCES `laba1`.`team` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


DROP TABLE IF EXISTS `loaded_snack` ;

CREATE TABLE IF NOT EXISTS `loaded_snack` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `reloading_snack_machines_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`id`, `reloading_snack_machines_id`, `product_id`))
ENGINE = InnoDB;


DROP TABLE IF EXISTS `money` ;

CREATE TABLE IF NOT EXISTS `money` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(45) NOT NULL,
  `amount_to_earn` DECIMAL UNSIGNED NOT NULL,
  `amount_to_put` DECIMAL NULL,
  `vendingMachine_id` INT UNSIGNED NOT NULL,
  `team_id` INT NOT NULL,
  PRIMARY KEY (`id`, `vendingMachine_id`, `team_id`))
ENGINE = InnoDB;

ALTER TABLE money
ADD FOREIGN KEY (`vendingMachine_id`)
    REFERENCES `laba1`.`vending_machine` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
ADD FOREIGN KEY (`team_id`)
    REFERENCES `laba1`.`team` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

CREATE INDEX idx_data ON money(date);
CREATE INDEX idx_earn ON money(amount_to_earn);

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

