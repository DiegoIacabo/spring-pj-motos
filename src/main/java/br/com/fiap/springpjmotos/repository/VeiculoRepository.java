package br.com.fiap.springpjmotos.repository;

import br.com.fiap.springpjmotos.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByLojaId(Long idLoja);

}
