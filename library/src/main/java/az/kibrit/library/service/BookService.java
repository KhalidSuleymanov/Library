package az.kibrit.library.service;
import az.kibrit.library.model.entity.Book;
import az.kibrit.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book books) {
        return bookRepository.save(books);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Long id, Book book) {
        Book books = bookRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Book not found"));

        book.setTitle(book.getTitle());
        book.setIsbn(book.getIsbn());
        book.setPublisher(book.getPublisher());
        book.setDescription(book.getDescription());
        book.setLanguage(book.getLanguage());
        book.setEdition(book.getEdition());
        book.setCoverImageUrl(book.getCoverImageUrl());
        book.setPrice(book.getPrice());
        book.setNumberOfPages(book.getNumberOfPages());
        book.setRating(book.getRating());
        book.setAvailableCopies(book.getAvailableCopies());
        book.setFormat(book.getFormat());
        book.setPublishedDate(book.getPublishedDate());
        return bookRepository.save(books);
    }

    public void deleteBook(Long id) {
        Book books = bookRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Book not found"));
        bookRepository.delete(books);
    }

    public List<Book> findBooksByCriteria(String authorName, String genre, Integer year,
                                          Integer rate, String language) {
        return bookRepository.findBooksByCriteria(authorName, genre, year, rate, language);
    }

}
