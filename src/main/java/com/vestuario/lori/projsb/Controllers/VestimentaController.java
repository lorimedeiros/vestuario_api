package com.vestuario.lori.projsb.Controllers;

import com.vestuario.lori.projsb.DTO.DadosAtualizarVestimentaDTO;
import com.vestuario.lori.projsb.DTO.DadosCadastroVestimentaDTO;
import com.vestuario.lori.projsb.DTO.DadosListagemVestimentaDTO;
import com.vestuario.lori.projsb.Entities.Vestimenta;
import com.vestuario.lori.projsb.Repositories.VestimentaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vestuario")
public class VestimentaController {

    @Autowired
    private VestimentaRepository repository;

    @PostMapping
    @Transactional //
    public void cadastrar(@RequestBody @Valid DadosCadastroVestimentaDTO dados){
        repository.save(new Vestimenta(dados));
    }

    @GetMapping
    public List<DadosListagemVestimentaDTO> listar(){
        return repository.findAll().stream().map(DadosListagemVestimentaDTO::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarVestimentaDTO dados){
        var vest = repository.getReferenceById(dados.id());
        vest.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
