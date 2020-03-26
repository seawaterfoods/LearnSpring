package com.joe.springbootlearnbegan.web;

import com.joe.springbootlearnbegan.domain.Book;
import com.joe.springbootlearnbegan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String list(Model model) {
        List<Book> books = bookService.findAll();

        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "book";
    }

/*
* 跳轉提交頁面
* */
    @GetMapping("/books/input")
    public String inputPage(Model model)
    {
        model.addAttribute("book",new Book());
        return "input";
    }

    /*
    * 提交一個書單信息
    *
        return "redirect:/books":跳轉回books
    * */
    @PostMapping("/books")
    public String post(Book book){
        bookService.save(book);
        return "redirect:/books";
    }


    /*
    * 跳轉到更新頁面
    * */
    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model){
        Book book=bookService.findOne(id);
        model.addAttribute("book",book);
        return "input";
    }
}
