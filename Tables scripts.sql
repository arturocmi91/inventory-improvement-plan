/*create schema spare_car;
use spare_car;*/
create table model_car(
model_car_id bigint not null auto_increment,
model_brand varchar(255),
model_name varchar(255),
model_year int,
model_type varchar(255),
primary key(item_id)
);

create table customer(
customer_id varchar(255),
customer_name varchar(255),
customer_type enum('Al mayor','Detal'),
address varchar(255),
primary key(customer_id)
);
create table suppliers(
supplier_id varchar(255),
supplier_name varchar(255),
join_date datetime,
primary key(supplier_id)
);
create table item_info (
item_id bigint not null auto_increment ,
ref varchar(255),
barcode bigint,
spare_name varchar(255),
category enum('Alternador','Armotiguador','Bomba','Motor','Frenos')not null,
model_car_id bigint,
primary key(item_id),
foreign key(model_car_id) references model_car(model_car_id)

);







