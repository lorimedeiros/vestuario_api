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

    @GetMapping("estoquegeral")
    public List<DadosListagemVestimentaDTO> listarTodos(){
        return repository.findAll().stream().map(DadosListagemVestimentaDTO::new).toList();
    }

    @GetMapping("estoqueativo")
    public List<DadosListagemVestimentaDTO> listarAtivos(){
        return repository.findAllByAtivoTrue().stream().map(DadosListagemVestimentaDTO::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarVestimentaDTO dados){
        var vest = repository.getReferenceById(dados.id());
        vest.atualizarInformacoes(dados);
    }

    @PutMapping("ativar/{id}")
    @Transactional
    public void ativar(@PathVariable Long id){
        var vest = repository.getReferenceById(id);
        vest.ativar();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public void inativar(@PathVariable Long id){
        var vest = repository.getReferenceById(id);
        vest.inativar();
    }
}
