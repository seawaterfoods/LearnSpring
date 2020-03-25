package com.joe.springbootlearnbegan.service;

import com.joe.springbootlearnbegan.domain.Book;
import com.joe.springbootlearnbegan.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    /*
     * 查詢所有書單列表
     * @return
     * */
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    /*
     * 提交一個書單
     * @return Book
     * */
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    /*
     * 獲取一條書單
     * @param id
     * @return Book
     *
     * */
    public Book findOne(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    /*
     * 刪除一條書單
     * */
    public void deleteOne(long id) {
        bookRepository.deleteById(id);
    }


    /*
     * 以作者作為搜尋條件來搜尋書單
     *
     * */
    @PostMapping("/books/by")
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    /*
     * 以作者以及閱讀狀態作為搜尋條件來搜尋書單
     * */
    @PostMapping("/books/by")
    public List<Book> findByAuthorAndStatus(@RequestParam String author,
                                            @RequestParam int status) {
        return bookRepository.findByAuthorAndStatus(author, status);
    }

    /*
     * 以描述結尾字元作為查詢書單
     * */
    public List<Book> findByDescriptionEndWith(String des) {
        return bookRepository.findByDescriptionEndsWith(des);
    }

    /*
     * 以自定義語法去查詢
     * @Transactional將其納入事務管理
     * */
//    @Transactional
    public List<Book> findByJPQL(int len) {
        return bookRepository.findByJPQL(len);
    }

    /*
     * 測試事務操作方法
     *
     * */
    @Transactional
    public int deleteAndUpdata(long id, int status, long uid) {

        int dcount = bookRepository.deleteByJPQL(id);

        int udcont = bookRepository.updataByJPQL(status, uid);

        return dcount + udcont;

    }
}
