CREATE DATABASE db_tempoedinheiro;

USE db_tempoedinheiro;

CREATE TABLE tb_usuario (
	id_usuario bigint NOT NULL AUTO_INCREMENT,
	nome varchar(100) NOT NULL,
	usuario varchar(100) NOT NULL,
	senha varchar(100) NOT NULL,
	dtNascimento varchar(100),
    PRIMARY KEY (id_usuario)
);

CREATE TABLE tb_cliente (
	id_cliente bigint NOT NULL AUTO_INCREMENT,
	nome varchar(100) NOT NULL,
	usuario varchar(100) NOT NULL,
	senha varchar(100) NOT NULL,
	cnpj varchar(100) NOT NULL,
	PRIMARY KEY (id_cliente)
);

CREATE TABLE tb_categoria (
	id_categoria bigint NOT NULL AUTO_INCREMENT,
	tipo varchar(100) NOT NULL,
	descricao varchar(100),
	PRIMARY KEY (id_categoria)
);

CREATE TABLE tb_avaliacao (
	id_avaliacao bigint NOT NULL AUTO_INCREMENT,
	usuario_id bigint NOT NULL,
	categoria_id bigint NOT NULL,
	titulo varchar(100) NOT NULL,
	comentario varchar(255),
	nota int NOT NULL,
	duracao int NOT NULL,
	valor DECIMAL NOT NULL,
	dataAtividade varchar(100) NOT NULL,
	PRIMARY KEY (id_avaliacao),
    FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id_usuario),
    FOREIGN KEY (categoria_id) REFERENCES tb_categoria(id_categoria)
);

CREATE TABLE tb_venda (
	id_venda bigint NOT NULL AUTO_INCREMENT,
	cliente_id bigint NOT NULL,
	produto varchar(100) NOT NULL,
	preco DECIMAL NOT NULL,
	dataVenda varchar(100) NOT NULL,
	PRIMARY KEY (id_venda),
    FOREIGN KEY (cliente_id) REFERENCES tb_cliente(id_cliente)
);