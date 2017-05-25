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

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void nao_deve_aceitar_um_codigo_igual_0() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Código inserido menor ou igual a 0");
		bairro.setCodigo(0);
	}

	@Test
	public void nao_deve_aceitar_um_codigo_negativo() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Código inserido menor ou igual a 0");
		bairro.setCodigo(-1);
	}

	@Test
	public void deve_aceitar_um_codigo_maior_que_0() {
		Bairro bairro2 = Fixture.from(Bairro.class).gimme("bairroValido");
		Assert.assertNotNull(bairro2.getCodigo());
	}

	@Test
	public void nao_deve_aceitar_um_bairro_nulo() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Nome de bairro incorreto");
		bairro.setNomeBairro(null);
	}

	@Test
	public void nao_deve_aceitar_um_bairro_vazio() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Nome de bairro incorreto");
		bairro.setNomeBairro("");
	}

	@Test
	public void nao_deve_aceitar_um_bairro_menor_que_4_caracteres() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Nome de bairro incorreto");
		bairro.setNomeBairro("123");
	}

	@Test
	public void deve_aceitar_um_cep_valido() {
		Assert.assertNotNull(bairro.getCep());
	}

	@Test
	public void nao_deve_aceitar_um_cep_que_contenha_letras() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Cep inválido");
		bairro.setCep("05857-38ç");
	}

	@Test
	public void nao_deve_aceitar_um_cep_que_contenha_caracteres_Especiais() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Cep inválido");
		bairro.setCep("12345-17@");
	}

	@Test
	public void nao_deve_aceitar_um_cep_que_nulo() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Cep inválido");
		bairro.setCep(null);
	}

	@Test
	public void nao_deve_aceitar_um_cep_que_esteja_vazio() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Cep inválido");
		bairro.setCep("");
	}
}
