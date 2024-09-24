CREATE TABLE cliente_entity
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    cpf              VARCHAR(255)                            NOT NULL,
    nome             VARCHAR(255)                            NOT NULL,
    email            VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_cliente_entity PRIMARY KEY (id)
);
