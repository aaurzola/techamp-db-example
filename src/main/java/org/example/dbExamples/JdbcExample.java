package org.example.dbExamples;

import java.sql.*;

public class JdbcExample {

    static final String DB_URL = "jdbc:oracle:thin:@localhost:49161:xe";
    static final String USER = "d2";
    static final String PASS = "d2";


    public static void select() {
        try {
            //conectarme a la bd
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //preparar la sentencia sql
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM BOOK");
            while (rs.next()) {
                System.out.print(rs.getString("title"));
                System.out.print(rs.getString("author"));
                System.out.println(rs.getString("notes"));
            }

            //desconectarme de la bd
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void insert() {
        try {
            //Conectarme a la base de datos
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //Preparar la sentencia sql
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO BOOK (title, author, notes) VALUES (?, ?, ?)");
            pstm.setString(1, "El coronel");
            pstm.setString(2, "Gabriel");
            pstm.setString(3, "Este libro fue muy largo");

            //Ejecutar la sentencia sql
            pstm.executeQuery();

            //Desconectarme
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void delete() {
        try {
            //Conexion
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Preparar la sentencia SQL
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM BOOK b WHERE b.title = ?");
            pstm.setString(1, "La paloma");

            pstm.executeQuery();

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
