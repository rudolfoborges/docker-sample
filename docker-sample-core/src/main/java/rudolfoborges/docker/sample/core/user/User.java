package rudolfoborges.docker.sample.core.user;

/**
 * Created by rudolfoborges on 21/07/17.
 */
public class User {

	private final String name;

	private final String email;

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
