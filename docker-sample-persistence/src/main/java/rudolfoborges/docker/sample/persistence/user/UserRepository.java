package rudolfoborges.docker.sample.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rudolfoborges on 21/07/17.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
