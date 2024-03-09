/*create schema spare_car;
use spare_car;*/
create table model_car(
model_car_id bigint not null auto_increment,
model_brand varchar(255),
model_name varchar(255),
model_year int,
model_type enum('Pick Up','Sedan','SUV'),
primary key(model_car_id)
);

create table customer(
customer_id varchar(255),
customer_name varchar(255),
customer_type enum('Al mayor','Detal'),
address varchar(255),
email varchar(255),
join_date datetime,
primary key(customer_id)
);
create table supplier(
supplier_id varchar(255),
supplier_name varchar(255),
email varchar(255),
join_date datetime,
primary key(supplier_id)
);
create table item_info (
item_id bigint not null auto_increment ,
ref varchar(255),
barcode bigint,
spare_name varchar(255),
category varchar(255),
model_car_id bigint,
quality enum('Original','Generico'),
quantity_set int,
primary key(item_id),
foreign key(model_car_id) references model_car(model_car_id)
);

insert into model_car (model_brand ,model_name,model_year ,model_type) values
('Changan','Pick Up DB 4x4 F70',2023,'Pick Up'),
('Changan','Pick Up DB 4x2 F70',2023,'Pick Up'),
('Changan','Benni',2023,'Sedan'),
('Changan','Alsvin',2012,'Sedan'),
('Chery','Tiuna  X5 Automatica',2015,'SUV'),
('Chery','Gran Tiggo Ls Automatica',2018,'Sedan'),
('Chery','Arrizo 8 ',2023,'Sedan'),
('Chery','Arrizo 8 ',2023,'SUV'),
('Jetour','Dashing SUV',2023,'SUV'),
('Jetour','Dashing SUV',2024,'SUV');

insert into customer (customer_id ,customer_name ,customer_type ,address ,email ,join_date) values

('CUS1', 'Propio', 'Al mayor', 'Morita I Calle Princiap 30', 'Propio@empresa.com', '2020-03-01 07:48:01'),
('CUS2', 'Sanchez Motors', 'Al mayor', 'Av Bolivar 13', 'Sanchez Motors@empresa.com', '2020-02-10 08:48:02'),
('CUS3', 'Roberto Perez', 'Detal', 'Av Sucre 15 2 3', 'Roberto Perez@empresa.com', '2022-02-19 08:48:03'),
('CUS4', 'Luis Lopez', 'Detal', 'Av las Delicias 112 22 2', 'Luis Lopez@empresa.com', '2022-02-10 08:48:04'),
('CUS5', 'China Motors', 'Al mayor', 'Av Bolivar 122', 'China Motors@empresa.com', '2022-02-16 08:48:05'),
('CUS6', 'Sonia Diaz', 'Al mayor', 'Calle Paez 111', 'Sonia Diaz@empresa.com', '2021-10-09 08:48:06'),
('CUS7', 'Pekin Motors', 'Al mayor', 'Calle Paez 118', 'Pekin Motors@empresa.com', '2020-03-14 08:48:07'),
('CUS8', 'AutoPeriquitos HongKong', 'Al mayor', 'Av Bolivar 12', 'AutoPeriquitos HongKong@empresa.com', '2023-02-16 08:48:08');

insert into supplier (supplier_id ,supplier_name ,email ,join_date) values

('OG1', 'Chan Yun co', 'ChanYunco@empresa.com', '2023-02-10 08:48:15'),
('OG2', 'Chery co', 'Cheryco@empresa.com', '2020-02-11 08:48:30'),
('OG3', 'Jetour Int', 'JetourInt@empresa.com', '2022-02-18 08:48:45'),
('OG4', 'Xi Jang', 'XiJang@empresa.com', '2022-02-05 08:48:10'),
('GC5', 'Xu Jun', 'XuJun@empresa.com', '2022-02-20 08:48:25'),
('GC6', 'Xi Jang', 'XiJang@empresa.com', '2021-10-09 08:48:40'),
('GC7', 'Za Mu', 'ZaMu@empresa.com', '2020-03-12 08:48:55'),
('OG8', 'Kia co', 'Kiaco@empresa.com', '2020-03-01 07:48:20');
INSERT INTO item_info (ref, barcode, spare_name, category, model_car_id, quality, quantity_item, quantity_set, wholesale_price, retail_price, item_status) VALUES
 
