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

import br.com.gtasistemas.ordem.model.Cidade;
import br.com.gtasistemas.ordem.repository.CidadeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestControllerAdvice
@RequestMapping("/cidades")
@Api(value = "/cidades")
public class CidadeResource {

	@Autowired
	private CidadeRepository cidadeRepository;

	@ApiOperation(value = "Busca todas as Cidades ", notes = "Este Metodo busca todas as Cidades no Banco de Dados.")
	@GetMapping("todos")
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}

	@ApiOperation(value = "Busca pelo Codigo da Cidade", notes = "Este Metodo busca Cidades no Banco de Dados pelo Codígo.")
	@GetMapping("codigo/{codigo}")
	public Optional<Cidade> buscarPeloCodigo(@PathVariable Long codigo) {
		return cidadeRepository.findById(codigo);

	}

	@ApiOperation(value = "Busca pelo Nome da Cidade ", notes = "Este Metodo busca Cidades no Banco de Dados pelo nome.")
	@GetMapping({ "cidade/{cidade}" })
	public List<Cidade> Cidade(@PathVariable final String Cidade) {
		return (List<Cidade>) this.cidadeRepository.findByCidade(Cidade);
	}

	@ApiOperation(value = "Cria uma nova Cidade ", notes = "Este Metodo cria uma Cidade no Banco de Dados.")
	@PostMapping
	public ResponseEntity<Cidade> criar(@RequestBody Cidade cidade, HttpServletResponse response) {
		Cidade cidadeSalva = cidadeRepository.save(cidade);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(cidadeSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(cidadeSalva);
	}

	@ApiOperation(value = "Deleta Cidade pelo Codigo do Cidade" , notes = "Este Metodo exclui a Cidade do Banco de Dados.")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		cidadeRepository.deleteById(codigo);
	}
	
	@ApiOperation(value = "Atualizar uma Cidade ", notes = "Este Metodo atualiza a Cidade no Banco de Dados.")
	@PutMapping
	public ResponseEntity<Cidade> SalvarouAtualizar(@RequestBody Cidade cidade, HttpServletResponse response) {
		Cidade cidadeSalva = cidadeRepository.save(cidade);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(cidadeSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(cidadeSalva);
	}

}
