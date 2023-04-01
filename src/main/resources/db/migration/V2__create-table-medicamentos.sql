create table medicamentos(

	id bigint not null auto_increment,
	registro_anvisa varchar(20) not null unique,
	nome varchar(100) not null,
	data_validade date not null,
	telefone varchar(20) not null,
	preco float not null,
	quantidade_comprimidos int not null,
	fabricante_id bigint not null,

	primary key(id),
	constraint fk_medicamentos_fabricante_id foreign key(fabricante_id) references fabricantes(id)

);