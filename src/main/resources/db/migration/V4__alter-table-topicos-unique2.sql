ALTER TABLE topicos
ADD CONSTRAINT uc_titulo_mensagem UNIQUE (titulo, mensagem(255));
