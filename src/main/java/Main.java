import dao.CatDAO;
import dao.ClientDAO;
import entity.Cat;
import entity.Client;
import entity.Human;
import entity.Worker;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CatDAO catDAO = new CatDAO();
        ClientDAO clientDAO = new ClientDAO();
//        session.beginTransaction();
//        Human human = new Human();
//        Worker worker = new Worker();
//        worker.setSalary(1000);
//        worker.setName("Gena");
//        human.setName("human_Vasya");
//        session.persist(human);
//        session.persist(worker);
//        session.getTransaction().commit();
//        clientDAO.insert("Artem1");
//        clientDAO.insert("Artem2");
//        clientDAO.insert("Artem3");
//        clientDAO.insert("Artem4");
//        clientDAO.insert("Artem5");
//        clientDAO.insert("Artem6");
//        catDAO.insert("Cir");
//        catDAO.removeByID(3);
//        catDAO.updateNameByID(2, "Bogo");
        List<Client> clients = clientDAO.findAll().stream().findFirst().stream().toList();
        clients.stream().forEach(client -> System.out.println(client.getName() + " " + client.getCats()));

//        List<Cat> cats = catDAO.findAll();
//        cats.stream().forEach(cat -> System.out.println(cat.getName()));

        session.close();


        HibernateUtil.close();
    }
}