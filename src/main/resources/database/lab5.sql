drop database if exists `labjdbc5`;

CREATE SCHEMA IF NOT EXISTS `labjdbc5`;
use labjdbc5;

drop table if exists work_position;
create table if not exists work_position (
	id int auto_increment primary key,
    position varchar(100)
);

