package com.vestuario.lori.projsb.Entities;
import com.vestuario.lori.projsb.DTO.VestimentaDTO;
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

    public Vestimenta(VestimentaDTO dados) {
        this.nome = dados.nome();
        this.marca = dados.marca();
        this.categoria = dados.categoria();
        this.cor = dados.cor();
        this.quantidade = dados.quantidade();
        this.preco = dados.preco();
    }
}