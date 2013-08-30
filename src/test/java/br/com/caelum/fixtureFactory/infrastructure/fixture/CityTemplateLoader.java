package br.com.caelum.fixtureFactory.infrastructure.fixture;

import br.com.caelum.fixtureFactory.domain.model.City;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class CityTemplateLoader implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(City.class).addTemplate("valid", new Rule() {{
			add("id", sequence(Long.class));
			add("name", random("São Paulo, Osaco"));
		}});
	}

}
