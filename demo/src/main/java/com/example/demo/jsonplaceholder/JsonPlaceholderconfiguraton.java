package com.example.demo.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonPlaceholderconfiguraton {

    @Bean ("jsonplaceholder")
CommandLineRunner runner (JsonClient jsonClient) {
    return args -> {
        System.out.println("https://jsonplaceholder.typicode.com/posts");
        System.out.println(jsonClient.getPosts().size());
        System.out.println();
        System.out.println("https://jsonplaceholder.typicode.com/1");
        System.out.println(jsonClient.getPost(1));
    };
}
}
