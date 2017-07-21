package rudolfoborges.docker.sample.core.todo;

import java.util.List;

/**
 * Created by rudolfoborges on 20/07/17.
 */
public interface TodoService {

	List<Todo> fetchAll();

	void create(Todo todo);

}
