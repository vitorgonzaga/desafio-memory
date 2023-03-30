create table reacoes (

	id bigint not null auto_increment,
	descricao varchar(100) not null unique,

	primary key(id)

);