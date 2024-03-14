package dao;

import entity.Cat;
import entity.Client;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;


public class ClientDAO {
    public List<Client> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("FROM Client", Client.class)
                .getResultList();

    }

    public Client findByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Client.class, id);
    }

    public void insert(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Client client = new Client();
        client.setName(name);
        session.persist(client);
        session.getTransaction().commit();
    }

    public void removeByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Client client = session.get(Client.class, id);
        if (client != null) {
            session.remove(client);
            session.getTransaction().commit();
            System.out.println("Client " + client.getId() + " was removed ");
        }
    }

    public void updateNameByID(int id, String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Client client = session.get(Client.class, id);
        if (client != null) {
            client.setName(name);
            session.merge(client);
            session.getTransaction().commit();
        }
    }

}
