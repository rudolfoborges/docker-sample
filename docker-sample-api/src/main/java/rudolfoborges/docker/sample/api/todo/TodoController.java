package rudolfoborges.docker.sample.api.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import rudolfoborges.docker.sample.api.todo.request.TodoRequest;
import rudolfoborges.docker.sample.core.todo.Todo;
import rudolfoborges.docker.sample.core.todo.TodoBuilder;
import rudolfoborges.docker.sample.core.todo.TodoService;

/**
 * Created by rudolfoborges on 20/07/17.
 */
@RestController
@RequestMapping("v1/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping
	public ResponseEntity<List<Todo>> get(){
		final List<Todo> todos = todoService.fetchAll();

		return ResponseEntity.ok(todos);
	}

	@PostMapping
	public ResponseEntity<Void> post(@RequestBody TodoRequest todoRequest){

		final Todo todo = new TodoBuilder()
				.withName(todoRequest.getName())
				.withDescription(todoRequest.getDescription())
				.build();

		todoService.create(todo);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
