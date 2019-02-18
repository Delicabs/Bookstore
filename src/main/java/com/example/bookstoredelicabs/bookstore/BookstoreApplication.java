package com.example.bookstoredelicabs.bookstore;

import com.example.bookstoredelicabs.bookstore.domain.Book;
import com.example.bookstoredelicabs.bookstore.domain.BookRepository;
import com.example.bookstoredelicabs.bookstore.domain.Category;
import com.example.bookstoredelicabs.bookstore.domain.CategoryRepository;
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
    public CommandLineRunner demo(BookRepository repository, CategoryRepository grepository) {
        return (args) -> {

            grepository.save(new Category("IT"));
            grepository.save(new Category("SCI-FI"));
            grepository.save(new Category("Law"));


            repository.save(new Book("Journey", "Cole Matthew", "233ks", 1990, 20.90, grepository.findByName("IT").get(0)));
            repository.save(new Book("Math", "Albert", "33ookk", 1990, 30.40, grepository.findByName("SCI-FI").get(0)));


        };

    }

}

