package com.vestuario.lori.projsb.Entities;
import com.vestuario.lori.projsb.DTO.DadosAtualizarVestimentaDTO;
import com.vestuario.lori.projsb.DTO.DadosCadastroVestimentaDTO;
import com.vestuario.lori.projsb.Entities.enums.Categoria;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "vestimenta")
@Table(name = "vestuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vestimenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String marca;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String cor;
    private Integer quantidade;
    private Double preco;
    private Boolean ativo;

    public Vestimenta(DadosCadastroVestimentaDTO dados) {
        this.nome = dados.nome();
        this.marca = dados.marca();
        this.categoria = dados.categoria();
        this.cor = dados.cor();
        this.quantidade = dados.quantidade();
        this.preco = dados.preco();
        this.ativo = true; //sempre que cadastrar uma vestimenta será true (tem no estoque)
    }

    public void atualizarInformacoes(DadosAtualizarVestimentaDTO dados) {
        if (dados.nome() != null){this.nome = dados.nome();}
        if (dados.quantidade() != null){this.quantidade = dados.quantidade();}
        if (dados.preco() != null){this.preco = dados.preco();}
    }

    public void inativar() {
        this.ativo = false;
    }
}