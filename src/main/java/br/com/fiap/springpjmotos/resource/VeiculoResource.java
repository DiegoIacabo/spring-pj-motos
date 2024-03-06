package br.com.fiap.springpjmotos.resource;

import br.com.fiap.springpjmotos.entity.Acessorio;
import br.com.fiap.springpjmotos.entity.Veiculo;
import br.com.fiap.springpjmotos.repository.AcessorioRepository;
import br.com.fiap.springpjmotos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {

    @Autowired
    private VeiculoRepository repo;

    @Autowired
    private AcessorioRepository acessorioRepository;

    @GetMapping
    public List<Veiculo> findAll() {
        return repo.findAll();
    }

    @Transactional
    @PostMapping
    public Veiculo persist(@RequestBody Veiculo veiculo) {
        return repo.save(veiculo);
    }

    @GetMapping(value = "/{id}")
    public Veiculo findAll(@PathVariable("id") Long id) {
        var ret = repo.findById(id);
        return ret.get();
    }

    @GetMapping(value = "/{idVeiculo}/acessorios")
    public List<Acessorio> getAcessorio(@PathVariable("idVeiculo") Long idVeiculo) {
        return acessorioRepository.findByVeiculoId(idVeiculo);
    }

    @Transactional
    @PostMapping(value = "/{idVeiculo}/acessorios")
    public Acessorio persistAcessorio(@PathVariable("idVeiculo") Long idVeiculo, @RequestBody Acessorio acessorio) {
        Veiculo veiculo = repo.findById(idVeiculo).orElseThrow();
        acessorio.setVeiculo(veiculo);
        return acessorioRepository.save(acessorio);
    }




}
