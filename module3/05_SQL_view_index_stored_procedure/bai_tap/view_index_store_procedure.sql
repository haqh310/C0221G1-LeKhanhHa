-- Bước 1: Tạo cơ sở dữ liệu demo 
create database if not exists  demo;

-- Bước 2: Tạo bảng Products với các trường dữ liệu sau:
use demo;
create table if not exists products(
	id int auto_increment primary key, 
	product_code varchar(30),
	product_name varchar(30),
	product_price int,
	product_amount int,
	product_description varchar(30),
	product_status varchar(30)
);

insert into products(id, product_code, product_name, product_price, product_amount, product_description, product_status)
values ("a1","tu lanh", 1000, 1200, "tiet kiem dien", "tot"),
		("b1","may giat", 800, 950, "giat nhanh", "co"),
        ("a1","ti vi", 2000, 2200, "sieu mong", "het hang"),
        ("b1","dieu hoa", 1500, 1700, "lam mat", "con");
        
-- Bước 3:
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào         
select * from products;

alter table products
add index uidx_products (product_code) ;

explain select * 
from products 
where product_code ="a1";

alter table products
add index cidx_products (product_name,product_price ) ;

explain select * 
from products 
where product_name ="ti vi" or product_price = 1000;


-- Bước 4:
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
-- Tiến hành sửa đổi view
-- Tiến hành xoá view

create view product_view as
select product_code, product_name, product_price, product_status 
from products;

select * from product_view;

create or replace view product_view as
select product_code, product_name, product_price, product_status 
from products
where product_code ="b1"; 

drop view product_view;


-- Bước 5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
-- Tạo store procedure thêm một sản phẩm mới
-- Tạo store procedure sửa thông tin sản phẩm theo id
-- Tạo store procedure xoá sản phẩm theo id


DELIMITER //
create procedure findAllProducts()
begin
	select * from products;
end;
// DELIMITER ;

call findAllProducts();

DELIMITER //
create procedure addNewProduct
	(IN p_product_code varchar(30),
    p_product_name varchar(30),
	p_product_price int,
	p_product_amount int,
	p_product_description varchar(30),
	p_product_status varchar(30))
begin
	insert into products
    values (p_product_code, p_product_name, p_product_price, p_product_amount, p_product_description, p_product_status);
end;
//DELIMITER ;

call addNewProduct("a1","quat", 300, 350, "mat nhanh", "co");

drop procedure if exists editProduct;
DELIMITER //
create procedure editProduct
	(in p_id int,
    new_product_code varchar(30),
    new_product_name varchar(30),
	new_product_price int,
	new_product_amount int,
	new_product_description varchar(30),
	new_product_status varchar(30))
 begin
	update products
    set product_code = new_product_code, 
		product_name = new_product_name,
        product_price = new_product_price,
        product_amount = new_product_amount,
        product_description = new_product_description,
        product_status = new_product_status
    where id = p_id;
end;
// DELIMITER ;

call editProduct(1,"a2","tu lanh sony",1500,2000,"sieu sale","ok");


DELIMITER //
create procedure removeProduct
	(in id int)
 begin
	delete from products p
    where p.id = id;
end;
// DELIMITER ;

call removeProduct(2);