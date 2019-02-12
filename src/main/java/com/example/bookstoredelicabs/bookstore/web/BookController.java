package com.example.bookstoredelicabs.bookstore.web;

import com.example.bookstoredelicabs.bookstore.domain.Book;
import com.example.bookstoredelicabs.bookstore.domain.BookRepository;
import com.example.bookstoredelicabs.bookstore.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class BookController {
    @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository grepository;
    @RequestMapping("/booklist")
    public String bookList(Model model){
        model.addAttribute("books",repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }


    @RequestMapping(value = "/addbook")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories",grepository.findAll());
        return "addbook";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook (@PathVariable("id") Long bookId,Model model){
        model.addAttribute("book",repository.findById(bookId));
        model.addAttribute("categories", grepository.findAll());
        return "edit";

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}