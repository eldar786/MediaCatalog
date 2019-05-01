package ba.media;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"ba" }, exclude = RepositoryRestMvcAutoConfiguration.class)
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = { "ba" })
@EntityScan(basePackages = { "ba" })

public class MediaCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaCatalogApplication.class, args);
	}
}
