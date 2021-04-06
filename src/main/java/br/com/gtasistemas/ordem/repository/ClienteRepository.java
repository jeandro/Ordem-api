package br.com.gtasistemas.ordem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.gtasistemas.ordem.model.Cliente;

public interface ClienteRepository extends JpaRepositoryImplementation<Cliente, Long> {
	@Query(value = "select * from cliente c where c.nome ilike ?1% ORDER BY c.nome", nativeQuery = true)
	List<Cliente> findByNome(final String p0);
	
	@Query(value = "select * from cliente c where c.cpf ilike ?1% ORDER BY c.cpf", nativeQuery = true)
	List<Cliente> findByCpf(final String p0);
	
	@Query(value = "select * from cliente c where c.celular ilike ?1% ORDER BY c.celular", nativeQuery = true)
	List<Cliente> findByCelular(final String p0);
	
	@Query(value = "select * from cliente c where c.email ilike ?1% ORDER BY c.email", nativeQuery = true)
	List<Cliente> findByEmail(final String p0);

}
