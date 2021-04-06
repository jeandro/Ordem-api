package br.com.gtasistemas.ordem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.gtasistemas.ordem.model.Cidade;

public interface CidadeRepository extends JpaRepositoryImplementation<Cidade, Long> {

	@Query(value = "select * from cidade c where c.nome ilike ?1% ORDER BY c.nome", nativeQuery = true)
	List<Cidade> findByCidade(final String p0);

}