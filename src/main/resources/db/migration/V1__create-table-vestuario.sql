create table vestuario(
id bigint not null auto_increment,
nome varchar (100) not null,
marca varchar (100) not null,
categoria varchar (100) not null,
cor varchar (100) not null,
quantidade int not null,
preco decimal (10, 2) not null,

primary key (id)
);