package br.com.aquasoft.estoque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estoque_produto")
public class EstoqueProdutoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    @ManyToOne
    @JoinColumn(name = "local_estoque_id")
    private LocalEstoqueEntity localEstoque;

    @Column(name = "quantidade_estoque")
    private BigDecimal quantidadeEmEstoque = BigDecimal.ZERO;

    @Builder.Default
    @OneToMany(mappedBy = "estoqueProduto")
    private List<MovimentacaoEstoqueProdutoEntity> movimentacaoEstoqueList = new ArrayList<>();


    public EstoqueProdutoEntity(ProdutoEntity produto, LocalEstoqueEntity localEstoque) {
        this.produto = produto;
        this.localEstoque = localEstoque;
    }
}
