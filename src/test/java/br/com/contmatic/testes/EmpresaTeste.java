package br.com.contmatic.testes;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
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
		System.out.println("ComeÃ§o dos testes da classe " + EmpresaTeste.class.getSimpleName() + "\n");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.templates");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fim dos testes da classe" + EmpresaTeste.class.getSimpleName() + "\n");

	}

	@Before
	public void criarObj() {
		System.out.println("ComeÃ§o do teste");
		empresa = Fixture.from(Empresa.class).gimme("empresaValida");
	}

	@After
	public void finalizacao_Teste() {
		System.out.println("Fim de teste");
	}

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

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_cnpj_menor_14_caracteres() {
		empresa.setCnpj("1234567890123");
		Assert.assertNull(empresa.getCnpj());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_cnpj_maior_14_caracteres() {
		empresa.setCnpj("123456789012345");
		Assert.assertNull(empresa.getCnpj());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_cnpj_nulo() {
		empresa.setCnpj(null);
		Assert.assertNull(empresa.getCnpj());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_cnpj_vazio() {
		empresa.setCnpj("");
		Assert.assertNull(empresa.getCnpj());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_cnpj_com_letras() {
		empresa.setCnpj("12345678901234l");
		Assert.assertNull(empresa.getCnpj());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_dono_nulo() {
		empresa.setDono(null);
		Assert.assertNull(empresa.getDono());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_dono_vazio() {
		empresa.setDono("");
		Assert.assertNull(empresa.getDono());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_dono_com_menos_de_4_caracteres() {
		empresa.setDono("Jos");
		Assert.assertNull(empresa.getDono());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_dono_com_numeros() {
		empresa.setDono("Jose5");
		Assert.assertNull(empresa.getDono());
	}

	@Test
	public void nao_deve_aceitar_uma_inscricaoo_estadual_nula() {
		empresa.setInscricaoEstadual(null);
		Assert.assertNull(empresa.getInscricaoEstadual());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_uma_inscricao_estadual_vazia() {
		empresa.setInscricaoEstadual("");
		Assert.assertNull(empresa.getInscricaoEstadual());
	}

	@Test
	public void deve_aceitar_uma_inscricao_com_13_caracteres() {
		empresa.setInscricaoEstadual("1234567891023");
		Assert.assertNotNull(empresa.getInscricaoEstadual());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_uma_inscricao_maior_que_13_caracteres() {
		empresa.setInscricaoEstadual("12345678910234");
		Assert.assertNull(empresa.getInscricaoEstadual());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_uma_inscricao_estadual_menor_que_13_caracteres() {
		empresa.setInscricaoEstadual("123456789012");
		Assert.assertNull(empresa.getInscricaoEstadual());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_uma_inscricao_estadual_com_letras() {
		empresa.setInscricaoEstadual("123456789102l");
		Assert.assertNull(empresa.getInscricaoEstadual());
	}

	@Test(timeout = 100)
	public void deve_aceitar_telefone_valido() {
		telefone = Fixture.from(Telefone.class).gimme("telefoneValido");
		GerenciadorTelefone telef = new GerenciadorTelefone();

		telef.addTelefone(telefone);

		empresa.setTelefone(telef.getListaNumeros());
		Assert.assertNotNull(empresa.getTelefone());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_uma_razaoSocial_nula() {
		empresa.setRazaoSocial(null);
		Assert.assertNull(empresa.getRazaoSocial());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_uma_razaoSocial_com_caracteres_especiais() {
		empresa.setRazaoSocial("luis@");
		Assert.assertNull(empresa.getRazaoSocial());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_nome_de_empresa_nulo() {
		empresa.setRazaoSocial(null);
		Assert.assertNull(empresa.getRazaoSocial());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_nome_de_empresa_vazia() {
		empresa.setRazaoSocial("");
		Assert.assertNull(empresa.getRazaoSocial());
	}

	@Test
	public void deve_aceitar_uma_data_de_criacao() throws ParseException {
		empresa.setDataCriacao(DateTime.now().plusDays(1));
		assertNotNull(empresa.getDataCriacao());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_uma_data_de_criacao_invalida() {
		empresa.setDataCriacao(DateTime.now().minusHours(1));
		assertNotNull(empresa.getDataCriacao());
	}

	@Test
	public void deve_printar_o_objeto_de_empresa() {
		System.out.println(empresa);
	}
}
