package dao;

import model.Cat;
import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatDAO {
    private static final String findAllCatsQuery = "SELECT * FROM Cat";

    public List<Cat> findAll() {
        List<Cat> cats = new ArrayList<>();
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(findAllCatsQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cat cat = new Cat(
                        rs.getInt("id"), rs.getString("name")
                );
                cats.add(cat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cats;

    }

    public void findByID(int id) {
        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM cat WHERE id = ?");
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
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO cat(name) VALUES (?)");
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
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM cat WHERE id = ?");
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
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE cat SET name = ? WHERE id = ? ");
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
