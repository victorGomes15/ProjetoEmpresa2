package br.com.contmatic.testes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.Bairro;
import br.com.contmatic.empresa.Cidade;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class CidadeTeste {

	private Cidade cidade;
	private Bairro bairro;

	@BeforeClass
	public static void setUpClass() {

		System.out.println("Começo dos testes da classe " + CidadeTeste.class.getSimpleName() + "\n");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.templates");
	}

	@AfterClass
	public static void tearDownClass() {

		System.out.println("Fim dos testes da classe " + CidadeTeste.class.getSimpleName() + "\n");
	}

	@Before
	public void criar_objeto() {
		cidade = Fixture.from(Cidade.class).gimme("cidadeValida");
		System.out.println("Começo do teste");
	}

	@After
	public void finalizacao_Teste() {
		System.out.println(cidade);
		System.out.println("Fim de teste");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_nome_nulo() {
		cidade.setNome(null);
		Assert.assertNull(cidade.getNome());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_nome_vazio() {
		cidade.setNome("");
		Assert.assertNull(cidade.getNome());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_nome_com_menos_de_3_caracteres() {
		cidade.setNome("It");
		Assert.assertNull(cidade.getNome());
	}

	@Test
	public void deve_aceitar_um_nome_com_mais_de_2_caracteres() {
		cidade.setNome("Itu");
		Assert.assertNotNull(cidade.getNome());
	}

	@Test
	public void printObj() {
		System.out.println(cidade);
	}

	@Test
	public void deve_aceitar_um_bairro_valido() {
		Assert.assertNotNull(cidade.getBairro());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_bairro_invalido() {
		bairro = Fixture.from(Bairro.class).gimme("bairroValido");
		bairro.setCodigo(0);
		bairro.setNomeBairro("sp");
		cidade.setBairro(bairro);
	}

}
