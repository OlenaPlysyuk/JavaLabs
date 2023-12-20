package database;

import java.sql.*;

public class Insert {
    public boolean insertUser(String name,String email,String password)
    {
        String url = "jdbc:sqlserver://localhost:55322;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.Users VALUES (" + "'" + name + "','" + email + "','" + password + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertFlower(String name,String color,String scent,String size,String description,String producer,String country,int price,int count)
    {
        String url = "jdbc:sqlserver://localhost:55322;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.Flower VALUES (" + "'" + name + "','" + color + "','" + scent + "','" + size + "','" + description + "','" + producer + "','" + country + "','" + price + "','" + count + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertUserData(int userID,String phone,String address,String payment)
    {
        String url = "jdbc:sqlserver://localhost:1433;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.UserData VALUES (" + "'" + userID + "','" + phone + "','" + address + "','" + payment + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertUserFlowers(int userID,int flowerID,int count,int summ)
    {
        String url = "jdbc:sqlserver://localhost:55322;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.UserFlowers VALUES (" + "'" + userID + "','" + flowerID + "','" + count + "','" + summ + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertBouquet(int fl_id,int ac_id,String name,String description,int price)
    {
        String url = "jdbc:sqlserver://localhost:55322;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.Bouquet VALUES (" + "'" + fl_id + "','" + ac_id + "','" + name + "','" + description + "','" + price + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertUserBouquets(int userID,int bou_id)
    {
        String url = "jdbc:sqlserver://localhost:55322;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.UserBouquets VALUES (" + "'" + userID + "','" + bou_id + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertAcces(String name,int price,String colour)
    {
        String url = "jdbc:sqlserver://localhost:55322;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.Accessoirs VALUES (" + "'" + name + "','" + price + "','" + colour + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertMadedBouquets(int userID,int flow_id,int a_id,int price)
    {
        String url = "jdbc:sqlserver://localhost:55322;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.MadedBouquets VALUES (" + "'" + userID + "','" + flow_id + "','" + a_id + "','" + price + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
