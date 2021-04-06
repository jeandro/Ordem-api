package br.com.gtasistemas.ordem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.gtasistemas.ordem.model.OrdemServico;

public interface OrdemServicoRepository extends JpaRepositoryImplementation<OrdemServico, Long> {
	@Query(value = "select * from usuario as u, ordem_servico as o, cliente as c \r\n"
			+ "where o.idusuarioordem = u.codigo and \r\n" + "c.codigo  = o.idcliente and \r\n"
			+ "c.nome ilike ?1%", nativeQuery = true)
	List<OrdemServico> findByPorCliente(final String p0);

	@Query(value = "select * from usuario as u, ordem_servico as o, cliente as c \r\n"
			+ "where o.idusuarioordem = u.codigo and \r\n" + "c.codigo  = o.idcliente and \r\n"
			+ "u.nome ilike ?1%", nativeQuery = true)
	List<OrdemServico> findByPorUsuarioResponsavel(final String p0);

}
