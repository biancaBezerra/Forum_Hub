package forum.hub.api.controller;

import forum.hub.api.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosRegistrarTopico dados, UriComponentsBuilder uriBuilder){
        var topico = new Topico(dados);
        repository.save(topico);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public Page<DadosListagemTopicos> listar(
            @PageableDefault(size = 10, sort = {"data"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemTopicos::new);
    }

    @GetMapping("/{id}")
    //Devolve método HTTP mais apropriado - COD 200
    public ResponseEntity detalhar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping
    @Transactional
    //Devolve método HTTP mais apropriado - COD 200
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados){
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    //Devolve método HTTP mais apropriado - COD 204
    public ResponseEntity excluir(@PathVariable Long id){
        Optional<Topico> topicoOptional = repository.findById(id);
        topicoOptional.ifPresent(topico -> repository.deleteById(id));

        return topicoOptional.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
