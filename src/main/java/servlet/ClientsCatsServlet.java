//package servlet;
//
//import dao.ClientsCatsDAO;
//import entity.ClientsCats;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//@WebServlet("/clientscats")
//public class ClientsCatsServlet extends HttpServlet {
//    ClientsCatsDAO clientsCatsDAO = new ClientsCatsDAO();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String clientId = req.getParameter("clientId");
//        String catId = req.getParameter("catId");
//
//        PrintWriter printWriter = resp.getWriter();
//        List<ClientsCats> clientsCats;
//
//        if (clientId != null) {
//            clientsCats = clientsCatsDAO.findAllCatsByClientID(Integer.parseInt(
//                    clientId
//            ));
//
//        } else if (catId != null) {
//            clientsCats = clientsCatsDAO.findAllClientsByCatID(Integer.parseInt(
//                    catId
//            ));
//
//        } else {
//            clientsCats = clientsCatsDAO.findAll();
//        }
//        for (ClientsCats clientCat :
//                clientsCats) {
//            printWriter.println("--------------------------------------");
//            printWriter.println("model.Client ID: " + clientCat.getClientId() + " model.Cat ID: " + clientCat.getCatId());
//        }
//
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
//        String clientId = req.getParameter("clientId");
//        String catId = req.getParameter("catId");
//        if (clientId != null && catId != null) {
//            clientsCatsDAO.insert(Integer.parseInt(clientId), Integer.parseInt(catId));
//        }
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
//        String clientId = req.getParameter("clientId");
//        String catId = req.getParameter("catId");
//        if (clientId != null) {
//            clientsCatsDAO.removeByClientID(Integer.parseInt(clientId));
//        } else if (catId != null) {
//            clientsCatsDAO.removeByCatID(Integer.parseInt(catId));
//        }
//    }
//
//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
//        String clientIdNew = req.getParameter("clientIdNew");
//        String clientIdOld = req.getParameter("clientIdOld");
//        String catId = req.getParameter("catId");
//        String clientId = req.getParameter("clientId");
//        String catIdNew = req.getParameter("catIdNew");
//        String catIdOld = req.getParameter("catIdNewOld");
//        if (clientIdNew != null && clientIdOld != null && catId != null) {
//            clientsCatsDAO.updateClientByID(Integer.parseInt(clientIdNew), Integer.parseInt(clientIdOld), Integer.parseInt(catId));
//
//        } else if (clientId != null && catIdNew != null && catIdOld != null) {
//            clientsCatsDAO.updateCatByID(Integer.parseInt(catIdNew), Integer.parseInt(catIdOld), Integer.parseInt(clientId));
//
//        }
//    }
//}
