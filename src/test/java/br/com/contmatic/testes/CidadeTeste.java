package br.com.contmatic.testes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void nao_deve_aceitar_um_nome_nulo() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Nome da cidade invalido");
		cidade.setNome(null);
	}

	@Test
	public void nao_deve_aceitar_um_nome_vazio() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Nome da cidade invalido");
		cidade.setNome("");
	}

	@Test
	public void nao_deve_aceitar_um_nome_com_menos_de_3_caracteres() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Nome da cidade invalido");
		cidade.setNome("It");
	}

	@Test
	public void deve_aceitar_um_nome_com_mais_de_2_caracteres() {
		cidade.setNome("Itu");
	}

	@Test
	public void printObj() {
		System.out.println(cidade);
	}

	@Test
	public void deve_aceitar_um_bairro_valido() {
		Assert.assertNotNull(cidade.getBairro());
	}

	@Test
	public void nao_deve_aceitar_um_bairro_invalido() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		bairro = Fixture.from(Bairro.class).gimme("bairroValido");
		bairro.setCodigo(0);
		bairro.setNomeBairro("sp");
		cidade.setBairro(bairro);
	}

}
