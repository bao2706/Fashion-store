package Sevice;

import DAO.DAO;
import entity.Category;

import java.util.List;

public class CategoryService {
    DAO dao = new DAO();
    public List<Category> getAllCategories() {
        return dao.getAllCategori();
    }

}
