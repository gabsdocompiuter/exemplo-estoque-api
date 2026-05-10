CREATE TABLE IF NOT EXISTS movimentacao_estoque_produto (
    id BIGSERIAL PRIMARY KEY,
    estoque_produto_id BIGINT NOT NULL,
    quantidade DECIMAL(13, 2) NOT NULL,
    horario_movimentacao DATE NOT NULL,
    tipo_movimentacao_estoque VARCHAR(20) NOT NULL,

    constraint fk_movimentacao_estoque_produto_estoque_produto
        foreign key (estoque_produto_id) references estoque_produto(id)
);
