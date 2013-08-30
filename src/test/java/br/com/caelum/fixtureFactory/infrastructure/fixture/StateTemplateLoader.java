package br.com.caelum.fixtureFactory.infrastructure.fixture;

import br.com.caelum.fixtureFactory.domain.model.State;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class StateTemplateLoader implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(State.class).addTemplate("valid", new Rule() {{
			add("id", sequence(Long.class));
			add("name", random("São Paulo", "Minas Gerais"));
		}});
	}

}
