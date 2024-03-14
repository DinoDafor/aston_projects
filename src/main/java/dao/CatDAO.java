package dao;

import entity.Cat;
import entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import utils.HibernateUtil;

import java.util.List;
@Repository
public class CatDAO {
    private final SessionFactory sessionFactory;

    public CatDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Cat> findAll() {
        return sessionFactory.openSession().createQuery("FROM Cat", Cat.class)
                .getResultList();
    }

    public Cat findByID(int id) {
        Session session = sessionFactory.openSession();
        return session.get(Cat.class, id);
    }
    public void insert(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Cat cat = new Cat();
        cat.setName(name);
        session.persist(cat);
        session.getTransaction().commit();
    }
    public void removeByID(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Cat Cat = session.get(Cat.class, id);
        if (Cat != null) {
            session.remove(Cat);
            session.getTransaction().commit();
            System.out.println("Cat " + Cat.getId() + " was removed ");
        }
    }

    public void updateNameByID(int id, String name) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Cat cat = session.get(Cat.class, id);
        if (cat != null) {
            cat.setName(name);
            session.merge(cat);
            session.getTransaction().commit();
        }
    }
}
