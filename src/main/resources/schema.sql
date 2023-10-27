create table customers (
id int,
name varchar (255),
surname varchar (255),
age int,
phone_number varchar (255),
primary key (id));

create table orders (
id int,
date varchar (255),
customer_id int,
product_name varchar (255),
amount int,
primary key (id),
foreign key (customer_id) references customers (id));