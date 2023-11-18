/* -- TB_USUARIO -------------- */
CREATE TABLE tb_usuario (
  email VARCHAR(120) PRIMARY KEY,
  senha VARCHAR(32),
  nome VARCHAR(100)
);

INSERT INTO tb_usuario (email, senha,nome)
    values ('joao@email.com', md5('123465'),'João da Silva'),
           ('ana@email.com', md5('123465'),'Ana Maria');
           
select * from tb_usuario;


/* -- TB_CATEGORIA -------------- */
CREATE TABLE tb_categoria (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(255)
);

insert into tb_categoria (nome)
    values ('Mouse'), ('Teclado'), ('Notebook'),
        ('Processador'), ('Placa Mãe'),
        ('Armazenamento HD'), ('Armazenamento SSD'),
        ('Gabinete'),('Monitor'),('Periféricos');

select * from tb_categoria;

/* -- TB_PRODUTO -------------- */
CREATE TABLE tb_produto (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(255),
  preco DECIMAL(10,2),
  quantidade INT,
  categoria_id INT,
  FOREIGN KEY (categoria_id) REFERENCES tb_categoria(id)
);

insert into tb_produto (nome,preco,quantidade,categoria_id)
    values
        ('Processador Intel Core i5',1482.00,5,4),
        ('Processador Intel Core i3',999.00,8,4),
        ('Processador Intel Core i7',2235.00,2,4),
        ('Placa MÃE 1151 Biostar H310m',536.00,6,5),
        ('Placa MÃE 1200 Asrock Z590',772.00,4,5),
        ('Placa MÃE 1200 Gigabyte H510m',566.00,10,5),
        ('Mouse sem FIO 1600dpi M-w012bk Preto C3tech',40.00,20,1);
		
select * from tb_categoria