CREATE TABLE cliente (
  id BINARY(16) NOT NULL,
  nome VARCHAR(60) NOT NULL,
  ddd CHAR(2) NULL,
  telefone VARCHAR(20) NULL,
  tipo_documento VARCHAR(4) NULL,
  numero_documento VARCHAR(14) NULL UNIQUE,
  PRIMARY KEY (id));

CREATE TABLE operador (
  id BINARY(16) NOT NULL,
  nome_perfil VARCHAR(80) NOT NULL,
  email VARCHAR(80) NOT NULL UNIQUE,
  senha VARCHAR(45) NOT NULL,
  status TINYINT NOT NULL,
  primeiro_acesso TINYINT NOT NULL,
  fk_cliente BINARY(16) NOT NULL,
  PRIMARY KEY (id),
    CONSTRAINT fk_Operador_Cliente
    FOREIGN KEY (fk_cliente)
    REFERENCES cliente(id)
  );

  CREATE TABLE conta (
  id BINARY(16) NOT NULL,
  numero_conta VARCHAR(45) NOT NULL,
  agencia INT NOT NULL,
  banco VARCHAR(45) NOT NULL,
  saldo DECIMAL(12,2) NULL,
  fk_cliente BINARY(16) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_Conta_Cliente
    FOREIGN KEY (fk_cliente)
    REFERENCES cliente(id)
 );