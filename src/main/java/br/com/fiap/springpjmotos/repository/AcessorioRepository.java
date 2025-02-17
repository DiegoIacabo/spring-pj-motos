package br.com.fiap.springpjmotos.repository;

import br.com.fiap.springpjmotos.entity.Acessorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {

    List<Acessorio> findByVeiculoId(Long idVeiculo);

}
