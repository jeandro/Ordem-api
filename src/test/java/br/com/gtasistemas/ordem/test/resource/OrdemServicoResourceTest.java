package br.com.gtasistemas.ordem.test.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gtasistemas.ordem.resource.OrdemServicoResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdemServicoResourceTest {
	
	@Autowired
	private OrdemServicoResource ordemservicoresource;

	public OrdemServicoResourceTest() {
		// TODO Auto-generated constructor stub
	}
	

	@Test
	public void buscarPeloCodigoTest () {
		assertEquals(1, Math.toIntExact(ordemservicoresource.buscarPeloCodigo(1L).get().getCodigo()));

	}
	
	@Test
	public void buscarPeloNomeDoClienteTest () {
		assertEquals("JOAO CORREIA" , (ordemservicoresource.buscarPeloNomeDoCliente("JOAO CORREIA").get(0).getClienteordem().getNome()));

	}
	
	@Test
	public void listaClientesTest () {
		assertEquals((ordemservicoresource.listar()) , (ordemservicoresource.listar()));

	}
	
	@Test
	public void buscarPeloNomeDoUsuarioResponsavelTest () {
		assertEquals(3 , 
				(ordemservicoresource.buscarPeloNomeDoUsuarioResponsavel("JUCA ALVES CORREIA").get(0).getUsuario_ordem_servico().getCodigo().byteValue()));

	}
	

}
