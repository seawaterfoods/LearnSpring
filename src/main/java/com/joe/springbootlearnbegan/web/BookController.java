package com.joe.springbootlearnbegan.web;

import com.joe.springbootlearnbegan.domain.Book;
import com.joe.springbootlearnbegan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String list(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,
            Model model) {
//        List<Book> books = bookService.findAll();
//        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Page<Book> page1 = bookService.findAllByPage(pageable);
        model.addAttribute("page", page1);
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
    * 跳轉到更新頁面"input"
    * */
    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model){
        Book book=bookService.findOne(id);
        model.addAttribute("book",book);
        return "input";
    }
    /*
    * 提交一個書單信息
    *
        return "redirect:/books":跳轉回books
    * */
    @PostMapping("/books")
    public String post(Book book, final RedirectAttributes attributes){
        Book book1 = bookService.save(book);
        if (book1!= null){
            attributes.addFlashAttribute("message","《"+book1.getName()+"》信息提交成功");
        }
        return "redirect:/books";
    }

    /*
    * POST --->redirect -->GET
    * model只能在一個請求使用
    *
    * */
    @GetMapping("/books/{id}/delete")
    public String delete(@PathVariable long id,final RedirectAttributes attributes){
        bookService.deleteOne(id);
        attributes.addFlashAttribute("message","刪除成功");
        return "redirect:/books";
    }
}
