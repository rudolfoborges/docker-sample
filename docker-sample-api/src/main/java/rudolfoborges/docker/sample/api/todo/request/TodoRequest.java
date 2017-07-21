package rudolfoborges.docker.sample.api.todo.request;

import javax.validation.constraints.NotNull;

/**
 * Created by rudolfoborges on 20/07/17.
 */
public class TodoRequest {

	@NotNull
	private String name;

	@NotNull
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
