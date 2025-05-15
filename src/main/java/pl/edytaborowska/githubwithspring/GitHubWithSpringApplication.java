package pl.edytaborowska.githubwithspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GitHubWithSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitHubWithSpringApplication.class, args);
    }

}
