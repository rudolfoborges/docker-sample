package rudolfoborges.docker.sample.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rudolfoborges.docker.sample.core.todo.TodoBuilder;
import rudolfoborges.docker.sample.core.todo.TodoService;

@SpringBootApplication
public class ApiStarter implements CommandLineRunner {

	@Autowired
	private TodoService todoService;

	public static void main(String[] args) {
		SpringApplication.run(ApiStarter.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		todoService.create(new TodoBuilder()
				.withName("Jenkins")
				.withDescription("Configuração do projeto para o Jenkins")
				.build());

		todoService.create(new TodoBuilder()
				.withName("Docker")
				.withDescription("Configurar o projeto para rodar no docker")
				.build());
	}
}
