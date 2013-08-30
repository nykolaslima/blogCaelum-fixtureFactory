package br.com.caelum.fixtureFactory.infrastructure.fixture;

import br.com.caelum.fixtureFactory.domain.model.Address;
import br.com.caelum.fixtureFactory.domain.model.User;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class UserTemplateLoader implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(User.class).addTemplate("valid", new Rule() {{
			add("id", sequence(Long.class));
			add("username", random("Nykolas", "Ricardo", "Ana"));
			add("address", one(Address.class, "valid"));
		}});
	}

}
