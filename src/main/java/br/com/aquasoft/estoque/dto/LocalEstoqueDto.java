package br.com.aquasoft.estoque.dto;

import br.com.aquasoft.estoque.entity.LocalEstoqueEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalEstoqueDto {

    private Long id;
    private String descricao;


    public LocalEstoqueEntity toEntity() {
        return LocalEstoqueEntity.builder()
                .id(id)
                .descricao(descricao)
                .build();
    }

    public static LocalEstoqueDto fromEntity(LocalEstoqueEntity entity) {
        return LocalEstoqueDto.builder()
                .id(entity.getId())
                .descricao(entity.getDescricao())
                .build();
    }

    public static List<LocalEstoqueDto> fromEntity(List<LocalEstoqueEntity> entityList) {
        return entityList.stream()
                .map(LocalEstoqueDto::fromEntity)
                .toList();
    }
}
