package br.com.caelum.fixtureFactory.infrastructure.fixture;

import br.com.caelum.fixtureFactory.domain.model.Address;
import br.com.caelum.fixtureFactory.domain.model.City;
import br.com.caelum.fixtureFactory.domain.model.State;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class AddressTemplateLoader implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Address.class).addTemplate("valid", new Rule() {{
			add("id", sequence(Long.class));
			add("state", one(State.class, "valid"));
			add("city", one(City.class, "valid"));
		}});
	}

}
