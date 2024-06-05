CREATE TABLE topicos (

    id BIGINT not null AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    dataCriacao DATETIME NOT NULL,
    status VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL,
    respostas TEXT NOT NULL,

    primary key (id)

);