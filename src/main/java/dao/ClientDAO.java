package dao;

import entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class ClientDAO {
    private final SessionFactory sessionFactory;

    public ClientDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Client> findAll() {
       return sessionFactory.openSession().createQuery("FROM Client", Client.class)
                .getResultList();
    }

    public Client findByID(int id) {
        return sessionFactory.openSession().get(Client.class, id);

    }
    public void insert(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Client client = new Client();
        client.setName(name);
        session.persist(client);
        session.getTransaction().commit();
    }

    public void removeByID(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Client client = session.get(Client.class, id);
        if (client != null) {
            session.remove(client);
            session.getTransaction().commit();
            System.out.println("Client " + client.getId() + " was removed ");
        }
    }

    public void updateNameByID(int id, String name) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Client client = session.get(Client.class, id);
        if (client != null) {
            client.setName(name);
            session.merge(client);
            session.getTransaction().commit();
        }
    }

}
