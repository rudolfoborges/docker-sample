package rudolfoborges.docker.sample.persistence;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by rudolfoborges on 21/07/17.
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan(basePackageClasses = {PersistenceConfig.class})
@EntityScan(basePackageClasses = {PersistenceConfig.class})
public class PersistenceConfig {
}
