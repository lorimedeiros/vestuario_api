package com.vestuario.lori.projsb.DTO;

import com.vestuario.lori.projsb.Entities.Vestimenta;
import com.vestuario.lori.projsb.Entities.enums.Categoria;

public record DadosListagemVestimentaDTO(Long id, String nome, String marca, Categoria categotia, String cor) {

        public DadosListagemVestimentaDTO(Vestimenta vestimenta){
                this(vestimenta.getId(), vestimenta.getNome(), vestimenta.getMarca(), vestimenta.getCategoria(), vestimenta.getCor());
        }
}
