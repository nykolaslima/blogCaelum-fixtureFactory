package br.com.caelum.fixtureFactory.domain.service;

import java.util.Arrays;
import java.util.List;

import br.com.caelum.fixtureFactory.domain.model.Task;
import br.com.caelum.fixtureFactory.domain.model.User;

public class TaskService {
	
	public List<Task> findTasksByUser(User user) {
		return Arrays.asList(new Task());
	}

}
