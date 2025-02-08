CREATE DATABASE cadastro;

USE cadastro;

CREATE TABLE cadastro.cadastro_pessoa (
	id INT auto_increment NOT NULL,
	nome varchar(100) NOT NULL,
    endereco varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    telefone varchar(100) NOT NULL,
    CONSTRAINT cadastro_pessoa_pk PRIMARY KEY (id)
);

select * from cadastro.cadastro_pessoa;

CREATE TABLE cadastro.uf (
	id INT auto_increment NOT NULL,
	nome varchar(100) NOT NULL,
    sigla varchar(2) NOT NULL,
    CONSTRAINT uf_pk PRIMARY KEY (id)
);

select * from cadastro.uf;

CREATE TABLE cadastro.cadastro_fornecedor (
    id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    cnpj VARCHAR(20) NOT NULL,
    inscricao_estadual VARCHAR(20) NOT NULL,
    nome_fantasia VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    uf_id INT NOT NULL,
    CONSTRAINT cadastro_fornecedor_pk PRIMARY KEY (id),
    CONSTRAINT cadastro_fornecedor_uf_fk FOREIGN KEY (uf_id) REFERENCES cadastro.uf(id)
);

SELECT * FROM cadastro.cadastro_fornecedor;

