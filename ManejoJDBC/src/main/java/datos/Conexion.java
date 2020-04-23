/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jaime Garfias
 */
public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }

    public static void closeRS(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void closeSM(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void closeCon(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
