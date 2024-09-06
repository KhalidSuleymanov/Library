package az.kibrit.library.service;
import az.kibrit.library.model.entity.Author;
import az.kibrit.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor(Author authors) {
        if (authorRepository.existsByFirstNameAndLastName(authors.getFirstName(), authors.getLastName())) {
            throw new IllegalArgumentException("Author with this name already exists");
        }
        return authorRepository.save(authors);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author updateAuthor(Long id, Author author) {
        Author authors = authorRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Author not found"));

        authors.setFirstName(author.getFirstName());
        authors.setLastName(authors.getLastName());
        authors.setDateOfBirth(authors.getDateOfBirth());
        authors.setNationality(authors.getNationality());
        authors.setBiography(authors.getBiography());
        authors.setPhotoUrl(authors.getPhotoUrl());
        authors.setDateOfDeath(authors.getDateOfDeath());
        return authorRepository.save(authors);
    }

    public void deleteAuthor(Long id) {
        Author authors = authorRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Author not found"));

        authorRepository.delete(authors);
    }
}
