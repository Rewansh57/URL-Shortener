package org.example.projectsh.urlshortener;

import org.example.projectsh.urlshortener.model.Urls;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UrLshortenerApplication {

    public static void main(String[] args) {

        SpringApplication.run(UrLshortenerApplication.class, args);
    }


}
