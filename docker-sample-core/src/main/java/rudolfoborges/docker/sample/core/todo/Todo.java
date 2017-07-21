package rudolfoborges.docker.sample.core.todo;

import java.util.Date;

/**
 * Created by rudolfoborges on 20/07/17.
 */
public class Todo {

	private final String name;

	private final String description;

	private final Boolean closed;

	public Todo(String name, String description, Boolean closed) {
		this.name = name;
		this.description = description;
		this.closed = closed;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getClosed() {
		return closed;
	}
}
