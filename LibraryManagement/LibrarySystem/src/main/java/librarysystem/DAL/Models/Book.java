package librarysystem.DAL.Models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Books", schema = "dbo", catalog = "LibrarySystem")
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private int id;
    @Basic
    @Column(name = "Title", nullable = false, length = 50)
    private String title;
    @Basic
    @Column(name = "Description", nullable = false, length = 50)
    private String description;
    @Basic
    @Column(name = "Pages", nullable = false)
    private short pages;
    @Basic
    @Column(name = "AuthorId", nullable = false)
    private int authorId;
    @Basic
    @Column(name = "GenreId", nullable = false)
    private int genreId;
    @ManyToOne
    @JoinColumn(name = "AuthorId", referencedColumnName = "Id", nullable = false)
    private Author authorsByAuthorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getPages() {
        return pages;
    }

    public void setPages(short pages) {
        this.pages = pages;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && pages == book.pages && authorId == book.authorId && genreId == book.genreId && Objects.equals(title, book.title) && Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, pages, authorId, genreId);
    }

    public Author getAuthorsByAuthorId() {
        return authorsByAuthorId;
    }

    public void setAuthorsByAuthorId(Author authorsByAuthorId) {
        this.authorsByAuthorId = authorsByAuthorId;
    }
}
