package br.com.fiap.springpjmotos.resource;

import br.com.fiap.springpjmotos.entity.TipoVeiculo;
import br.com.fiap.springpjmotos.repository.TipoDeVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tipo-de-veiculo")
public class TipoVeiculoResource {

    @Autowired
    private TipoDeVeiculoRepository repo;

    @GetMapping
    public List<TipoVeiculo> findAll(){
        return repo.findAll();
    }

    @Transactional
    @PostMapping
    public TipoVeiculo persist(@RequestBody TipoVeiculo tipoVeiculo){
        return repo.save(tipoVeiculo);
    }

    @GetMapping(value = "/{id}")
    public TipoVeiculo findAll(@PathVariable("id")Long id) {
        var ret = repo.findById(id);
        return ret.get();
    }
}
