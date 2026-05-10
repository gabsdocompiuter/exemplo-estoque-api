package br.com.aquasoft.estoque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
public class ProdutoEntity extends BaseEntity{

    @Column(name = "codigo_barras", unique = true)
    private String codigoBarras;

    @Column(name = "descricao")
    private String descricao;

    @Builder.Default
    @OneToMany(mappedBy = "produto")
    private List<EstoqueProdutoEntity> estoqueProdutoList = new ArrayList<>();

}
