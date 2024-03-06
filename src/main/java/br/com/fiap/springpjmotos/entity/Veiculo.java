package br.com.fiap.springpjmotos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_2TDSPJ_VEICULO")
public class Veiculo {

    @Id
    @Column(name = "ID_VEICULO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VEICULO")
    @SequenceGenerator(name = "SQ_VEICULO", sequenceName = "SQ_VEICULO",
        initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NM_VEICULO")
    private String nome;

    @Column(name = "COR_VEICULO")
    private String cor;

    @Column(name = "PR_VEICULO")
    private Double preco;

    @Column(name = "CL_VEICULO")
    private Short cilindradas;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "TIPO_ID",
            referencedColumnName = "ID_TIPO_VEICULO",
            foreignKey = @ForeignKey(name = "FK_TIPO_VEICULO")
    )
    private Set<TipoVeiculo> tipo = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_ACESSORIO_VEICULO",
            joinColumns = {
                    @JoinColumn(
                            name = "VEICULO",
                            referencedColumnName = "ID_VEICULO",
                            foreignKey = @ForeignKey(name = "FK_VEICULO_ACESSORIO")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ACESSORIO",
                            referencedColumnName = "ID_ACESSORIO",
                            foreignKey = @ForeignKey(name = "FK_ACESSORIO_VEICULO")
                    )
            }
    )
    private Set<Acessorio> acessorios = new LinkedHashSet<>();
}
