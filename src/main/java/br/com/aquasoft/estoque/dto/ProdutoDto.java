package br.com.aquasoft.estoque.dto;

import br.com.aquasoft.estoque.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    private Long id;
    private String codigoBarras;
    private String descricao;


    /*** Métodos de Conversão ***/

    public ProdutoEntity toEntity() {
        return ProdutoEntity.builder()
                .id(id)
                .codigoBarras(codigoBarras)
                .descricao(descricao)
                .build();
    }

    public static ProdutoDto fromEntity(ProdutoEntity entity) {
        return ProdutoDto.builder()
                .id(entity.getId())
                .codigoBarras(entity.getCodigoBarras())
                .descricao(entity.getDescricao())
                .build();
    }

    public static List<ProdutoDto> fromEntity(List<ProdutoEntity> entityList) {
        return entityList.stream()
                .map(ProdutoDto::fromEntity)
                .toList();
    }
}
