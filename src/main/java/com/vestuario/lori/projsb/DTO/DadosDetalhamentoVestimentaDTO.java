package com.vestuario.lori.projsb.DTO;

import com.vestuario.lori.projsb.Entities.Vestimenta;
import com.vestuario.lori.projsb.Entities.enums.Categoria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record DadosDetalhamentoVestimentaDTO(
        Long id,
        String nome,
        String marca,
        Categoria categoria,
        String cor,
        Integer quantidade,
        Double preco,
        Boolean ativo) {

    public DadosDetalhamentoVestimentaDTO(Vestimenta vestimenta){
        this(
                vestimenta.getId(),
                vestimenta.getNome(),
                vestimenta.getMarca(),
                vestimenta.getCategoria(),
                vestimenta.getCor(),
                vestimenta.getQuantidade(),
                vestimenta.getPreco(),
                vestimenta.getAtivo());
    }

}
