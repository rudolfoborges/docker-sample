package rudolfoborges.docker.sample.core.todo;


/**
 * Created by rudolfoborges on 20/07/17.
 */
public class TodoBuilder {
	private String name;
	private String description;
	private Boolean closed;

	public TodoBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public TodoBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	public TodoBuilder withClosed(Boolean closed) {
		this.closed = closed;
		return this;
	}

	public Todo build() {
		return new Todo(name, description, closed);
	}
}