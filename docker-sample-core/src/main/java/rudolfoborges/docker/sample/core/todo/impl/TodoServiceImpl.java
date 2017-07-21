package rudolfoborges.docker.sample.core.todo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import rudolfoborges.docker.sample.core.todo.Todo;
import rudolfoborges.docker.sample.core.todo.TodoBuilder;
import rudolfoborges.docker.sample.core.todo.TodoService;
import rudolfoborges.docker.sample.persistence.todo.TodoEntity;
import rudolfoborges.docker.sample.persistence.todo.TodoRespository;

/**
 * Created by rudolfoborges on 20/07/17.
 */
@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRespository todoRespository;

	@Override
	public List<Todo> fetchAll() {
		final List<TodoEntity> todoEntities = todoRespository.findAll(new Sort(Sort.Direction.ASC, "name"));

		return todoEntities
				.stream()
				.map(todoEntity -> new TodoBuilder()
						.withName(todoEntity.getName())
						.withDescription(todoEntity.getDescription())
						.withClosed(todoEntity.getClosed())
						.build())
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void create(Todo todo) {
		final TodoEntity todoEntity = new TodoEntity(todo.getName(), todo.getDescription());

		todoRespository.save(todoEntity);
	}

}
