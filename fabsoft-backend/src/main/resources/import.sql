--
-- ATENÇÃO: COLOQUE ESTE ARQUIVO EM fabsoft-backend/src/main/resources/data.sql
--

-- 1. PESSOAS, PROPRIETÁRIOS e LOCATÁRIOS
-- IDs 1-5: Proprietários (Usados como Síndicos)
INSERT INTO pessoa (id, nome, cpf, data_nascimento, email, telefone) VALUES (1, 'João Silva (Sindico/Prop)', '11111111111', '1975-01-10', 'joao.prop@email.com', '47991111111');
INSERT INTO pessoa (id, nome, cpf, data_nascimento, email, telefone) VALUES (2, 'Maria Santos (Sindico/Prop)', '22222222222', '1982-05-20', 'maria.prop@email.com', '47992222222');
INSERT INTO pessoa (id, nome, cpf, data_nascimento, email, telefone) VALUES (3, 'Pedro Alves (Sindico/Prop)', '33333333333', '1990-11-05', 'pedro.prop@email.com', '47993333333');
INSERT INTO pessoa (id, nome, cpf, data_nascimento, email, telefone) VALUES (4, 'Ana Costa (Sindico/Prop)', '44444444444', '1988-03-18', 'ana.prop@email.com', '47994444444');
INSERT INTO pessoa (id, nome, cpf, data_nascimento, email, telefone) VALUES (5, 'Lucas Pereira (Sindico/Prop)', '55555555555', '1995-07-25', 'lucas.prop@email.com', '47995555555');

-- Mapeia os IDs 1-5 como Proprietários
INSERT INTO proprietario (id) VALUES (1);
INSERT INTO proprietario (id) VALUES (2);
INSERT INTO proprietario (id) VALUES (3);
INSERT INTO proprietario (id) VALUES (4);
INSERT INTO proprietario (id) VALUES (5);

-- IDs 6-10: Locatários
INSERT INTO pessoa (id, nome, cpf, data_nascimento, email, telefone) VALUES (6, 'Camila Souza (Locatario)', '66666666666', '1998-09-12', 'camila.loc@email.com', '47996666666');
INSERT INTO pessoa (id, nome, cpf, data_nascimento, email, telefone) VALUES (7, 'Rafael Lima (Locatario)', '77777777777', '2000-04-01', 'rafael.loc@email.com', '47997777777');
INSERT INTO pessoa (id, nome, cpf, data_nascimento, email, telefone) VALUES (8, 'Fernanda Rocha (Locatario)', '88888888888', '1985-06-30', 'fernanda.loc@email.com', '47998888888');
INSERT INTO pessoa (id, nome, cpf, data_nascimento, email, telefone) VALUES (9, 'Gustavo Melo (Locatario)', '99999999999', '1993-12-15', 'gustavo.loc@email.com', '47999999999');
INSERT INTO pessoa (id, nome, cpf, data_nascimento, email, telefone) VALUES (10, 'Helena Vieira (Locatario)', '10110110101', '1996-08-08', 'helena.loc@email.com', '47990000000');

-- Mapeia os IDs 6-10 como Locatários (com o campo 'endereco')
INSERT INTO locatario (id, endereco) VALUES (6, 'Rua das Flores, 100');
INSERT INTO locatario (id, endereco) VALUES (7, 'Avenida Principal, 200');
INSERT INTO locatario (id, endereco) VALUES (8, 'Alameda dos Anjos, 300');
INSERT INTO locatario (id, endereco) VALUES (9, 'Travessa do Sol, 400');
INSERT INTO locatario (id, endereco) VALUES (10, 'Estrada da Montanha, 500');

-- 2. CONDOMÍNIO (5 registros)
INSERT INTO condominio (id, nome, endereco, cnpj, sindico) VALUES (1, 'Residencial América', 'Rua XV de Novembro, 1000 - Centro', '00111222000111', 1);
INSERT INTO condominio (id, nome, endereco, cnpj, sindico) VALUES (2, 'Edifício Crystal', 'Av. Brasil, 500 - Bairro Nobre', '00333444000122', 2);
INSERT INTO condominio (id, nome, endereco, cnpj, sindico) VALUES (3, 'Solar da Montanha', 'Rua das Montanhas, 250 - Boa Vista', '00555666000133', 3);
INSERT INTO condominio (id, nome, endereco, cnpj, sindico) VALUES (4, 'Cond. Vila Nova', 'Rua dos Imigrantes, 80 - Vila Nova', '00777888000144', 4);
INSERT INTO condominio (id, nome, endereco, cnpj, sindico) VALUES (5, 'Green Park', 'Estrada Bonita, 120 - Zona Rural', '00999000000155', 5);

