create table medicamentos_reacoes (

	medicamento_id bigint not null,
	reacao_id bigint not null,

	foreign key(medicamento_id) references medicamentos(id),
	foreign key(reacao_id) references reacoes(id)

);