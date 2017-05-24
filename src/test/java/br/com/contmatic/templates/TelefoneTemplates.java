package br.com.contmatic.templates;

import br.com.contmatic.empresa.Telefone;
import br.com.contmatic.empresa.TelefoneType;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class TelefoneTemplates implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Telefone.class).addTemplate("telefoneValido", new Rule() {
			{
				add("ddd", random(Integer.class, range(11, 99)));
				add("tipo", random(TelefoneType.values()));
				add("numero", regex("\\d{8,9}"));
			}
		});
	}

}
