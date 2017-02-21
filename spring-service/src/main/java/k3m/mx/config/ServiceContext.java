package k3m.mx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersistenceJPAConfig.class)  //Import config class from spring-data
@ComponentScan(basePackages = "k3m.mx.service")
public class ServiceContext {

}
