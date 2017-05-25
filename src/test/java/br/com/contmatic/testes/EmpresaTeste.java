package br.com.contmatic.testes;

import java.text.ParseException;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.GerenciadorEnderecos;
import br.com.contmatic.empresa.GerenciadorTelefone;
import br.com.contmatic.empresa.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTeste {

	private Empresa empresa;
	private Telefone telefone;
	private Endereco endereco;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Começo dos testes da classe " + EmpresaTeste.class.getSimpleName() + "\n");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.templates");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fim dos testes da classe" + EmpresaTeste.class.getSimpleName() + "\n");

	}

	@Before
	public void criarObj() {
		System.out.println("Começo do teste");
		empresa = Fixture.from(Empresa.class).gimme("empresaValida");
	}

	@After
	public void finalizacao_Teste() {
		System.out.println("Fim de teste");
	}

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void deve_aceitar_um_cnpj_valido_de_14_digitos() {
		empresa.setCnpj("12345678901234");
		Assert.assertNotNull(empresa.getCnpj());
	}

	@Test
	public void deve_aceitar_um_endereco_valido() {
		endereco = Fixture.from(Endereco.class).gimme("enderecoValido");
		GerenciadorEnderecos gerenEndereco = new GerenciadorEnderecos();

		gerenEndereco.adcEndereco(endereco);
		empresa.setEndereco(gerenEndereco.getListaEndereco());
		Assert.assertNotNull(empresa.getEndereco());
	}

	@Test
	public void nao_deve_aceitar_um_cnpj_menor_14_caracteres() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setCnpj("1234567890123");
	}

	@Test
	public void nao_deve_aceitar_um_cnpj_maior_14_caracteres() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setCnpj("123456789012345");
	}

	@Test
	public void nao_deve_aceitar_um_cnpj_nulo() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setCnpj(null);
	}

	@Test
	public void nao_deve_aceitar_um_cnpj_vazio() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setCnpj("");
	}

	@Test
	public void nao_deve_aceitar_um_cnpj_com_letras() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setCnpj("12345678901234l");
	}

	public void nao_deve_aceitar_um_dono_nulo() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setDono(null);
	}

	@Test
	public void nao_deve_aceitar_um_dono_vazio() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setDono("");
	}

	@Test
	public void nao_deve_aceitar_um_dono_com_menos_de_4_caracteres() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setDono("Jos");
	}

	@Test
	public void nao_deve_aceitar_um_dono_com_numeros() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setDono("Jose5");
	}

	@Test
	public void nao_deve_aceitar_uma_inscricao_estadual_nula() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setInscricaoEstadual(null);
	}

	@Test
	public void nao_deve_aceitar_uma_inscricao_estadual_vazia() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setInscricaoEstadual("");
	}

	@Test
	public void deve_aceitar_uma_inscricao_com_13_caracteres() {
		empresa.setInscricaoEstadual("1234567891023");
		Assert.assertNotNull(empresa.getInscricaoEstadual());
	}

	@Test
	public void nao_deve_aceitar_uma_inscricao_maior_que_13_caracteres() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setInscricaoEstadual("12345678910234");
	}

	@Test
	public void nao_deve_aceitar_uma_inscricao_estadual_menor_que_13_caracteres() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setInscricaoEstadual("123456789012");
	}

	@Test
	public void nao_deve_aceitar_uma_inscricao_estadual_com_letras() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setInscricaoEstadual("123456789102l");
	}

	@Test(timeout = 100)
	public void deve_aceitar_telefone_valido() {
		telefone = Fixture.from(Telefone.class).gimme("telefoneValido");
		GerenciadorTelefone telef = new GerenciadorTelefone();

		telef.addTelefone(telefone);

		empresa.setTelefone(telef.getListaNumeros());
		Assert.assertNotNull(empresa.getTelefone());
	}

	@Test
	public void nao_deve_aceitar_uma_razaoSocial_nula() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setRazaoSocial(null);
	}

	@Test
	public void nao_deve_aceitar_uma_razaoSocial_com_caracteres_especiais() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setRazaoSocial("luis@");
	}

	@Test
	public void nao_deve_aceitar_um_nome_de_empresa_nulo() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setRazaoSocial(null);
	}

	@Test
	public void nao_deve_aceitar_um_nome_de_empresa_vazia() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setRazaoSocial("");
	}

	@Test
	public void deve_aceitar_uma_data_de_criacao() throws ParseException {
		empresa.setDataCriacao(DateTime.now().plusDays(1));
	}

	@Test
	public void nao_deve_aceitar_uma_data_de_criacao_invalida() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("");
		empresa.setDataCriacao(DateTime.now().minusHours(1));
	}

	@Test
	public void deve_printar_o_objeto_de_empresa() {
		System.out.println(empresa);
	}
}
