package br.com.gtasistemas.ordem.test.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gtasistemas.ordem.resource.UsuarioResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioResourceTest {
	
	@Autowired
	private UsuarioResource usuarioresource;

	public UsuarioResourceTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void buscarPeloCodigoTest () {
		assertEquals(2, Math.toIntExact(usuarioresource.buscarPeloCodigo(2L).get().getCodigo()));

	}
	
	@Test
	public void buscarPeloNomeTest () {
		assertEquals("BRUNA" , (usuarioresource.buscarPelonome("BRUNA").get(0).getNome()));

	}
	
	@Test
	public void listaClientesTest () {
		assertEquals((usuarioresource.listar()) , (usuarioresource.listar()));

	}
	
	@Test
	public void buscarPelologinTest () {
		assertEquals("JOSE" , (usuarioresource.buscarPelologin("JOSE").get(0).getLogin()));

	}
	

}
