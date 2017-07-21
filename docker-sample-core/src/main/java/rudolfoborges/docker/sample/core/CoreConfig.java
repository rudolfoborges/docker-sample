package rudolfoborges.docker.sample.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import rudolfoborges.docker.sample.persistence.PersistenceConfig;

/**
 * Created by rudolfoborges on 21/07/17.
 */
@Configuration
@ComponentScan(basePackageClasses = {CoreConfig.class})
@Import({PersistenceConfig.class})
public class CoreConfig {
}
