CREATE TABLE IF NOT EXISTS estoque_produto (
    id BIGSERIAL PRIMARY KEY,
    produto_id BIGINT NOT NULL,
    local_estoque_id BIGINT NOT NULL,
    quantidade_estoque DECIMAL(13, 2) NOT NULL DEFAULT 0,
    quantidade_reservada DECIMAL(13, 2) NOT NULL DEFAULT 0,

    CONSTRAINT fk_estoque_produto_produto
        FOREIGN KEY (produto_id) REFERENCES produto(id),

    CONSTRAINT fk_estoque_produto_local_estoque
        FOREIGN KEY (local_estoque_id) REFERENCES local_estoque(id)
);
