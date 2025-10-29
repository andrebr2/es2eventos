INSERT INTO tb_tipo_participante(descricao) VALUES ('Aluno(a)');
INSERT INTO tb_tipo_participante(descricao) VALUES ('Professor(a)');
INSERT INTO tb_tipo_participante(descricao) VALUES ('Outros');

INSERT INTO tb_endereco (cep) VALUES ('85851-000');
INSERT INTO tb_endereco (cep) VALUES ('85810-030');
INSERT INTO tb_endereco (cep) VALUES ('85900-000');
INSERT INTO tb_endereco (cep) VALUES ('80010-000');
INSERT INTO tb_endereco (cep) VALUES ('86010-160');


INSERT INTO tb_participante (nome, sobrenome, email, telefone, tipo_participante_id, numero, complemento, endereco_id) VALUES ('Lucas', 'Ferreira', 'lucas.ferreira@email.com', '(45) 99999-1234', 1, '123', 'Bloco A, apto 12', 1);
INSERT INTO tb_participante (nome, sobrenome, email, telefone, tipo_participante_id, numero, complemento, endereco_id) VALUES ('Mariana', 'Souza', 'mariana.souza@email.com', '(45) 98888-5678', 2, '456', 'Casa 2', 2);
INSERT INTO tb_participante (nome, sobrenome, email, telefone, tipo_participante_id, numero, complemento, endereco_id) VALUES ('Roberto', 'Almeida', 'roberto.almeida@email.com', '(45) 97777-9012', 3, '789', 'Sala comercial 5', 3);
INSERT INTO tb_participante (nome, sobrenome, email, telefone, tipo_participante_id, numero, complemento, endereco_id) VALUES ('Ana', 'Costa', 'ana.costa@email.com', '(41) 96666-3456', 1, '101', 'Torre 3, apto 21', 4);
INSERT INTO tb_participante (nome, sobrenome, email, telefone, tipo_participante_id, numero, complemento, endereco_id) VALUES ('Carlos', 'Mendes', 'carlos.mendes@email.com', '(43) 95555-7890', 2, '202', 'Fundos', 5);