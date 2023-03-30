create table fabricantes(

	id bigint not null auto_increment,
	nome varchar(100) not null,
	cnpj varchar(20) not null unique,

	primary key(id)

);