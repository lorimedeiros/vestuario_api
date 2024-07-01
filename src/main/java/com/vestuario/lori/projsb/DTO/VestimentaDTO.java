package com.vestuario.lori.projsb.DTO;
import com.vestuario.lori.projsb.Entities.enums.Categoria;

public record VestimentaDTO(String nome,
                            String marca,
                            Categoria categoria,
                            String cor,
                            Integer quantidade,
                            Double preco) {

}
