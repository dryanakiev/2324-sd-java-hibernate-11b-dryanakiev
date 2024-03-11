package librarysystem.DAL.Repositories;

import librarysystem.DAL.Models.Author;
import librarysystem.utils.HibernateUtilities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class AuthorRepository {
    public static SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
    public static Session session = sessionFactory.getCurrentSession();

    public List getAllAuthors() {
        String hibernateQuery = "FROM Author";

        Query query = session.createQuery(hibernateQuery);

        return query.list();
    }

    public Author getAuthorByName(String name) {
        String hibernateQuery = "FROM Author WHERE Author.name = name";
        Query query = session.createQuery(hibernateQuery);

        return (Author) query;
    }

    public Author getAuthorById(int id) {
        String hibernateQuery = "FROM Author WHERE Author.id = id";
        Query query = session.createQuery(hibernateQuery);

        return (Author) query;
    }

    public void addAuthor(Author newAuthor) {
        // Hibernate transaction
        Transaction transaction = session.beginTransaction();

        session.save(newAuthor);

        transaction.commit();
    }

    public void updateAuthor(Author newAuthor) {
        // Hibernate transaction
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(newAuthor);

        transaction.commit();
    }

    public void deleteAuthor(Author oldAuthor) {
        // Hibernate transaction
        Transaction transaction = session.beginTransaction();

        session.remove(oldAuthor);

        transaction.commit();
    }
}
