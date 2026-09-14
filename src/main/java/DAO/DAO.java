package DAO;

import entity.Account;
import entity.Cart;
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
                        rs.getString("price"),
                        rs.getString("image"),
                        rs.getString("CatoID")
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
                        rs.getString("price"),
                        rs.getString("image"),
                        rs.getString("CatoID")
                ));
            }
        } catch (Exception e) {
        }


        return list;
    }

    public List<Product> SearchProductByTxtSearch(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from products where name like ?\n";
        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("price"),
                        rs.getString("image"),
                        rs.getString("CatoID")
                ));
            }
        } catch (Exception e) {
        }


        return list;
    }
    public List<Product> getProductBySellId(int sellId){
        List<Product> list = new ArrayList<>();
        String query = "select * from products where sellID=? ;";
        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setInt(1, sellId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("price"),
                        rs.getString("image"),
                        rs.getString("CatoID")
                ));
            }
        } catch (Exception e) {
        }


        return list;
    }
    public List<Cart> getProductInCart(int id){
        List<Cart> list = new ArrayList<>();
        String query = "SELECT \n" +
                "    c.cartID,\n" +
                "    c.productID,\n" +
                "    c.quantity,\n" +
                "    p.name,\n" +
                "    p.price,\n" +
                "    p.image\n" +
                "FROM cart c\n" +
                "JOIN products p ON c.productID = p.id\n" +
                "WHERE c.userID = ?;";
        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Cart(
                        rs.getInt("cartID"),
                        rs.getString("productID"),
                        rs.getString("quantity"),
                        rs.getString("name"),
                        rs.getString("price"),
                        rs.getString("image")
                ));
            }
        } catch (Exception e) {
        }


        return list;
    }

    public Product getProductsByID(String id) {
        String query = "select * from products where id=? \n";
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
                        rs.getString("price"),
                        rs.getString("image"),
                        rs.getString("CatoID")
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
        String query = "SELECT * FROM `user` WHERE username = ? AND password = ?";
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
    public void  signUp(String username, String password) {
        String query ="INSERT INTO user (username, password, issell, isAdmin) VALUES (?, ?, 0, 0)";
        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
        } catch (Exception e) {
        }


    }

    public void  addProduct(String name, String  description, String price, String image, String cateId, Integer sellId) {
        String query ="INSERT INTO products (name, image, description, price,CatoID,SellID) VALUES (?,?,?, ?, ?, ?)";

        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, description);
            ps.setString(4, price);
            ps.setString(5, cateId);
            ps.setInt(6, sellId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }


    }
    public void  deleteProduct(String id) {
        String query ="DELETE FROM products\n" +
                "WHERE id = ?; \n";

        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void  quantityChange(String quantity , int id) {
        String query ="UPDATE cart SET quantity = ? WHERE cartID = ?";

        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setString(1, quantity);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void  update(String name,String image,String description,String price,String CatoID,String id) {
        String query ="UPDATE products\n" +
                "SET\n" +
                "    name = ? , \n" +
                "    image =? ,\n" +
                "    description = ?,\n" +
                "    price = ?,\n" +
                "    CatoID = ?\n" +
                "WHERE id = ?;";

        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, description);
            ps.setString(4, price);
            ps.setString(5, CatoID);
            ps.setString(6, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public Account checkAccount(String username) {
        String query = "SELECT * FROM `user` WHERE username = ?";
        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setString(1, username);
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
        dao.quantityChange("36",2);
//        List<Cart> list = dao.getProductInCart(1);
//        if (list == null) {
//            System.out.println("ko co sp");
//        } else {
//            System.out.println(list.toString()+"/n");
//        }
//        for (Cart o : list) {
//            System.out.println(o);
//        }
    }
}
//}


