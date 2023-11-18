create table tb_livro(
	id serial,
	titulo varchar(180) not null,
	id_autor int,
	constraint pk_livro_id primary key(id),
	constraint fk_autor foreign key(id_autor)
		references tb_autor(id)
);

select * from tb_autor;

insert into tb_livro(titulo,id_autor)
	values ('Java como Programar', 3);

insert into tb_livro(titulo,id_autor)
	values ('C Completo e Total', 1);
	
insert into tb_livro(titulo,id_autor)
	values ('A Sala de Aula que Derreteu', 10);

/* JUNÇÃO DE DUAS TABELAS*/

select l.titulo, a.nome from tb_livro as l
	inner join tb_autor as a
	on (l.id_autor = a.id)

