package br.com.fiap.springpjmotos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_2TDSPJ_ACESSORIO")
public class Acessorio {

    @Id
    @Column(name = "ID_ACESSORIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACESSORIO")
    @SequenceGenerator(name = "SQ_ACESSORIO", sequenceName = "SQ_ACESSORIO",
            initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NM_ACESSORIO")
    private String nome;

    @Column(name = "PR_ACESSORIO")
    private Double preco;
}
