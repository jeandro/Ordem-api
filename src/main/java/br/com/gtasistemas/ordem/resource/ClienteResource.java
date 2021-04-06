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

import br.com.gtasistemas.ordem.model.Cliente;
import br.com.gtasistemas.ordem.repository.ClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestControllerAdvice
@RequestMapping("/clientes")
@Api(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteRepository clienteRepository;

	@ApiOperation(value = "Busca todos os Clientes ", notes = "Este Metodo busca todos os Clientes no Banco de Dados.")
	@GetMapping("todos")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@ApiOperation(value = "Busca pelo Codigo do Cliente ", notes = "Este Metodo busca o Cliente no Banco de Dados pelo Codígo.")
	@GetMapping("codigo/{codigo}")
	public Optional<Cliente> buscarPeloCodigo(@PathVariable Long codigo) {
		return clienteRepository.findById(codigo);

	}

	@ApiOperation(value = "Busca pelo Nome do Cliente ", notes = "Este Metodo buscao Cliente no Banco de Dados pelo Nome.")
	@GetMapping("nome/{nome}")
	public List<Cliente> buscarPeloNome(@PathVariable String nome) {
		return clienteRepository.findByNome(nome);

	}

	@ApiOperation(value = "Busca pelo e-mail do Cliente ", notes = "Este Metodo busca toda o Cliente no Banco de Dados pelo e-mail.")
	@GetMapping("email/{email}")
	public List<Cliente> buscarPeloEmail(@PathVariable String email) {
		return clienteRepository.findByEmail(email);

	}

	@ApiOperation(value = "Cria um novo Cliente ", notes = "Este Metodo cria um novo Cliente.")
	@PostMapping
	public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente, HttpServletResponse response) {
		Cliente clienteSalva = clienteRepository.save(cliente);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(clienteSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(clienteSalva);
	}

	@ApiOperation(value = "Deleta Cliente pelo Codigo do Cliente ", notes = "Este Metodo Exclui o Cliente do Banco de Dados pelo Codígo.")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		clienteRepository.deleteById(codigo);
	}
    
	@ApiOperation(value = "Atualizar um Cliente ", notes = "Este Metodo Atualiza um Cliente no Banco de Dados.")
	@PutMapping
	public ResponseEntity<Cliente> SalvarouAtualizar(@RequestBody Cliente cliente, HttpServletResponse response) {
		Cliente clienteSalva = clienteRepository.save(cliente);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(clienteSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(clienteSalva);
	}
}
