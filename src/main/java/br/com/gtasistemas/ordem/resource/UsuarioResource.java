package br.com.gtasistemas.ordem.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gtasistemas.ordem.model.Usuario;
import br.com.gtasistemas.ordem.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestControllerAdvice
@RequestMapping("/usuarios")
@Api(value = "/usuarios")
public class UsuarioResource {
	


	@Autowired
	private UsuarioRepository usuarioRepository;
	
	

	@ApiOperation(value = "Busca todos os Usuários ", notes = "Este Metodo busca todos os Usuários do Banco de Dados")
	@GetMapping("todos")
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@ApiOperation(value = "Busca pelo Codigo do Usuário ", notes = "Este Metodo busca os Usuários do Banco de Dados pelo Codígo")
	@GetMapping("codigo/{codigo}")
	public Optional<Usuario> buscarPeloCodigo(@PathVariable Long codigo) {
		return usuarioRepository.findById(codigo);

	}

	@ApiOperation(value = "Busca pelo Login do Usuário ", notes = "Este Metodo busca os Usuários do Banco de Dados pelo Login")
	@GetMapping("login/{login}")
	public List<Usuario> buscarPelologin(@PathVariable String login) {
		return usuarioRepository.findByLogin(login);

	}

	@ApiOperation(value = "Busca pelo Nome do Usuário ", notes = "Este Metodo busca os Usuários do Banco de Dados pelo Nome")
	@GetMapping("nome/{nome}")
	public List<Usuario> buscarPelonome(@PathVariable String nome) {
		return usuarioRepository.findByNome(nome);

	}

	@ApiOperation(value = "Busca pelo Email do Usuário ", notes = "Este Metodo busca os Usuários do Banco de Dados pelo e-mail")
	@GetMapping("email/{email}")
	public List<Usuario> buscarPeloemail(@PathVariable String email) {
		return usuarioRepository.findByEmail(email);

	}

	@ApiOperation(value = "Busca pelo Celular do Usuário ", notes = "Este Metodo busca os Usuários do Banco de Dados pelo Celular")
	@GetMapping("celular/{celular}")
	public List<Usuario> buscarPeloCelular(@PathVariable String celular) {
		return usuarioRepository.findByCelular(celular);

	}

	@ApiOperation(value = "Cria um novo Usuário ", notes = "Este Metodo cria um novo Usuário no Banco de Dados")
	@PostMapping
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalva = usuarioRepository.save(usuario);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(usuarioSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(usuarioSalva);
	}

	@ApiOperation(value = "Deleta Usuário pelo Codigo do Usuário ", notes = "Este Metodo Deleta um Usuário do Banco de Dados pelo Codígo")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		usuarioRepository.deleteById(codigo);
	}
	
    @ApiOperation(value = "Atualizar um Usuário ", notes = "Este Metodo Atualiza o Usuário do Banco de Dados")
	@PutMapping
	public ResponseEntity<Usuario> SalvarouAtualizar(@RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalva = usuarioRepository.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(usuarioSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(usuarioSalva);
	}

}
