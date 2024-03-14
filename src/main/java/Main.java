import dao.ClientDAO;
import dao.ClientsCatsDAO;
import entity.Client;
import entity.ClientsCats;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("config", "dao", "servlet");
        ClientDAO clientDAO = context.getBean(ClientDAO.class);
        List<Client> clients = clientDAO.findAll();
        clients.stream().forEach(client -> System.out.println(client.getName()));
        ClientsCatsDAO clientsCatsDAO = context.getBean(ClientsCatsDAO.class);
        List<ClientsCats> clientsCats = clientsCatsDAO.findAllCatsByClientID(1);
        clientsCats.stream().forEach(clientCat -> System.out.println(clientCat.getClientId() + " " + clientCat.getCatId()));
    }
}