package librarysystem.DAL.Repositories;

import librarysystem.DAL.Models.Author;
import librarysystem.utils.HibernateUtilities;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
    public static Session session = HibernateUtilities.getCurrentSessionFromConfiguration();

    public static Transaction transaction = session.beginTransaction();

    public static void main(String[] args) {
        transaction.begin();

        Author newAuthor = new Author();

        newAuthor.setId(1);
        newAuthor.setName("Maria Ukrainska");
        newAuthor.setAge((byte) 17);

        session.save(newAuthor);

        transaction.commit();
    }
}
