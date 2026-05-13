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
    private final boolean entrada;

    TipoMovimentacaoEstoque(String description, boolean entrada) {
        this.description = description;
        this.entrada = entrada;
    }
}
