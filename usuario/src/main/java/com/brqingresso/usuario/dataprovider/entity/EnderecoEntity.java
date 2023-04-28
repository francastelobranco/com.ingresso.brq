package com.brqingresso.usuario.dataprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    String logradouro;

    @Column(length = 10)
    String numero;

    @Column(length = 20)
    String bairro;

    @Column(length = 20)
    String cidade;

    @Column(length = 2)
    String estado;

    @Column(length = 3)
    String pais;

    @Column(length = 8)
    String cep;

}
