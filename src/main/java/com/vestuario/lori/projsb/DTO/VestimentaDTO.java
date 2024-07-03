package com.vestuario.lori.projsb.DTO;
import com.vestuario.lori.projsb.Entities.enums.Categoria;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record VestimentaDTO(
        @NotBlank
        String nome,
        @NotBlank
        String marca,
        @Enumerated
        Categoria categoria,
        @NotBlank
        String cor,
        @Min(0)
        Integer quantidade,
        @Positive
        Double preco) {

}
