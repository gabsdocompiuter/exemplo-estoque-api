package br.com.aquasoft.estoque.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class EstoqueProdutoDto {

    private ProdutoDto produto;

    private BigDecimal totalEmEstoque;

    @Builder.Default
    private List<EstoqueLocalProdutoDto> locaisEstoque = new ArrayList<>();

}
