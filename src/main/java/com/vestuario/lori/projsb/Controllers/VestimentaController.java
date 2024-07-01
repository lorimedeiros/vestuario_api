package com.vestuario.lori.projsb.Controllers;

import com.vestuario.lori.projsb.DTO.VestimentaDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vestuario")
public class VestimentaController {

    @PostMapping
    public void cadastrar(@RequestBody VestimentaDTO dados){
        System.out.println(dados);
    }
}
