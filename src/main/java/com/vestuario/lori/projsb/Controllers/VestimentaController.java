package com.vestuario.lori.projsb.Controllers;

import com.vestuario.lori.projsb.DTO.VestimentaDTO;
import com.vestuario.lori.projsb.Entities.Vestimenta;
import com.vestuario.lori.projsb.Repositories.VestimentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Vestuario")
public class VestimentaController {

    @Autowired
    private VestimentaRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody VestimentaDTO dados){
        repository.save(new Vestimenta(dados));
    }
}
