package DAO;

import entity.Account;
import entity.Category;
import entity.Product;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String query = "select * from products;";
        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("image")
                ));
            }
        } catch (Exception e) {
        }


        return list;
    }
    public List<Product> getProductsByCateID(String cateID) {
        List<Product> list = new ArrayList<>();
        String query = "select * from products where CatoID =?\n";
        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setString(1, cateID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("image")
                ));
            }
        } catch (Exception e) {
        }


        return list;
    }
    public List<Product>    SearchProductByTxtSearch(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from products where name like ?\n";
        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setString(1, "%"+ txtSearch+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("image")
                ));
            }
        } catch (Exception e) {
        }


        return list;
    }
    public Product getProductsByID(String id) {
        String query = "select * from products where id=?\n";
        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
               return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("image")
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Category> getAllCategori() {
        List<Category> listC = new ArrayList<>();
        String query = "SELECT * FROM shortshop.category;";
        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listC.add(new Category(
                        rs.getString("CatoName"),
                        rs.getString("catoID")
                ));
            }
        } catch (Exception e) {

        }


        return listC;
    }
    public Account login(String username, String password) {
        String query =  "SELECT * FROM `user` WHERE username = ? AND password = ?";
        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("id"),
                        rs.getInt("issell"),
                        rs.getInt("isAdmin")
                );
            }
        } catch (Exception e) {
        }


        return null;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        Account list = dao.login("0","111111");
        if (list == null) {
            System.out.println("ko co user");
        }else {
            System.out.println(list.toString());
        }
//        for (Product o : list) {
//            System.out.println(o);
//        }
    }
}
//}


