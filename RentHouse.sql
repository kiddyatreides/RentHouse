create database RentHouse
use RentHouse

create table customer (
id_customer varchar(4) PRIMARY KEY,
nama varchar(100),
birthdate date,
address text,
phonenumber varchar(20),
card_type varchar(100),
card_number varchar(100));
select * from customer
drop table customer;

create table admin (
id_admin varchar(4) PRIMARY KEY,
nama varchar(100),
username varchar(100),
password varchar(50),
address text,
phonenumber varchar(20),
admin_type varchar(100));
drop table admin
insert into admin values ('A001','Hudya','admin','123456','Jakarta','0822222','SuperAdmin')


create table room(
id_room varchar(5) PRIMARY KEY,
id_room_type varchar(5),
name varchar(100),
price bigint,
status varchar(100));

insert into room (id_room,id_room_type,name,price) values ('R001','T001','001','500000');
select * from room
drop table room;
ALTER TABLE room ADD CONSTRAINT DF_tbpostgrup2 DEFAULT 'Available' FOR status

select * from room;
update room set name = '003', price = 600000, id_room_type = 'T001' where id_room = 'R001'
insert into room (id_room,id_room_type,name,price,status) values ('C001','T001','001','500000','Available');
update room set id_room = 'R001' where name='001';
select A.id_room,A.name,A.id_room_type,A.status,B.id_room_type from room A,room_type B  where A.id_room_type = B.id_room_type AND A.status = 'Available';


ALTER TABLE room
ADD CONSTRAINT fk_RoomType
FOREIGN KEY (id_room_type)
REFERENCES room_type(id_room_type);
alter table room drop constraint fk_roomType

alter table room drop constraint fk_RoomType;


create table room_type(
id_room_type varchar(5) PRIMARY KEY,
name varchar(100));
drop table room_type

select * from room_type;

create table transactionn(
id_transaction varchar(4) PRIMARY KEY,
id_room varchar(5),
id_customer varchar(4),
datein date,
dateout date,
status varchar(100));

ALTER TABLE transactionn ADD CONSTRAINT DF_tbStatus DEFAULT 'Rent In' FOR status
ALTER TABLE transactionn ADD CONSTRAINT DF_datein DEFAULT GETDATE() FOR datein

select * from transactionn
update transactionn set id_customer = 'C002' where id_transaction = 'P001'

select a.id_transaction,b.name as room,c.nama as customer,a.datein,a.dateout,a.status from transactionn a inner join room b on b.id_room = a.id_room inner join customer c on c.id_customer = a.id_customer order by id_transaction asc
select id_customer,nama from customer;

create trigger trg_action on [dbo].[transactionn]
after insert
as
	declare @idroom varchar(5)
	declare @idtransaction varchar(4)
	
	select @idroom = transactionn.id_room from inserted transactionn;
	select @idtransaction = transactionn.id_transaction from inserted transactionn;
	
	update room set status = 'Not Available' where id_room = @idroom
	print 'BERHASIL'
go

	create trigger trg_action2 on [dbo].[transactionn]
	after update
	as
		declare @idroom varchar(5)
		declare @idtransaction varchar(4)
		
		select @idroom = transactionn.id_room from inserted transactionn;
		select @idtransaction = transactionn.id_transaction from inserted transactionn;
		
		update room set status = 'Available' where id_room = @idroom
		--update transactionn set status = 'Rent Out', dateout = GETDATE() where id_transaction = @idtransaction
		print 'BERHASIL'
	go
	use RentHouse
	drop trigger trg_action2
select * from room
select a.id_transaction,a.id_room,a.id_customer,b.name as room,c.nama as customer,a.datein,a.dateout,a.status from transactionn a inner join room b on b.id_room = a.id_room inner join customer c on c.id_customer = a.id_customer where a.status = 'Rent In' order by id_transaction asc

update customer set id_customer = 'C001' where nama='Hudya Ramadhana'

drop table transactionn;
use rentHouse
select SUM(c.price) as total from monthlypaid a inner join transactionn b on b.id_transaction = a.id_transaction inner join room c on c.id_room = b.id_room
ALTER TABLE transactionn drop constraint fk_Room;

create trigger trg_action3 on [dbo].[monthlypaid]
	after insert
	as
		declare @idroom varchar(5)
		declare @idtransaction varchar(4)
		declare @idmonthlypaid varchar(4)
		declare @price int
		
		select @idroom = transactionn.id_room from transactionn;
		select @price = room.price from room inner join transactionn on room.id_room = transactionn.id_room ;
		select @idtransaction = transactionn.id_transaction from transactionn;
		select @idmonthlypaid = monthlypaid.id_transaction from inserted monthlypaid;
		
		update monthlypaid set total = @price where id_transaction = @idtransaction
		--update transactionn set status = 'Rent Out', dateout = GETDATE() where id_transaction = @idtransaction
		print 'BERHASIL'
	go
	drop trigger trg_action3
	insert

ALTER TABLE transactionn
ADD CONSTRAINT fk_Room
FOREIGN KEY (id_room)
REFERENCES room(id_room);
alter table transactionn drop constraint fk_Customer;

ALTER TABLE transactionn
ADD CONSTRAINT fk_Customer
FOREIGN KEY (id_customer)
REFERENCES customer(id_customer);


create table monthlypaid(
id_monthlypaid varchar(4) PRIMARY KEY,
id_transaction varchar(4),
date_time datetime,
total int,
info text);

ALTER TABLE monthlypaid ADD CONSTRAINT DF_datein2 DEFAULT GETDATE() FOR date_time
insert into monthlypaid (id_monthlypaid,id_transaction,info) values ('M001','P004','Pembayaran Bulan April 2017');
select * from monthlypaid
select id_transaction from transactionn where status = 'Rent In'
delete from monthlypaid where id_monthlypaid = 'M001'

alter table monthlypaid drop constraint fk_Trans;
ALTER TABLE monthlypaid
ADD CONSTRAINT fk_Trans
FOREIGN KEY (id_transaction)
REFERENCES transactionn(id_transaction);

select * from customer;

update customer set id_customer = 'C001' where card_type='KTP';
delete from customer where card_type = 'KTP';
insert into customer values('P001','Kiddy','1998-01-01','Jakarta','124342','KTP','123123');
drop table monthlypaid;


ALTER TABLE Orders
ADD CONSTRAINT fk_PerOrders
FOREIGN KEY (P_Id)
REFERENCES Persons(P_Id)