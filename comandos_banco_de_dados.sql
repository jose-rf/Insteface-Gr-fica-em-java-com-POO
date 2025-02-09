CREATE DATABASE cadastro;

USE cadastro;

-- Criar tabela de pessoas
CREATE TABLE cadastro_pessoa (
 id       INT auto_increment NOT NULL,
 nome     VARCHAR(100)       NOT NULL,
 endereco VARCHAR(100)       NOT NULL,
 email    VARCHAR(100)       NULL,
 telefone VARCHAR(100)       NULL,
 CONSTRAINT cadastro_pessoa_pk PRIMARY KEY (id)
);

DROP TABLE cadastro_pessoa;
SELECT * FROM cadastro_pessoa;

-- Criar tabela de UFs (Estados)
CREATE TABLE uf (
 id    INT AUTO_INCREMENT NOT NULL,
 nome  VARCHAR(100)       NOT NULL,
 sigla VARCHAR(2)         NOT NULL,
 CONSTRAINT uf_pk PRIMARY KEY (id) -- Correção: Nome único para a constraint
);
INSERT INTO uf (nome, sigla) VALUES
('Acre', 'AC'), ('Alagoas', 'AL'), ('Amapá', 'AP'), ('Amazonas', 'AM'),
('Bahia', 'BA'), ('Ceará', 'CE'), ('Distrito Federal', 'DF'), ('Espírito Santo', 'ES'),
('Goiás', 'GO'), ('Maranhão', 'MA'), ('Mato Grosso', 'MT'), ('Mato Grosso do Sul', 'MS'),
('Minas Gerais', 'MG'), ('Pará', 'PA'), ('Paraíba', 'PB'), ('Paraná', 'PR'),
('Pernambuco', 'PE'), ('Piauí', 'PI'), ('Rio de Janeiro', 'RJ'), ('Rio Grande do Norte', 'RN'),
('Rio Grande do Sul', 'RS'), ('Rondônia', 'RO'), ('Roraima', 'RR'), ('Santa Catarina', 'SC'),
('São Paulo', 'SP'), ('Sergipe', 'SE'), ('Tocantins', 'TO');

DROP TABLE uf;
SELECT * FROM uf;

-- Criar tabela de fornecedores
CREATE TABLE cadastro.cadastro_fornecedor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    endereco VARCHAR(150) NOT NULL,
    uf INT NOT NULL,
    telefone VARCHAR(20),
    cnpj VARCHAR(20) UNIQUE NOT NULL,
    inscricaoEstadual VARCHAR(20),
    nomeFantasia VARCHAR(100),
    categoria VARCHAR(50),
    FOREIGN KEY (uf) REFERENCES uf(id) ON DELETE CASCADE
);

DROP TABLE cadastro.cadastro_fornecedor;
SELECT * FROM cadastro.cadastro_fornecedor;
