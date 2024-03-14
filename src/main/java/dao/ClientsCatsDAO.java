package dao;

import entity.ClientsCats;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ClientsCatsDAO {

    private SessionFactory sessionFactory;

    public ClientsCatsDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<ClientsCats> findAll() {
        return sessionFactory.openSession().createQuery("FROM ClientsCats", ClientsCats.class)
                .getResultList();
    }

    public List<ClientsCats> findAllCatsByClientID(int id) {
        return sessionFactory.openSession().createQuery("SELECT clientId, catId from ClientsCats where clientId = :id", ClientsCats.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<ClientsCats> findAllClientsByCatID(int id) {
       return sessionFactory.openSession().createQuery("SELECT clientId, catId from ClientsCats where catId = :id", ClientsCats.class)
                .setParameter("id", id)
                .getResultList();
    }

    public void insert(int clientId, int catId) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        ClientsCats clientCat = new ClientsCats(clientId, catId);
        session.persist(clientCat);
        session.getTransaction().commit();
    }

    public void removeByClientID(int clientId) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        //todo переделать под session.remove()
        session.createQuery("DELETE from ClientsCats where clientId = :clientId")
                .setParameter("clientId", clientId)
                .executeUpdate();
        session.getTransaction().commit();
    }

    public void removeByCatID(int catId) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        //todo переделать под session.remove()
        session.createQuery("DELETE from ClientsCats where clientId = :catId")
                .setParameter("catId", catId)
                .executeUpdate();
        session.getTransaction().commit();
    }

    public void updateClientByID(int clientIdNew, int clientIdOld, int catId) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        //todo переделать под session.merge()
        session.createQuery("UPDATE ClientsCats SET clientId = :clientIdNew WHERE catId = :catId and clientId = :clientIdOld")
                .setParameter("catId", catId)
                .setParameter("clientIdNew", clientIdNew)
                .setParameter("clientIdOld", clientIdOld)
                .executeUpdate();
        session.getTransaction().commit();
    }

    public void updateCatByID(int catIdNew, int catIdOld, int clientId) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        //todo переделать под session.merge()
        session.createQuery("UPDATE ClientsCats SET catId = :catIdNew WHERE clientId = :clientId and catId = :catIdOld")
                .setParameter("catIdNew", catIdNew)
                .setParameter("catIdOld", catIdOld)
                .setParameter("clientId", clientId)
                .executeUpdate();
        session.getTransaction().commit();
    }
}
