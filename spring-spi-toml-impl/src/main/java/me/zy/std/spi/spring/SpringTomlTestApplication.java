package me.zy.std.spi.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author zhaoyang.
 */
@SpringBootApplication
public class SpringTomlTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTomlTestApplication.class, args);
    }

    @Value("${title}")
    private String title;

    @Bean
    public CommandLineRunner test() {
        return (args -> {
            System.out.println("Server started...");
            System.out.println("\n\n\n");
            System.out.println("title = " + title);
        });
    }
}
