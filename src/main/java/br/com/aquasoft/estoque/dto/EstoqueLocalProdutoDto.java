package br.com.aquasoft.estoque.dto;

import br.com.aquasoft.estoque.entity.EstoqueProdutoEntity;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class EstoqueLocalProdutoDto {

    private LocalEstoqueDto localEstoque;
    private BigDecimal quantidadeEmEstoque;


    /*** Métodos de Conversão ***/

    public static EstoqueLocalProdutoDto fromEntity(EstoqueProdutoEntity entity) {
        return EstoqueLocalProdutoDto.builder()
                .localEstoque(LocalEstoqueDto.fromEntity(entity.getLocalEstoque()))
                .quantidadeEmEstoque(entity.getQuantidadeEmEstoque())
                .build();
    }
}
