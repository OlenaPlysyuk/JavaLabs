package database;
import java.sql.*;
public class Connect {
    public void connect()
    {
        String url = "jdbc:sqlserver://localhost:55322;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            System.out.println("Connection to FlowersShop database has been established using Windows Authentication.");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void method()
    {
        connect();
    }
}
