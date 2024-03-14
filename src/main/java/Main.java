import dao.CatDAO;
import dao.ClientDAO;
import dao.ClientsCatsDAO;
import entity.Cat;
import entity.Client;
import entity.ClientsCats;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        ClientsCatsDAO clientsCatsDAO = new ClientsCatsDAO();
        ClientDAO clientDAO = new ClientDAO();
        CatDAO catDAO = new CatDAO();
//        clientDAO.removeByID(2);
//        List<ClientsCats> clientsCats = clientsCatsDAO.findAll();
        List<Client> clients = clientDAO.findAll();
//        List<Cat> cats = catDAO.findAll();


        clients.stream().forEach(client -> System.out.println(client.getId() + " "));
//        clients.stream().forEach(client -> System.out.println(client.getId() + " "  + client.getCats()));

        //
//        cats.stream().forEach(cat -> System.out.println(cat.getId() + " " + cat.getClients()));

//        for (int i = 0; i < clientsCats.size(); i++) {
//            System.out.println(clientsCats.get(i).getClientId() + " " + clientsCats.get(i).getCatId());
//        }
        session.close();


        HibernateUtil.close();
    }
}