-- 3. ESPAÇO (5 registros)
INSERT INTO espaco (id, nome, descricao, capacidade_maxima, valor_reserva, condominio_id) VALUES (1, 'Salão de Festas A', 'Espaço principal com capacidade alta.', 100, 350.00, 1);
INSERT INTO espaco (id, nome, descricao, capacidade_maxima, valor_reserva, condominio_id) VALUES (2, 'Churrasqueira 1', 'Quiosque coberto com pia e freezer.', 20, 100.00, 2);
INSERT INTO espaco (id, nome, descricao, capacidade_maxima, valor_reserva, condominio_id) VALUES (3, 'Academia', 'Sala de ginástica com acesso livre.', 30, 0.00, 3);
INSERT INTO espaco (id, nome, descricao, capacidade_maxima, valor_reserva, condominio_id) VALUES (4, 'Piscina', 'Área de piscinas com espreguiçadeiras.', 150, 0.00, 4);
INSERT INTO espaco (id, nome, descricao, capacidade_maxima, valor_reserva, condominio_id) VALUES (5, 'Sala de Jogos', 'Sala com sinuca e pebolim.', 40, 50.00, 5);

-- 4. IMÓVEL (5 registros)
INSERT INTO imovel (id, numero, bloco, qtde_quartos, qtde_banheiros, vaga_garagem, status_imovel, condominio_id, proprietario_id) VALUES (1, '101', 'A', 3, 2, 2, 'OCUPADO', 1, 1);
INSERT INTO imovel (id, numero, bloco, qtde_quartos, qtde_banheiros, vaga_garagem, status_imovel, condominio_id, proprietario_id) VALUES (2, '202', 'B', 2, 1, 1, 'DISPONIVEL', 2, 2);
INSERT INTO imovel (id, numero, bloco, qtde_quartos, qtde_banheiros, vaga_garagem, status_imovel, condominio_id, proprietario_id) VALUES (3, '303', 'C', 1, 1, 1, 'OCUPADO', 3, 3);
INSERT INTO imovel (id, numero, bloco, qtde_quartos, qtde_banheiros, vaga_garagem, status_imovel, condominio_id, proprietario_id) VALUES (4, '404', 'D', 3, 3, 2, 'MANUTENCAO', 4, 4);
INSERT INTO imovel (id, numero, bloco, qtde_quartos, qtde_banheiros, vaga_garagem, status_imovel, condominio_id, proprietario_id) VALUES (5, '505', 'E', 2, 1, 1, 'DISPONIVEL', 5, 5);

-- 5. LOCAÇÃO (5 registros)
-- O campo 'imovel' é a FK para Imovel
INSERT INTO locacao (id, inicio_locacao, fim_locacao, valor_aluguel, status_locacao, imovel) VALUES (1, '2024-01-10', '2025-01-10', 2500.00, 'ATIVA', 1);
INSERT INTO locacao (id, inicio_locacao, fim_locacao, valor_aluguel, status_locacao, imovel) VALUES (2, '2024-03-01', '2025-03-01', 1800.00, 'ATIVA', 3);
INSERT INTO locacao (id, inicio_locacao, fim_locacao, valor_aluguel, status_locacao, imovel) VALUES (3, '2024-05-15', '2025-05-15', 3200.00, 'ENCERRADA', 2);
INSERT INTO locacao (id, inicio_locacao, fim_locacao, valor_aluguel, status_locacao, imovel) VALUES (4, '2024-07-20', '2025-07-20', 1500.00, 'INADIMPLENTE', 4);
INSERT INTO locacao (id, inicio_locacao, fim_locacao, valor_aluguel, status_locacao, imovel) VALUES (5, '2024-11-01', '2025-11-01', 2100.00, 'ATIVA', 5);

-- 6. RESERVA (5 registros)
-- O campo 'reserva_espaco_id' é a FK para Espaco.
INSERT INTO reserva (id, data_evento, observacoes, valor_total, reserva_espaco_id) VALUES (1, '2025-01-20', 'Aniversário infantil', 350.00, 1); 
INSERT INTO reserva (id, data_evento, observacoes, valor_total, reserva_espaco_id) VALUES (2, '2025-02-15', 'Churrasco com amigos', 100.00, 2); 
INSERT INTO reserva (id, data_evento, observacoes, valor_total, reserva_espaco_id) VALUES (3, '2025-03-10', 'Reunião de condomínio (gratuito)', 0.00, 3); 
INSERT INTO reserva (id, data_evento, observacoes, valor_total, reserva_espaco_id) VALUES (4, '2025-04-05', 'Dia de sol (gratuito)', 0.00, 4); 
INSERT INTO reserva (id, data_evento, observacoes, valor_total, reserva_espaco_id) VALUES (5, '2025-05-01', 'Torneio de sinuca', 50.00, 5); 


-- 7. REINICIA SEQUÊNCIAS DO H2 (CORREÇÃO FINAL)
-- Isso garante que novos inserts gerados pelo JPA comecem após o último ID manual (10 para Pessoa, 5 para o resto).
ALTER TABLE pessoa ALTER COLUMN id RESTART WITH 11;
ALTER TABLE condominio ALTER COLUMN id RESTART WITH 6;
ALTER TABLE espaco ALTER COLUMN id RESTART WITH 6;
ALTER TABLE imovel ALTER COLUMN id RESTART WITH 6;
ALTER TABLE locacao ALTER COLUMN id RESTART WITH 6;
ALTER TABLE reserva ALTER COLUMN id RESTART WITH 6;