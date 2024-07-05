package com.vestuario.lori.projsb.Controllers;
import com.vestuario.lori.projsb.DTO.DadosAtualizarVestimentaDTO;
import com.vestuario.lori.projsb.DTO.DadosCadastroVestimentaDTO;
import com.vestuario.lori.projsb.DTO.DadosListagemVestimentaDTO;
import com.vestuario.lori.projsb.Entities.Vestimenta;
import com.vestuario.lori.projsb.Repositories.VestimentaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/vestuario")
public class VestimentaController {

    @Autowired
    private VestimentaRepository repository;

    @PostMapping
    @Transactional //
    public ResponseEntity<DadosDetalhamentoVestimentaDTO> cadastrar(@RequestBody @Valid DadosCadastroVestimentaDTO dados, UriComponentsBuilder uriBuilder){
        var vest = new Vestimenta(dados); //variavel recebendo nova vestimenta instanciada tendo como parametro os dados recebidos no corpo da rqeuisição
        repository.save(vest); //salvando vestimenta na db

        var uri = uriBuilder.path("/vestuario/{id}").buildAndExpand(vest.getId()).toUri(); //variavel que armazena o caminho da vestimenta criada com id

        return ResponseEntity.created(uri).body(new DadosDetalhamentoVestimentaDTO(vest)); //retorno do response entity + url + dto da vestimenta criada
    }

    @GetMapping("estoquegeral")
    public ResponseEntity<List<DadosListagemVestimentaDTO>> listarTodos(){
        var lista =  repository.findAll().stream().map(DadosListagemVestimentaDTO::new).toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("estoqueativo")
    public ResponseEntity<List<DadosListagemVestimentaDTO>> listarAtivos(){
        var lista =  repository.findAllByAtivoTrue().stream().map(DadosListagemVestimentaDTO::new).toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoVestimentaDTO> atualizar(@RequestBody @Valid DadosAtualizarVestimentaDTO dados){
        var vest = repository.getReferenceById(dados.id());
        vest.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoVestimentaDTO(vest));
    }

    @PutMapping("ativar/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoVestimentaDTO> ativar(@PathVariable Long id){
        var vest = repository.getReferenceById(id);
        vest.ativar();

        return ResponseEntity.ok(new DadosDetalhamentoVestimentaDTO(vest));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id){
        var vest = repository.getReferenceById(id);
        vest.inativar();

        return ResponseEntity.noContent().build();
    }
}
