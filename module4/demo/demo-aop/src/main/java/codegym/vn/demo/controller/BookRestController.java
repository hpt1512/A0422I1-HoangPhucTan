package codegym.vn.demo.controller;

import codegym.vn.demo.model.Book;
import codegym.vn.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookRestController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/searchNameBook",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public List<Book> searchNameBook(@RequestParam(name = "nameBook", required = false, defaultValue = "") String name) {
        List<Book> books = bookService.findByName(name);
        return books;
    }
}
