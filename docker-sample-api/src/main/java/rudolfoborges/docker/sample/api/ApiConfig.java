package rudolfoborges.docker.sample.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import rudolfoborges.docker.sample.core.CoreConfig;

/**
 * Created by rudolfoborges on 21/07/17.
 */
@Configuration
@ComponentScan(basePackageClasses = {ApiConfig.class})
@Import({CoreConfig.class})
public class ApiConfig {
}
