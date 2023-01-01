package codegym.vn.demo.controller;

import codegym.vn.demo.aspect.LoggingAspect;
import codegym.vn.demo.exception.UserException;
import codegym.vn.demo.model.Book;
import codegym.vn.demo.model.User;
import codegym.vn.demo.repository.CategoryRepository;
import codegym.vn.demo.service.BookService;
import codegym.vn.demo.validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    BookValidator bookValidator;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    MessageSource messageSource;

    private Logger logger = Logger.getLogger(BookController.class.getName());

    @GetMapping("create")
    public String displayCreate(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "book/create";
    }

    @PostMapping("create")
    public String create(@Validated @ModelAttribute("book") Book book, BindingResult bindingResult,
                         Model model) {
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryRepository.findAll());
            return "book/create";
        }
        bookService.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("list")
    public String showListBook(@RequestParam(name = "nameBook", required = false) String name, Model model,
                               @CookieValue(name = "counter", defaultValue = "0") int count, HttpServletResponse response,
                               HttpServletRequest request, HttpSession session) {
//        User user = (User) session.getAttribute("user");
//        if (user == null || user.getUsername() == null) {
//            return "redirect:/login";
//        }
        if (name != null && !name.isEmpty()) {
            model.addAttribute("books", bookService.findByName(name));
        } else {
            model.addAttribute("books", bookService.getList());
        }

        // Nếu không sử dụng annotation CookieValue thì phải code như bên dưới
//        Cookie[] cookies = request.getCookies();
//        for(Cookie c: cookies) {
//            if (c.getName().equals("counter")){
//                count = Integer.parseInt(c.getValue());
//            }
//        }

        Cookie cookie = new Cookie("counter", "" + ++count);
        cookie.setMaxAge(5);
        response.addCookie(cookie);
        model.addAttribute("counter", cookie);

        return "book/list";
    }

    @GetMapping("listPaging")
    public String showListBookPaging(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "3") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            Model model) {
        Sort order = null;
        if (sort.equals("ASC")) {
            order = Sort.by("name").ascending();
        } else if (sort.equals("DESC")) {
            order = Sort.by("name").descending();
        }

        Pageable pageable = PageRequest.of(page - 1, size, order);

        model.addAttribute("books", bookService.findAll(pageable));
        return "book/list";
    }

    @GetMapping("detail/{id}")
    public String showDetail(@PathVariable("id") int book_id, Model model) {
        model.addAttribute("book", bookService.getBookById(book_id));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(dateFormat.format(bookService.getBookById(book_id).getPublishDate()));
        return "book/detail";
    }

    @GetMapping("detail2/{id}")
    public String showDetail2(@PathVariable("id") Book book, Model model) throws Exception {
        if (book.getBookId() == 1) {
            throw new UserException("Book ID = 2");
        }
        if (book.getBookId() == 3) {
            throw new Exception("Book ID = 3");
        }
        model.addAttribute("book", book);
        return "book/detail";
    }

    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model) {
        model.addAttribute("message", e.getMessage());
        System.out.println("=============Book controller============");
        return "errordemo";
    }
}
