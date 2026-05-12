package br.com.aquasoft.estoque.enums;

import lombok.Getter;

@Getter
public enum TipoMovimentacaoEstoque {
    ENTRADA("Entrada", true),
    SAIDA("Saída", false),
    TRANSFERENCIA_ENTRADA("Transferência Entrada", true),
    TRANSFERENCIA_SAIDA("Transferência Saída", false),
    ;

    private final String description;
    private final boolean somaQuantidade;

    TipoMovimentacaoEstoque(String description, boolean somaQuantidade) {
        this.description = description;
        this.somaQuantidade = somaQuantidade;
    }
}
