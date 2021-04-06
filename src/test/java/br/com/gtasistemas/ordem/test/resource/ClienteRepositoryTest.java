package br.com.gtasistemas.ordem.test.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gtasistemas.ordem.resource.ClienteResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTest {
	@Autowired
	private ClienteResource clienteResource;

	public ClienteRepositoryTest() {
		// TODO Auto-generated constructor stub
	}
	

	@Test
	public void buscarPeloCodigoTest () {
		assertEquals(1, Math.toIntExact(clienteResource.buscarPeloCodigo(1L).get().getCodigo()));

	}
	
	@Test
	public void buscarPeloNomeTest () {
		assertEquals("JOAO CORREIA" , (clienteResource.buscarPeloNome("JOAO CORREIA").get(0).getNome()));

	}
	
	@Test
	public void listaClientesTest () {
		assertEquals((clienteResource.listar()) , (clienteResource.listar()));

	}
	

}
