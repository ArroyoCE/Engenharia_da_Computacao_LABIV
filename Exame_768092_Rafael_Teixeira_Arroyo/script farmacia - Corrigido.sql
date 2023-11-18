create table tb_usuario (
	nome varchar(50),
	id varchar (60),
	senha varchar(32),
	CONSTRAINT
	pk_tb_usuario_id primary key (id)
);

create table tb_fornecedor (
	cnpj varchar(20),
	telefone varchar(20),
	nome varchar(50),
	constraint
	pk_tb_fornecedor_cnpj primary key (cnpj)
);

create table tb_estoque (
	id_produto serial primary key,
	id_fornecedor varchar(20),
	nome_produto varchar (50),
	preco_custo decimal(10,2),
	quantidade integer,
	constraint
	fk_tb_estoque_fornecedor foreign key (id_fornecedor)
	references tb_fornecedor (cnpj)
);

create table tb_funcionario (
	id serial primary key,
	nome varchar (50),
	cargo varchar (20) 
);

create table tb_cliente (
	cpf varchar(20),
	nome varchar (50),
	email varchar (60),
	constraint
	pk_tb_clientes_cpf primary key (cpf)
);

create table tb_venda (
	id serial primary key,
	id_funcionario integer,
	id_produto integer,
	id_cliente varchar(20),
	data date,
	total decimal (10,2),
	quantidade integer,
	constraint
	fk_tb_venda_funcionario foreign key (id_funcionario)
	references tb_funcionario (id),
	constraint
	fk_tb_venda_produto foreign key (id_produto)
	references tb_estoque (id_produto),
	constraint
	fk_tb_venda_cliente foreign key (id_cliente)
	references tb_cliente (cpf)
	
);

insert into tb_usuario values 
('Rafael Arroyo', 'rafaeltarroyo@gmail.com', MD5('12345')),
('Camila Manzi', 'kkmanzi85@gmail.com', MD5('casa2017'));

insert into tb_fornecedor values
(12345678000187, 016996118959, 'Produtos farmaceuticos S/A'),
(32252685000123, 017981150759, 'Remedios Ltda');

insert into tb_estoque (id_fornecedor, nome_produto, preco_custo, quantidade) values
(12345678000187, 'dipirona', 20.00, 10),
(32252685000123, 'neosaldina', 5.00, 100),
(32252685000123, 'Eno', 2.00, 30);

insert into tb_funcionario (nome, cargo) values
('Helen Manzi', 'gerente'),
('Mario Arroyo', 'caixa'),
('Claudia Arroyo', 'estoquista');

insert into tb_cliente values
(12345678917, 'Rubens Manzi', 'gagagag@gmail.com'),
(35791059817, 'Alzira Manzi', 'alzira@gmail.com');

insert into tb_venda (id_funcionario, id_produto, id_cliente, data, total, quantidade) values
(2, 2, 35791059817, '2023-10-29', 20, 1);


