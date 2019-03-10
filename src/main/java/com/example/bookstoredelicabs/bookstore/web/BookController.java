package com.example.bookstoredelicabs.bookstore.web;

import com.example.bookstoredelicabs.bookstore.domain.Book;
import com.example.bookstoredelicabs.bookstore.domain.BookRepository;
import com.example.bookstoredelicabs.bookstore.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private HttpSession session;
    @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository grepository;


    @RequestMapping("/login")
    public String login() {
        session.setAttribute("Juan","Value");
        return "login";

    }


    //Shows all books
    @RequestMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        String value = (String) session.getAttribute("Juan");
        System.out.println(value);
        return "booklist";
    }

    // RESTful service to get all students
    @RequestMapping(value = "/books")
    public @ResponseBody
    List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    }

    //RESTful service to get stuent by id
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId);
    }


    //Delete book
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }

    //Add new book
    @RequestMapping(value = "/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", grepository.findAll());
        return "addbook";
    }

    // Edit existing book
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        model.addAttribute("categories", grepository.findAll());
        return "edit";

    }

    //Save book
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    // index-
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}