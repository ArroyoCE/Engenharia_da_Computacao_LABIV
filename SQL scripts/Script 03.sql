create table tb_categoria(
	id serial,
	nome varchar(120) not null,
	fg_ativo int,
	constraint pk_categoria primary key (id)
);

update tb_categoria set nome = 'Carros' where id = 4;

insert into tb_categoria (nome, fg_ativo)
	values ('Alimentos', 1),
		   ('Automotivo', 1),
		   ('Bebidas', 1),
		   ('Beleza', 1),
		   ('Brinquedos', 1),
		   ('Celulares', 1),
		   ('Esportes', 1),
		   ('Informática', 1),
		   ('Papelaria', 1);
		
	
select * from tb_categoria;	

create table tb_produto(
	id serial,
	categoria_id int,
	nome varchar(120) not null,
	quantidade int,
	valor_unitario float,
	fg_ativo int,
	constraint pk_produto primary key(id),
	constraint fk_produto foreign key(categoria_id)
		references tb_categoria(id)
);

select p.nome, p.quantidade, p.valor_unitario, c.nome from tb_produto as p
	inner join tb_categoria as c
	on (p.categoria_id = c.id)

insert into tb_produto (categoria_id, nome, quantidade, valor_unitario)
	values (3, 'Pringles', 100, 12.00),
		   (4, 'Pneu', 5, 100.00),
		   (5, 'Cerveja', 200, 3.50),
		   (6, 'Shampoo', 50, 9.75),
		   (7, 'Peteca', 30, 5.85),
		   (8, 'Moto G', 3, 1100.00),
		   (9, 'Bola de Futebol', 20, 50),
		   (10, 'Notebook Dell', 8, 5500.00),
		   (11, 'Caneta Bic', 1000, 2.00);

update tb_produto set valor_unitario = 4.00, quantidade = 150 where nome = 'Cerveja'; 

update tb_produto set fg_ativo = 1;

update tb_produto set fg_ativo = 0 where nome = 'Pneu';

select * from tb_produto where fg_ativo = 1 order by id;

select * from tb_produto where valor_unitario > 10; 

select 
	
	p.nome, p.quantidade, p.valor_unitario, c.nome,
	(p.valor_unitario * p.quantidade) as "Total"
	from tb_produto as p
	inner join tb_categoria as c
	on (p.categoria_id = c.id)
	where c.nome = 'Informática';
