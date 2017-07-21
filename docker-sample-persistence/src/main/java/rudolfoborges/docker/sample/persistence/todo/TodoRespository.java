package rudolfoborges.docker.sample.persistence.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rudolfoborges on 21/07/17.
 */
@Repository
public interface TodoRespository extends JpaRepository<TodoEntity, Long> {

}
