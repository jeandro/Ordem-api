package br.com.gtasistemas.ordem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gtasistemas.ordem.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	@Query(value = "select * from usuario u where u.login ilike ?1% ORDER BY u.login", nativeQuery = true)
	List<Usuario> findByLogin(final String p0);
	
	@Query(value = "select * from usuario u where u.nome ilike ?1% ORDER BY u.nome", nativeQuery = true)
	List<Usuario> findByNome(final String p0);
	
	@Query(value = "select * from usuario u where u.email ilike ?1% ORDER BY u.email", nativeQuery = true)
	List<Usuario> findByEmail(final String p0);
	
	@Query(value = "select * from usuario u where u.celular ilike ?1% ORDER BY u.celular", nativeQuery = true)
	List<Usuario> findByCelular(final String p0);



	
	

}