('ALO12', 10020145, 'Alternador 12 V 70 A Polea/Canal', 'Alternador', 8, 'Original', 1, 1, 100.00, 150.00, 'Disponible'),
('XLO01', 10020145, 'Alternador 12 V 70 A Polea/Canal', 'Alternador', 8, 'Generico', 1, 1, 90.00, 130.00, 'Disponible'),
('ALO02', 10020148, 'Alternador 12 V 70 A Polea/Canal', 'Alternador', 2, 'Original', 1, 1, 110.00, 160.00, 'Disponible'),
('ALG03', 10024808, 'Alternador 12 V 70 A Polea/SN/Canal', 'Alternador', 1, 'Generico', 1, 1, 95.00, 140.00, 'Disponible'),
('ALO04', 10037078, 'Alternador 12 V 70 A Polea/SN/Canal', 'Alternador', 2, 'Original', 1, 1, 105.00, 155.00, 'Disponible'),
('AMG01', 10037078, 'Amortiguador Completo Delantero LH', 'Armotiguador', 1, 'Original', 1, 1, 80.00, 120.00, 'Disponible'),
('AMG02', 10044435, 'Amortiguador Completo Delantero RH', 'Armotiguador', 2, 'Original', 1, 1, 85.00, 125.00, 'Disponible'),
('AMO03', 10045623, 'Amortiguador Completo Delantero RH', 'Armotiguador', 3, 'Original', 1, 1, 90.00, 130.00, 'Disponible'),
('AMO04', 10053803, 'Amortiguador Completo Delantero RH', 'Armotiguador', 1, 'Generico', 1, 1, 75.00, 110.00, 'Disponible'),
('ATG1115', 10061206, 'Amortiguador Trasero LH/LR', 'Armotiguador', 2, 'Generico', 1, 1, 70.00, 100.00, 'Disponible'),
('ATG1120', 10065628, 'Amortiguador Trasero LH/LR', 'Armotiguador', 3, 'Generico', 1, 1, 75.00, 110.00, 'Disponible'),
('ATG1122', 10066288, 'Amortiguador Trasero LH/LR', 'Armotiguador', 4, 'Generico', 1, 1, 80.00, 120.00, 'Disponible'),
('ATO1121', 10069573, 'Amortiguador Trasero LH/LR', 'Armotiguador', 5, 'Generico', 1, 1, 85.00, 125.00, 'Disponible'),
('BA01', 10078317, 'Bomba de Aceite', 'Bomba', 3, 'Original', 1, 1, 75.00, 110.00, 'Disponible'),
('BA02', 10078317, 'Bomba de Aceite', 'Bomba', 3, 'Generico', 1, 1, 70.00, 100.00, 'Disponible'),
('B01', 10082849, 'Bomba de Agua', 'Bomba', 5, 'Original', 1, 4, 60.00, 90.00, 'Disponible'),
('BY02', 10078317, 'Bomba de Agua', 'Bomba', 7, 'Generico', 1, 1, 55.00, 80.00, 'Disponible'),
('TX03', 10066964, 'Bomba de Agua', 'Bomba', 9, 'Generico', 1, 1, 50.00, 75.00, 'Disponible'),
('BX03', 10078337, 'Bomba de Agua', 'Bomba', 10, 'Generico', 1, 1, 45.00, 70.00, 'Disponible'),
('B02', 10044436, 'Bomba de Freno Con Goma', 'Bomba', 8, 'Original', 1, 1, 40.00, 60.00, 'Disponible'),
('4637', 10020146, 'SET empacadura motor', 'Motor', 6, 'Original', 1, 1, 120.00, 180.00, 'Disponible'),
('5643', 10066289, 'SET empacadura motor', 'Motor', 1, 'Generico', 1, 1, 110.00, 160.00, 'Disponible'),
('34532', 10068975, 'SET empacadura motor', 'Motor', 2, 'Original', 1, 1, 130.00, 190.00, 'Disponible'),
('PM005', 10069573, 'SET Piston motor', 'Motor', 3, 'Original', 1, 1, 140.00, 200.00, 'Disponible'),
('FL989', 10069247, 'Filtro de Aceite', 'Filtro', 6, 'Original', 1, 1, 30.00, 45.00, 'Disponible'),
('GL989', 10069247, 'Filtro de Aceite', 'Filtro', 6, 'Generico', 4, 1, 25.00, 40.00, 'Disponible');


-- Algunos Queries
-- Numero total de Items
select count(ref) as "Numero de articulos" 
from item_info;
-- Codigos repetidos
select  barcode 
from item_info 
group by barcode 
having count(*)>1;
-- Codigos repetidos con item info
select *
from item_info
where barcode in (
select barcode 
from item_info
group by barcode
having count(*)>1
);
/*-- Eliminar un valor duplicado por id
delete from item_info
where item_id=26;
-- Reiniciar tabla 
TRUNCATE item_info;*/

-- Cantidad de item "Genericos"

select count(ref) as "Genericos" 
from item_info
where quality like "%Generico%";

-- Cantidad de item "Originales"

select count(ref) as "Originales"
from item_info
where quality like "%Original%";

-- Item por marca de vehiculos

select i.ref ,i.spare_name, m.model_brand as brand_name
from item_info i
join model_car m on i.model_car_id = m.model_car_id;

-- Item por modelo de Vehiculos
select i.ref, i.spare_name, m.model_name as model
from item_info i
join model_car m on i.model_car_id=m.model_car_id;
