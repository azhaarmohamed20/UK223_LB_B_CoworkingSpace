package com.example.uk223_lb_b_coworkingspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"security", "service","controller", "repository"})
@EntityScan(basePackages = "model")
public class Uk223LbBCoworkingSpaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Uk223LbBCoworkingSpaceApplication.class, args);
    }

}
