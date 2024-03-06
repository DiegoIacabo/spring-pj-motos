package br.com.fiap.springpjmotos.repository;

import br.com.fiap.springpjmotos.entity.TipoVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeVeiculoRepository extends JpaRepository<TipoVeiculo, Long> {

}
