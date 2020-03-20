package com.joe.springbootlearnbegan.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/*
* 這可以新增SQL查詢語句，
* 是用特定命名方法名的方式去自動拼裝SQL語法
* */
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByAuthorAndStatus(String author,int status);

    /*
     * EndsWith:以描述結尾字元作為查詢書單(%xxx)
     * Contains:以描述中字元作為查詢書單(%xxx%)
     * 可去spring.io去查詢相關關鍵詞定義
     * */
    List<Book> findByDescriptionEndsWith(String des);

    /*
    * @Query()可以自定義搜尋條件
    * */
//    @Query("select b from Book b where length(b.name) > ?1 ")
    @Query(value="select * from book where length(b.name) > ?1 ",nativeQuery=true)
    List<Book> findByJPQL(int len);


    /*
    * 自定義更新
    * @Transactional將其納入事務管理
    * */
    @Transactional
    @Modifying
    @Query("update Book b set  b.status =?1 where b.id= ?2")
    int updataByJPQL(int status,long id);

    /*
     * 自定義刪除
     * @Transactional將其納入事務管理
     * */
    @Transactional
    @Modifying
    @Query("delete from Book b where b.id= ?1")
    int deleteByJPQL(long id);
}
