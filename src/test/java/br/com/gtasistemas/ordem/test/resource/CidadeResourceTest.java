package br.com.gtasistemas.ordem.test.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gtasistemas.ordem.resource.CidadeResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CidadeResourceTest {
	@Autowired
	private CidadeResource cidadeResorce;

	public CidadeResourceTest() {
		// TODO Auto-generated constructor stub

	}

	@Test
	public void buscarPeloCodigoTest () {
		assertEquals(1, Math.toIntExact(cidadeResorce.buscarPeloCodigo(1L).get().getCodigo()));

	}
	
	@Test
	public void buscarPeloNomeTest () {
		assertEquals("PONTALINA" , (cidadeResorce.Cidade("PONTALINA").get(0).getNome()));

	}
	
	@Test
	public void listaCidadesTest () {
		assertEquals((cidadeResorce.listar()) , (cidadeResorce.listar()));

	}
	
	
	
	
}