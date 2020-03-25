package com.joe.springbootlearnbegan.web;

import com.joe.springbootlearnbegan.domain.Book;
import com.joe.springbootlearnbegan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
 * Created by limi on 2020/03/19
 * */
@RestController
@RequestMapping("/api/v1")
public class BookAppController {

    @Autowired
    private BookService bookService;
//
//
//    /*
//     * 查詢所有書單列表
//     * */
//    @GetMapping("/books")
//    public List<Book> getAll() {
//
//        return bookService.findAll();
//
//    }
//
//
//    /*
//     * 新增一個書單
//     *
//     * */
//    @PostMapping("/books")
//    public Book post(
//            Book book
//            /*@RequestParam String name,
//                     @RequestParam String author,
//                     @RequestParam String description,
//                     @RequestParam int status*/
//    ) {
////        book.setName(name);
////        book.setAuthor(author);
////        book.setDescription(description);
////        book.setStatus(status);
//
//        return bookService.save(book);
//    }
//
//
//    /*
//     * 獲取一條書單
//     * @param id
//     * @return
//     * */
//    @GetMapping("/books/{id}")
//    public Book getOne(@PathVariable long id) {
//        return bookService.findOne(id);
//    }
//
//    /*
//     * 更新一條書單
//     * */
//    @PutMapping("/books")
//    public Book updata(
//            @RequestParam long id,
//            @RequestParam String name,
//            @RequestParam String author,
//            @RequestParam String description,
//            @RequestParam int status) {
//        Book book = new Book();
//        book.setId(id);
//        book.setName(name);
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setStatus(status);
//
//        return bookService.save(book);
//    }
//
//
//    /*
//     * 刪除書單
//     * @param id
//     * */
//    @DeleteMapping("/books/{id}")
//    public void deleteOne(@PathVariable long id) {
//        bookService.deleteOne(id);
//    }
//
//
//    @PostMapping("/books/by")
//    public List<Book> findByAuthor(@RequestParam String author) {
//        return bookService.findByAuthor(author);
//    }
//
//    @PostMapping("/books/by")
//    public int findBy(@RequestParam long id, @RequestParam int status, @RequestParam long uid) {
//        return bookService.deleteAndUpdata(id, status, uid);
//    }


}
