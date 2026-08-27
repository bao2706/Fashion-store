package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/shortshop";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Khối static sẽ tự động chạy DUY NHẤT 1 lần khi class này được tải vào bộ nhớ
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("LỖI: KHÔNG TÌM THẤY DRIVER MYSQL!");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        // Hàm này giờ đây rất sạch sẽ, chỉ làm đúng nhiệm vụ mở kết nối
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
     try {
         System.out.println(new DBConnection().getConnection());

     }catch (Exception e){}
    }
}