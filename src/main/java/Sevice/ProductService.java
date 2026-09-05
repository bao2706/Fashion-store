package Sevice;

import DAO.DAO;
import entity.Category;
import entity.Product;

import java.util.List;

public class ProductService {
    private DAO dao = new DAO();

    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }
    public Product getProductsByID(String id) {
        return dao.getProductsByID(id);
    }
    public void addProduct(String name, String description, String price, String image, String cateId, int sellId) {
        dao.addProduct(
                name,
                description,
                price,
                image,
                cateId,
                sellId);
    }
    public List<Product> getProductsByCateID(String cateID) {
        return dao.getProductsByCateID(cateID);
    }
    public void deleteProduct(String id) {
        dao.deleteProduct(id);
    }
    public List<Product> getProductsBySellId(int sellId) {
        return dao.getProductBySellId(sellId);
    }
    public List<Product> SearchProductByTxtSearch(String txtSearch) {
        return dao.SearchProductByTxtSearch(txtSearch);
    }
    public void update(String name,String image,String description,String price,String CatoID,String id) {
        dao.update(name, image, description, price, CatoID,id);
    }

}
