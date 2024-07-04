package com.vestuario.lori.projsb.DTO;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarVestimentaDTO(@NotNull Long id, String nome, Integer quantidade, Double preco) {
    //são colocados apenas os atributos que queira permitir update
}
