package rudolfoborges.docker.sample.core.user;

public class UserBuilder {
	private String name;
	private String email;

	public UserBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder withEmail(String email) {
		this.email = email;
		return this;
	}

	public User build() {
		return new User(name, email);
	}
}