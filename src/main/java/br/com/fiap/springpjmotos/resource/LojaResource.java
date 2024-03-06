package br.com.fiap.springpjmotos.resource;

import br.com.fiap.springpjmotos.entity.Loja;
import br.com.fiap.springpjmotos.entity.Veiculo;
import br.com.fiap.springpjmotos.repository.LojaRepository;
import br.com.fiap.springpjmotos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/loja")
public class LojaResource {

    @Autowired
    private LojaRepository repo;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Loja> findAll() {
        return repo.findAll();
    }

    @Transactional
    @PostMapping
    public Loja persist(@RequestBody Loja loja) {
        return repo.save(loja);
    }

    @GetMapping(value = "/{id}")
    public Loja findAll(@PathVariable("id")Long id){
        var ret = repo.findById(id);
        return ret.get();
    }

    @GetMapping(value = "/{idLoja}/veiculos")
    public List<Veiculo> getVeiculo(@PathVariable("idLoja") Long idLoja) {
        return veiculoRepository.findByLojaId(idLoja);
    }

    @Transactional
    @PostMapping(value = "/{idLoja}/veiculos")
    public Veiculo persistVeiculo(@PathVariable("idLoja") Long idLoja, @RequestBody Veiculo veiculo) {
        Loja loja = repo.findById(idLoja).orElseThrow();
        veiculo.setLoja(loja);
        return veiculoRepository.save(veiculo);
    }


}
