package DAO;

import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CartDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void  add_to_cart(String userId, String productID,String quantity) {
        String query ="insert into shortshop.cart(userID,productID,quantity) values (?,?,?);";
        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setString(1, userId);
            ps.setString(2, productID);
            ps.setString(3, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void  remove(int id,String userId) {
        String query ="DELETE FROM cart \n" +
                "WHERE cartId = ? and  userID = ?; \n";

        try {
            con = new DBConnection().getConnection();// DB connect
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
