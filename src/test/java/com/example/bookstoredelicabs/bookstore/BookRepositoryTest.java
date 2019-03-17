package com.example.bookstoredelicabs.bookstore;


import com.example.bookstoredelicabs.bookstore.domain.Book;
import com.example.bookstoredelicabs.bookstore.domain.BookRepository;
import com.example.bookstoredelicabs.bookstore.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByAuthorShouldReturnBook() {
       List<Book> books = this.repository.findByAuthor("Cole");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Journey");
    }

    @Test
    public void createNewBook() {
        Book book = new Book("Mickey", "Mouse","3j3jj", 1999, 29.99, new Category("Huuhaa"));
        repository.save(book);
        assertThat(book.getId()).isNotNull();
        repository.delete(book);

    }
}
