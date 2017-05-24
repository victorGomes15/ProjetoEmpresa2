package br.com.contmatic.templates;

import org.joda.time.DateTime;

import br.com.contmatic.empresa.Email;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmpresaTemplates implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Empresa.class).addTemplate("empresaValida", new Rule() {
			{
				add("cnpj", regex("\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}"));
				add("dataCriacao", DateTime.now().plusDays(1));
				add("dono", random("João", "José", "Pedro", "Luís"));
				add("email", one(Email.class, "emailValido"));
				add("endereco", has(1).of(Endereco.class, "enderecoValido"));
				add("inscricaoEstadual", regex("[0-9]{13}"));
				add("nomeEmpresa", random("Car System", "cidadeValida", "Super casinha"));
				add("razaoSocial", regex("[A-Za-z0-9]{8}"));
				add("telefone", has(1).of(Telefone.class, "telefoneValido"));
			}
		});

	}

}
