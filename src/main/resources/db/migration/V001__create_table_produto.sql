CREATE TABLE IF NOT EXISTS produto (
    id BIGSERIAL PRIMARY KEY,
    codigo_barras VARCHAR(30) NOT NULL,
    descricao VARCHAR(255) NOT NULL,

    CONSTRAINT uk_funcionalidades_codigo UNIQUE (codigo_barras)
);
