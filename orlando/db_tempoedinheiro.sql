create database db_tempoedinheiro;

use db_tempoedinheiro;

 CREATE TABLE tb_usuario (
	id INT AUTO_INCREMENT,
	nome varchar(255) NOT NULL,
	usuario varchar(255) NOT NULL UNIQUE,
	dataNasc DATE NOT NULL,
	senha varchar(255) NOT NULL,
	cnpj BOOLEAN NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE tb_categorias (
	id INT AUTO_INCREMENT,
	tipo varchar(255) NOT NULL,
	descrisao varchar(255),
	PRIMARY KEY (id)
);

CREATE TABLE tb_avaliacao (
	id INT AUTO_INCREMENT,
	usuario_id INT NOT NULL,
	categoria_id INT NOT NULL,
	titulo varchar(255) NOT NULL,
	comentario varchar(510),
	nota DECIMAL NOT NULL,
	preco DECIMAL(6,2),
	data DATE NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE tb_vendas (
	id INT AUTO_INCREMENT,
	usuario_id INT NOT NULL,
	relatorio_id INT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE tb_relatorio (
	id INT AUTO_INCREMENT,
	categoria_id INT NOT NULL,
	periodo varchar(255) NOT NULL,
	valor DECIMAL(6,2) NOT NULL,
	data DATE NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE tb_avaliacao ADD CONSTRAINT tb_avaliacao_fk0 FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id);

ALTER TABLE tb_avaliacao ADD CONSTRAINT tb_avaliacao_fk1 FOREIGN KEY (categoria_id) REFERENCES tb_categorias(id);

ALTER TABLE tb_vendas ADD CONSTRAINT tb_vendas_fk0 FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id);

ALTER TABLE tb_vendas ADD CONSTRAINT tb_vendas_fk1 FOREIGN KEY (relatorio_id) REFERENCES tb_relatorio(id);

ALTER TABLE tb_relatorio ADD CONSTRAINT tb_relatorio_fk0 FOREIGN KEY (categoria_id) REFERENCES tb_categorias(id);

INSERT INTO tb_usuario (nome, usuario, dataNasc, senha, cnpj) VALUES ("Orlando", "orlando@email.com", "2000-02-14", "senha1234", true);

SELECT * FROM tb_usuario;

INSERT INTO tb_categorias (tipo, descrisao) VALUES ("Filmes", "Filmes de ação");

SELECT * FROM tb_categorias;

INSERT INTO tb_avaliacao (usuario_id, categoria_id, titulo, comentario, nota, preco, data)
	VALUES (1, 1, "Vidas a deriva", "Muito bom!!!!", 5, 0, "2021-10-20");
    
SELECT * FROM tb_avaliacao;

INSERT INTO tb_relatorio (categoria_id, periodo, valor, data ) VALUES (1, "Outubro", 500.00, "2021-10-20");

SELECT * FROM tb_relatorio;

INSERT INTO tb_vendas (usuario_id, relatorio_id) VALUES (1, 1);

SELECT * FROM tb_vendas;