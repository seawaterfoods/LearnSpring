package com.joe.springbootlearnbegan.web;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * 在Spring Boot中標記了@Controller的class即可在URL中撈到這個class，
 * 但要注意@Controller是回傳同名的thymeleaf(模板)，
 * thymeleaf(模板)需於pom.xml導入spring-boot-starter-thymeleaf，
 * 而@RestController返回字串亦或是jason資料型態，
 *　@RequestMapping可以設定URL捕捉的字串，如下@RequestMapping("/api/v1")，
 *　即會於網址127.0.0.1:8080後加上/api/v1變成127.0.0.1:8080/api/v1，
 * 而@RequestMapping("/say",method = RequestMethod.GET)，
 * 其method =xxx部分即設定須通過何種資料傳遞方式，
 * 才可以去拜訪該頁面， RequestMethod.GET就是需要以GET請求才可以拜訪網站
 */


//@Controller
@RestController
@RequestMapping("/api/v1")
public class HelloController {

    // @RequestMapping("/say",method = RequestMethod.GET)是等同於@GetMapping("say")
    @GetMapping("say")
    public String hello() {
        return "Hello Spring Boot!!";
    }
/*
* 設定分頁http://127.0.0.1:8080/api/v1/books/{page}?page=x&{size}=x
* 可以設定其參數的預設值，如下例題。
*/
    @GetMapping("books")
//    @ResponseBody//可將返回值強制設為非thymeleaf資料(像是jason格式,String)
    public Object getAll(@RequestParam("page") int page,@RequestParam(value = "size",defaultValue = "10") int size) {
        Map<String,Object> book1 = new HashMap<String, Object>();
        book1.put("name", "哲學哲學雞蛋糕");
        book1.put("isbn", "1234567890123");
        book1.put("author", "哲糕");
        Map<String,Object> book2 = new HashMap<String, Object>();
        book2.put("name", "上班如何摸魚");
        book2.put("isbn", "1314151617182");
        book2.put("author", "狗才摸");
        List<Map> contents = new ArrayList<>();
        contents.add(book1);
        contents.add(book2);

        Map<String, Object> pageamp = new HashMap<>();
        pageamp.put("page", page);
        pageamp.put("size", size);
        pageamp.put("content",contents);
        return pageamp;
    }

    /*
     * XXXMapping("/books/{id}")其{id}是為傳入參數的值，
     * 可由資料庫傳入亦或是表單傳入，
     * 有設定其不定參數時需要在方法中預設的傳入參數的地方新增@PathVariable如下，
     * public Object getOne(@PathVariable xxx id)即可於此方法鎖定[id]這個值，
     * 注意！參數名稱必須完全一致，
     * 而且每個新增個參數都需要加@PathVariable如例題部分，
     * 正規表示式:{參數名:正則表達式}
     * @param id
     * @param username
     * @return
     * */
    @GetMapping("/books/{id}/{username:[a-z_]}")
    public Object getOne(@PathVariable long id, @PathVariable String username) {
        System.out.println("---id:" + id + "username: "+username);
        Map<String, Object> book = new HashMap<>();
        book.put("name", "哲學哲學雞蛋糕");
        book.put("isbn", "1234567890123");
        book.put("author", "哲糕");
        book.put("username",username);

        return book;
    }

    /*
    * @RequestParam是為Post傳遞資料時，所需設定的參數設定值，
    * 如下，將在前端form表單傳入name的變數而在Post中以name來捕捉其變數。
    * */
    @PostMapping("/books")
    public Object post(@RequestParam("name") String name,
                       @RequestParam("author")String author,
                       @RequestParam("isbn") String isbn){
        Map<String,Object> books = new HashMap<String, Object>();
        books.put("name",name);
        books.put("author",author);
        books.put("isbn",isbn);

        return books;
    }
}
