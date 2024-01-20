create database financeSystem;
use financeSystem;

CREATE TABLE accountUser (
    id int primary key not null auto_increment,
    nameUser varchar(50) not null,
    cpf varchar(11) unique key not null,
    email varchar(50) not null,
    passwords varchar(50) not null
);
CREATE TABLE bank (
    id int primary key not null auto_increment,
    nameBank varchar(50) not null
);

CREATE TABLE bankAccount (
    id int primary key not null auto_increment,
    passwords varchar(50) not null,
    balance float not null,
    userId int not null,
    bankId int not null,
    foreign key (userId) references accountUser(id),
    foreign key (bankId) references bank(id)
);

CREATE TABLE transactions (
    id int primary key not null auto_increment,
    valueTransaction float not null,
    dateTransaction timestamp not null,
    startAccountId int not null,
    finalAccountId int not null,
    foreign key (startAccountId) references bankAccount(id),
    foreign key (finalAccountId) references bankAccount(id)
);

insert into accountUser values(null,'lucas',123,"joao@gmail","1234");
insert into accountUser values(null,'fernanda',10987654321,"maria@gmail","4321");
insert into bank values (null, "Nubank");
insert into bank values (null, "Itau");
insert into bankAccount values(null,"1234",1.00,1,1);
insert into bankAccount values(null,"123",999.50,1,2);
insert into bankAccount values(null,"321",50.00,2,1);
insert into transactions values(null,55.00,NOW(),1,2);


select * from bankAccount where userId=1;
select * from transactions where startAccountId=1;

drop database financeSystem;