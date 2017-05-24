package br.com.contmatic.testes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.Bairro;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class BairroTeste {

	private Bairro bairro;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Começo testes da classe " + BairroTeste.class.getSimpleName() + "\n");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.templates");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fim dos testes da classe " + BairroTeste.class.getSimpleName() + "\n");
	}

	@Before
	public void criaObjt() {
		bairro = Fixture.from(Bairro.class).gimme("bairroValido");
		System.out.println("Começo de teste");
	}

	@After
	public void finalizacao_Teste() {
		System.out.println(bairro);
		System.out.println("Fim de teste");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_codigo_igual_0() {
		bairro.setCodigo(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_codigo_negativo() {
		bairro.setCodigo(-1);
	}

	@Test
	public void deve_aceitar_um_codigo_maior_que_0() {
		Bairro bairro2 = Fixture.from(Bairro.class).gimme("bairroValido");
		Assert.assertNotNull(bairro2.getCodigo());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_bairro_nulo() {
		bairro.setNomeBairro(null);
		Assert.assertNull(bairro.getNomeBairro());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_bairro_vazio() {
		bairro.setNomeBairro("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_bairro_menor_que_4_caracteres() {
		bairro.setNomeBairro("123");
	}

	@Test
	public void deve_aceitar_um_cep_valido() {
		Assert.assertNotNull(bairro.getCep());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_cep_que_contenha_letras() {
		bairro.setCep("05857-38ç");
		Assert.assertNull(bairro.getCep());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_cep_que_contenha_caracteres_Especiais() {
		bairro.setCep("12345-17@");
		Assert.assertNull(bairro.getCep());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_cep_que_nulo() {
		bairro.setCep(null);
		Assert.assertEquals(null, bairro.getCep());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_cep_que_esteja_vazio() {
		bairro.setCep("");
		Assert.assertNull(bairro.getCep());
	}
}
