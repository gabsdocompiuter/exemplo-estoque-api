package br.com.aquasoft.estoque.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "local_estoque")
public class LocalEstoqueEntity extends BaseEntity {

    @Column(name = "descricao")
    private String descricao;

}
