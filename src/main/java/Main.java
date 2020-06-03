import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sample");
        final EntityManager entityManager = factory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        final Message hello = new Message();
        hello.setText("hello");
        hello.setCount(10);
        entityManager.persist(hello);
        transaction.commit();
        transaction.begin();
        final List<Message> messages = entityManager.createQuery("select m from Message m")
                                                        .getResultList();
        messages.get(0).setText("new world");
        transaction.commit();
        entityManager.close();


    }
}
