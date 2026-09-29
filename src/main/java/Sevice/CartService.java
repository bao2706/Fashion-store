package Sevice;

import DAO.DAO;
import DAO.CartDAO;
import entity.Cart;

import java.util.List;

public class CartService {
    DAO dao = new DAO();
    CartDAO cartDAO = new CartDAO();
    public void  add_to_cart(String userId,String productId,String quantity) {
        cartDAO.add_to_cart(userId,productId,quantity);
    }
    public List<Cart> getProductInCart(int id){
        return dao.getProductInCart(id);
    }
    public boolean quantityChange(int quantity, int cartId, int userId) {
        return dao.quantityChange(quantity, cartId, userId);
    }
    public void remove(int id, String userId) {
        cartDAO.remove(id,userId);
    }
}
