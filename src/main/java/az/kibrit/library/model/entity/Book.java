package az.kibrit.library.model.entity;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn; //(Kitabın beynəlxalq standart kitab nömrəsi (ISBN).)
    private String publisher;  // (Nəşriyyatçı)

    private String description; // (ümumi qisa melumat)
    private String language;
    private String edition;
    private String coverImageUrl;    // (üz qabığ şəklinin linki)
    private BigDecimal price;
    private int numberOfPages;
    private Double rating;
    private int availableCopies; //(kitabin kopyalari)
    private String format; //(kitabin formati)
    private LocalDate publishedDate; //(nesr tarixi)

    @ManyToMany(mappedBy = "books")
    private List<Author> authors = new ArrayList<>();

    @ManyToMany(mappedBy = "books")
    private List<Genre> genres = new ArrayList<>();


}
