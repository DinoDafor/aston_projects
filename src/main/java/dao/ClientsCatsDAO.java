package dao;

import model.ClientsCats;
import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientsCatsDAO {
    private static final String findAllClientsCatsQuery = "SELECT * FROM Clients_cats";

    public List<ClientsCats> findAll() {
        List<ClientsCats> clientsCats = new ArrayList<>();
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(findAllClientsCatsQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ClientsCats clientCat = new ClientsCats(
                        rs.getInt("client_Id"), rs.getInt("cat_Id")
                );
                clientsCats.add(clientCat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientsCats;

    }

    public List<ClientsCats> findAllCatsByClientID(int id) {
        Connection conn = ConnectionManager.getConnection();
        List<ClientsCats> cats = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM clients_cats WHERE client_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ClientsCats clientCat = new ClientsCats(
                        rs.getInt(1), rs.getInt(2)
                );
                cats.add(clientCat);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cats;
    }

    public List<ClientsCats> findAllClientsByCatID(int id) {
        Connection conn = ConnectionManager.getConnection();
        List<ClientsCats> clients = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM clients_cats WHERE cat_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ClientsCats clientCat = new ClientsCats(
                        rs.getInt(1), rs.getInt(2)
                );
                clients.add(clientCat);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    public void insert(int clientId, int catId) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO clients_cats(client_id, cat_id) VALUES (?,?)");
            preparedStatement.setInt(1, clientId);
            preparedStatement.setInt(2, catId);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("successful insertion: " + clientId + " and" + catId);
            } else {
                System.out.println("unsuccessful insertion" + clientId + " and" + catId);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeByClientID(int clientId) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM clients_cats WHERE client_id = ?");
            preparedStatement.setInt(1, clientId);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("successful removing: " + clientId);
            } else {
                System.out.println("unsuccessful removing: " + clientId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeByCatID(int catId) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM clients_cats WHERE cat_id = ?");
            preparedStatement.setInt(1, catId);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("successful removing: " + catId);
            } else {
                System.out.println("unsuccessful removing: " + catId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateClientByID(int clientIdNew, int clientIdOld, int catId) {
        Connection con = ConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE clients_cats SET client_id = ? WHERE cat_id = ? and client_id = ? ");

            preparedStatement.setInt(1, clientIdNew);
            preparedStatement.setInt(2, catId);
            preparedStatement.setInt(3, clientIdOld);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("successful update clientNew: " + clientIdNew);
            } else {
                System.out.println("unsuccessful update clientNew: " + clientIdNew);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateCatByID(int catIdNew, int catIdOld, int clientId) {
        Connection con = ConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE clients_cats SET cat_id = ? WHERE client_id = ? and cat_id = ? ");

            preparedStatement.setInt(1, catIdNew);
            preparedStatement.setInt(2, clientId);
            preparedStatement.setInt(3, catIdOld);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("successful update clientNew: " + catIdNew);
            } else {
                System.out.println("unsuccessful update clientNew: " + catIdNew);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
