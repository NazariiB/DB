use Labor_SQL;

-- Вивести назви класів кораблів із водотоннажністю не меншою, аніж 40 тонн. Вивести: class, displacement. Вихідні дані
-- впорядкувати за зростанням за стовпцем type.
select class, displacement from Classes where displacement > 40000 order by type ASC;

-- З таблиці Trip вивести інформацію про рейси, що
-- прилітають в інтервалі часу між 17 та 23 годинами включно.
select * from Trip where Hour(time_in) between 17 and 23;



-- Для рейсових літаків 'Boeing' вказати назви компаній, яким вони належать.
select distinct Company.name from Trip join Company on Trip.ID_comp=Company.ID_comp where plane='Boeing';



-- Знайдіть виробників, що випускають ПК, але не
-- ноутбуки (використати ключове слово SOME). Вивести maker.
select distinct maker from Product where type='PC' and Product.maker != all (select distinct maker from Product where type='Laptop');



-- Знайдіть виробників, які б випускали ПК зі
-- швидкістю 750 МГц та вище. Виведіть: maker.
 select distinct maker from Product inner join PC on Product.model=PC.model where speed >= 750;
 
 
 
-- З таблиці Battles виведіть дати в такому форматі:
-- рік.число_місяця.день, наприклад, 2001-02-21 (без формату часу).
 select Date(date) from Battles;
 
-- Знайдіть середній розмір жорсткого диску ПК
-- (одне значення на всіх) тих виробників, які також випускають і
-- принтери. Вивести: середній розмір жорсткого диску.
select 
	AVG(ram) 
from Product 
	inner join PC 
	on Product.model=PC.model
where type='PC' 
	and Product.maker = some 
	(select distinct maker from Product where type='Printer');

-- Для кожного значення швидкості ПК, що
-- перевищує 600 МГц, визначіть середню ціну ПК із такою ж
-- швидкістю. Вивести: speed, середня ціна. (Підказка: використовувати
-- підзапити в якості обчислювальних стовпців)
select distinct speed pc_speed, (select avg(price) from PC where PC.speed=pc_speed) price from PC where speed>=600;




-- Визначити назви всіх кораблів із таблиці Ships, які
-- задовольняють, у крайньому випадку, комбінації будь-яких чотирьох
-- критеріїв із наступного списку: numGuns=12, bore=16,
-- displacement=46000, type='bc', country='Gt.Britain', launched=1941,
-- class='North Carolina'. Вивести: name, numGuns, bore, displacement,
-- type, country, launched, class. (Підказка: використати для перевірки
-- умов оператор CASE)
select 
	name, numGuns, bore, displacement, type, country, launched, class 
from 
	(select 
		name, 
		numGuns, 
		bore, 
		displacement, 
		type, 
		country, 
		launched, 
		Ships.class, 
		if(numGuns=12, 1, 0) as it1, 
		if(bore=16, 1, 0) as it2, 
		if(displacement=46000, 1, 0) as it3,
		if(type='bc', 1, 0) as it4, 
		if(country='Gt.Britain', 1, 0) it5, 
		if(launched=1941, 1, 0) as it6, 
		if(Classes.class='North Carolina', 1, 0) as it7
	from 
		Ships left join Classes on Ships.class=Classes.class) as i 
where 
	it1 + it2 + it3 + it4 + it5 + it6 + it7 >= 4;
    
    
    

-- Перерахуйте назви головних кораблів, що є наявними 
-- в БД (врахувати також і кораблі з таблиці Outcomes). Вивести:
-- назва корабля, class. (Підказка: використовувати оператор UNION та
-- операцію EXISTS)
select name, class from Ships;