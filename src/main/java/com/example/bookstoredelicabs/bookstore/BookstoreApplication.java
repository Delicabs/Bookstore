package com.example.bookstoredelicabs.bookstore;

import com.example.bookstoredelicabs.bookstore.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository, CategoryRepository grepository, UserRepository urepository ) {
        return (args) -> {

            grepository.save(new Category("IT"));
            grepository.save(new Category("SCI-FI"));
            grepository.save(new Category("Law"));


            repository.save(new Book("Journey", "Cole Matthew", "233ks", 1990, 20.90, grepository.findByName("IT").get(0)));
            repository.save(new Book("Math", "Albert", "33ookk", 1990, 30.40, grepository.findByName("SCI-FI").get(0)));

            User user1 = new User("user","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","USER");
            User user2 = new User("admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","ADMIN");
            urepository.save(user1);
            urepository.save(user2);


        };

    }

}

