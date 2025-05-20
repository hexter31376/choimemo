package com.teamplay.choimemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChoimemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChoimemoApplication.class, args);
    }
}
