package az.kibrit.library.service;

import az.kibrit.library.model.entity.Genre;
import az.kibrit.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Genre createGenre(Genre genres) {
        if (genreRepository.existsByName(genres.getName())) {
            throw new IllegalArgumentException("Genre with this name already exists");
        }
        return genreRepository.save(genres);
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre updateGenre(Long id, Genre genre) {
        Genre genres = genreRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Genre not found"));

        genre.setName(genre.getName());
        genre.setDescription(genre.getDescription());
        return genreRepository.save(genres);
    }

    public void deleteGenre(Long id) {
        Genre genres = genreRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Genre not found"));

        genreRepository.delete(genres);
    }
}