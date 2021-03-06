package br.com.contmatic.testes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.Email;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class EmailTeste {

	private Email email;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Começo dos testes da classe " + EmailTeste.class.getSimpleName() + "\n");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.templates");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fim dos testes da classe " + EmailTeste.class.getSimpleName() + "\n");
	}

	@Before
	public void cria_objt() {
		email = Fixture.from(Email.class).gimme("emailValido");
		System.out.println("Começo do teste ");
	}

	@After
	public void finalizacao_Teste() {
		System.out.println(email);
		System.out.println("Fim de teste");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_endereco_de_email_nulo() {
		email.setEnderecoEmail(null);
		System.out.println(email.getEnderecoEmail());
		Assert.assertNull(email.getEnderecoEmail());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_endereco_de_email_vazio() {
		email.setEnderecoEmail("");
		Assert.assertNull(email.getEnderecoEmail());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_endereco_de_email_com_mais_de_1_arroba() {
		email.setEnderecoEmail("vict@r@@hotmail.com");
		Assert.assertNull(email.getEnderecoEmail());
	}

	@Test
	public void deve_aceitar_um_email_com_1_arroba() {
		Assert.assertNotNull(email.getEnderecoEmail());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_email_com_ponto_no_final() {
		email.setEnderecoEmail("victor@gmail.com.");
		Assert.assertNull(email.getEnderecoEmail());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_email_que_esteja_vazio_antes_do_arroba() {
		email.setEnderecoEmail("@gmail.com.br");
		Assert.assertNull(email.getEnderecoEmail());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_email_que_esteja_vazio_depois_do_arroba() {
		email.setEnderecoEmail("jose@");
		Assert.assertNull(email.getEnderecoEmail());
	}

}
