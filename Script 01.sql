/* CRIAÇÃO DA TABELA tb_autor */
create table tb_autor(
	id serial,
	nome varchar(120) not null,
	email varchar(100),
	constraint pk_autor_id primary key(id)		
);

/* INSERIR DADOS NA TABELA */
insert into tb_autor (nome,email)
	values ('Ana Maria','ana@email.com');

insert into tb_autor (nome,email)
	values ('João da Silva','joao@email.com');
	
insert into tb_autor (nome,email)
	values ('Clara Maria','clara@email.com');
	
/* INSERIR MÚLTIPLOS DADOS NA TABELA*/
insert into tb_autor (nome,email)
	values ('José Carlos','jose@email.com'),
	       ('Maria Luiza','maria@email.com'),
		   ('Antônia Santos','antonia@email.com');
		   
select * from tb_autor;