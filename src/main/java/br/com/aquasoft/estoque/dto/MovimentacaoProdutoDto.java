package br.com.aquasoft.estoque.dto;

import br.com.aquasoft.estoque.enums.TipoMovimentacaoEstoque;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovimentacaoProdutoDto {

    private ProdutoDto produto;
    private BigDecimal quantidade;
    private LocalEstoqueDto localEstoque;
    private TipoMovimentacaoEstoque tipoMovimentacao;

}
