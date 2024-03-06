package br.com.fiap.springpjmotos.resource;

import br.com.fiap.springpjmotos.entity.Acessorio;
import br.com.fiap.springpjmotos.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/acessorio")
public class AcessorioResource {

    @Autowired
    private AcessorioRepository repo;

    @GetMapping
    public List<Acessorio> findAll() {
        return repo.findAll();
    }

    @Transactional
    @PostMapping
    public Acessorio persist(@RequestBody Acessorio acessorio) {
        return repo.save(acessorio);
    }

    @GetMapping(value = "/{id}")
    public Acessorio findAll(@PathVariable("id") Long id){
        var ret = repo.findAll();
        return ret.get();
    }

}
