package Sevice;

import DAO.DAO;
import entity.Account;

public class UserService {
    DAO dao = new DAO();
    public Account login(String username, String password) {
        return dao.login(username, password);
    }
    public Account checkAccount(String username) {
        return dao.checkAccount(username);
    }
    public void signUp(String username, String password) {
        dao.signUp(username, password);
    }
}
