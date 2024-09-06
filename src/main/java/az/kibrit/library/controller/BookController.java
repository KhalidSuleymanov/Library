package az.kibrit.library.controller;
import az.kibrit.library.model.entity.Book;
import az.kibrit.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book createBook(@Validated @RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book books) {
        return bookService.updateBook(id, books);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String authorName,
                                  @RequestParam(required = false) String genre,
                                  @RequestParam(required = false) Integer year,
                                  @RequestParam(required = false) Integer rate,
                                  @RequestParam(required = false) String language) {
        return bookService.findBooksByCriteria(authorName, genre, year, rate, language);
    }
}
