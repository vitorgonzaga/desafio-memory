create table fabricantes_medicamentos (

	medicamentos_id bigint not null,
	fabricante_id bigint not null,

	foreign key(medicamentos_id) references medicamentos(id),
	foreign key(fabricante_id) references fabricantes(id)

);