package com.example.bookstoredelicabs.bookstore;

import com.example.bookstoredelicabs.bookstore.web.BookController;
import com.example.bookstoredelicabs.bookstore.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {

    @Autowired
    private BookController controller;
    @Autowired
    UserController userController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
        assertThat(userController).isNotNull();
    }

}

