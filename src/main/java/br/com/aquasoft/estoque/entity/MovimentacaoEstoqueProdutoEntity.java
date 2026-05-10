package br.com.aquasoft.estoque.entity;

import br.com.aquasoft.estoque.enums.TipoMovimentacaoEstoque;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movimentacao_estoque_produto")
public class MovimentacaoEstoqueProdutoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estoque_produto_id")
    private EstoqueProdutoEntity estoqueProduto;

    @Column(name = "quantidade")
    private BigDecimal quantidade;

    @Column(name = "horario_movimentacao")
    private LocalDateTime horarioMovimentacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimentacao_estoque")
    private TipoMovimentacaoEstoque tipoMovimentacaoEstoque;

}
