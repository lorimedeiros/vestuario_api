package com.vestuario.lori.projsb.Entities;
import com.vestuario.lori.projsb.DTO.VestimentaDTO;
import com.vestuario.lori.projsb.Entities.enums.Categoria;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Vestimenta") // especificando que é uma entidade && o nome da entidade
@Table(name = "Vestuário") // especificando nome da tabela
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
// as 5 linhas acima correspondem a como automatizar a criação de gets, sets, contrutor com e sem argumentos e o equals e hashcode tendo como critério o atributo "id" usando a dependency lombok
public class Vestimenta {

    @Id // especificando que esse atributo é o id do obj (chave primária)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // será um valor gerado pelo próprio banco de dados
    private Long id;
    private String nome;
    private String marca;
    @Enumerated(EnumType.STRING) // especificando que esse atributo é um enum && que é do tipo String
    private Categoria categoria;
    private String cor;
    private Integer quantidade;
    private Double preco;

    public Vestimenta(VestimentaDTO dados) { //esse construtor foi criado para ser usado no controller (operação de cadastrar nova vestimenta)
        this.nome = dados.nome();
        this.marca = dados.marca();
        this.categoria = dados.categoria();
        this.cor = dados.cor();
        this.quantidade = dados.quantidade();
        this.preco = dados.preco();
    }
}