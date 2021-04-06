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

import br.com.gtasistemas.ordem.model.OrdemServico;
import br.com.gtasistemas.ordem.repository.OrdemServicoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestControllerAdvice
@RequestMapping("/ordens")
@Api (value = "/ordens")
public class OrdemServicoResource {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@ApiOperation(value = "Busca todas as Ordens de Serviço ", notes = "Este Metodo busca todas as Ordens de Serviço do Banco de Dados")
	@GetMapping("todos")
	public List<OrdemServico> listar() {
		return ordemServicoRepository.findAll();
	}
	
	@ApiOperation(value = "Busca pelo Codigo da Ordem de Serviço", notes = "Este Metodo busca a Orden de Serviço do Banco de Dados pelo Codígo")
	@GetMapping("codigo/{codigo}")
	public Optional<OrdemServico> buscarPeloCodigo(@PathVariable Long codigo) {
		return ordemServicoRepository.findById(codigo);

	}
	
	@ApiOperation(value = "Busca pelo nome do Cliente na Ordem de Serviço", notes = "Este Metodo busca a Orden de Serviço do Banco de Dados pelo nome")
	@GetMapping("nome/{nome}")
	public List<OrdemServico> buscarPeloNomeDoCliente(@PathVariable String nome) {
		return ordemServicoRepository.findByPorCliente(nome);

	}
	
	@ApiOperation(value = "Busca pelo nome do Usuário responsavel pela Ordem de Serviço", notes = "Este Metodo busca a Orden de Serviço do Banco de Dados pelo Usuário Responsavel")
	@GetMapping("usuario/{nome}")
	public List<OrdemServico> buscarPeloNomeDoUsuarioResponsavel(@PathVariable String nome) {
		return ordemServicoRepository.findByPorUsuarioResponsavel(nome);

	}

	@ApiOperation(value = "Cria um nova Ordem de Serviço ", notes = "Este Metodo Cria uma nova Orden de Serviço do Banco de Dados")
	@PostMapping
	public ResponseEntity<OrdemServico> criar(@RequestBody OrdemServico agenda, HttpServletResponse response) {
		OrdemServico ordemSalva = ordemServicoRepository.save(agenda);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
			.buildAndExpand(ordemSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(ordemSalva);
	}
	@ApiOperation(value = "Deleta Ordem de Serviço pelo Codigo ", notes = "Este Metodo excluir a Orden de Serviço do Banco de Dados pelo Codígo")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		ordemServicoRepository.deleteById(codigo);
	}
	
	@ApiOperation(value = "Atualizar uma Ordem de Serviço ", notes = "Este Metodo atualiza uma Ordem de Serviço do Banco de Dados")
	@PutMapping
	public ResponseEntity<OrdemServico> SalvarouAtualizar(@RequestBody OrdemServico agenda, HttpServletResponse response) {
		OrdemServico ordemSalva = ordemServicoRepository.save(agenda);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
			.buildAndExpand(ordemSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(ordemSalva);
	}

}
