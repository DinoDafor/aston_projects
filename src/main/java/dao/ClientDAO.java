package dao;

import model.Client;
import utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientDAO {
    private static final String findAllClientsQuery = "SELECT * FROM Client";

    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(findAllClientsQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Client client = new Client(
                        rs.getInt("id"), rs.getString("name")
                );
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;

    }

    public void findByID(int id) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM client WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void insert(String name) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO client(name) VALUES (?)");
            preparedStatement.setString(1, name);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("successful insertion: " + name);
            } else {
                System.out.println("unsuccessful insertion" + name);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeByID(int id) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM client WHERE id = ?");
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("successful removing: " + id);
            } else {
                System.out.println("unsuccessful removing: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateNameByID(int id, String name) {
        Connection con = ConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE client SET name = ? WHERE id = ? ");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("successful update: " + id);
            } else {
                System.out.println("unsuccessful update: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
