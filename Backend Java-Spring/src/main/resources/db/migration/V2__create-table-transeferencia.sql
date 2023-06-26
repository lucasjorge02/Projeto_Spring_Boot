CREATE TABLE transferencia (
  id BINARY(16) NOT NULL,
  data_transferencia DATETIME NOT NULL,
  valor DECIMAL(12,2) NOT NULL,
  descricao VARCHAR(45) NULL,
  fk_operador BINARY(16) NOT NULL,
  fk_conta BINARY(16) NOT NULL,
  PRIMARY KEY (id, fk_operador, fk_conta),
  CONSTRAINT fk_Transferencia_Operador FOREIGN KEY (fk_operador) REFERENCES operador (id),
  CONSTRAINT fk_Transferencia_Conta FOREIGN KEY (fk_conta) REFERENCES conta (id)
  );