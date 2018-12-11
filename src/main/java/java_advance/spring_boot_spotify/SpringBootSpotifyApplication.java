package java_advance.spring_boot_spotify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("java_advance.spring_boot_spotify.repository")
public class SpringBootSpotifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSpotifyApplication.class, args);
    }
}
