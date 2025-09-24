package bookstore.Entity;

import jakarta.persistence.*;

@Entity
public class bookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false,referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false,referencedColumnName = "id")
    private Author author;


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


}
