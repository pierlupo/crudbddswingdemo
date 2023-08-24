package org.example.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String dataBase = "cruddbswing";
            String URL = "jdbc:mysql://localhost:3306/";
            Connection con = DriverManager.getConnection(URL + dataBase , "root" , "test");

            return con;


        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}