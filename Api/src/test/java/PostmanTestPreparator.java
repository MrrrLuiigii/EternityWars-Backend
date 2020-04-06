import com.eternitywars.api.ApiApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PostmanTestPreparator
{
    private static SessionFactory sessionFactory = ApiApplication.testSessionFactory;

    private Session session;
    private Transaction transaction;
}
