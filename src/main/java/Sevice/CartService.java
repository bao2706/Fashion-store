package Sevice;

import DAO.DAO;
import entity.Cart;

import java.util.List;

public class CartService {
    DAO dao = new DAO();
    public void  add_to_cart(String userId,String productId,String quantity) {
        dao.add_to_cart(userId,productId,quantity);
    }
    public List<Cart> getProductInCart(int id){
        return dao.getProductInCart(id);
    }
    public void quantityChange(String quantity , int id) {
        dao.quantityChange(quantity,id);
    }
}
