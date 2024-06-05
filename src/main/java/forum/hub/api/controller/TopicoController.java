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

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosRegistrarTopico dados){
        repository.save(new Topico(dados));
        return ResponseEntity.status(HttpStatus.CREATED).body("Tópico criado com sucesso.");
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

}
