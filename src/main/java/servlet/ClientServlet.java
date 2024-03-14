package servlet;

import dao.ClientDAO;
import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/clients")
public class ClientServlet extends HttpServlet {
    ClientDAO clientDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("config", "dao", "servlet");

        clientDAO = context.getBean(ClientDAO.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = resp.getWriter();
        List<Client> clients = clientDAO.findAll();
        for (Client client :
                clients) {
            printWriter.println("--------------------------------------");
            printWriter.println("model.Client ID: " + client.getId() + " model.Client name: " + client.getName());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        if (name != null) {
            clientDAO.insert(name);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String clientId = req.getParameter("clientId");
        if (clientId != null) {
            clientDAO.removeByID(Integer.parseInt(clientId));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String clientId = req.getParameter("clientId");
        if (clientId != null && name != null) {
            clientDAO.updateNameByID(Integer.parseInt(clientId), name);
        }
    }
}
