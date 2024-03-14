package dao;

import entity.Cat;
import entity.Client;
import org.hibernate.Session;
import utils.ConnectionManager;
import utils.HibernateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatDAO {
    public List<Cat> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("FROM Cat", Cat.class).getResultList();
    }

    public Cat findByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Cat.class, id);
    }
    public void insert(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.persist(name);
    }
    public void removeByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Cat Cat = session.get(Cat.class, id);
        if (Cat != null) {
            session.remove(Cat);
            session.getTransaction().commit();
            System.out.println("Cat " + Cat.getId() + " was removed ");
        }
    }

    public void updateNameByID(int id, String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Cat cat = session.get(Cat.class, id);
        if (cat != null) {
            cat.setName(name);
            session.merge(cat);
            session.getTransaction().commit();
        }
    }
}
