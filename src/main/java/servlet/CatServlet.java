package servlet;

import dao.CatDAO;
import entity.Cat;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/cats")
public class CatServlet  extends HttpServlet {
    CatDAO catDAO = new CatDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = resp.getWriter();
        List<Cat> cats = catDAO.findAll();
        for (Cat cat :
                cats) {
            printWriter.println("--------------------------------------");
            printWriter.println("model.Cat ID: " + cat.getId() + " model.Cat name: " + cat.getName());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        if (name != null) {
            catDAO.insert(name);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String catId = req.getParameter("catId");
        if (catId != null) {
            catDAO.removeByID(Integer.parseInt(catId));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String catId = req.getParameter("catId");
        if (catId != null && name != null) {
            catDAO.updateNameByID(Integer.parseInt(catId), name);
        }
    }
}
