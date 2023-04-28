package com.brqingresso.usuario.dataprovider.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity {

    @EqualsAndHashCode.Include
    @Id
    private String id;

    @Column(nullable = false, unique = true, length = 11)
    String cpf;

    @Column(nullable = false, unique = true, length = 50)
    String email;

    @Column(nullable = false, length = 100)
    String nomeCompleto;

    @Column(nullable = false, length = 100)
    String senha;

    @Column(length = 20)
    String apelido;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate dataNascimento;

    @Column(length = 13)
    Integer celular;

    @Column(nullable = false, length = 2)
    Integer sexo;

    OffsetDateTime dataCadastro;

    OffsetDateTime dataAtualizacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;
}
