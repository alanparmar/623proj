package grp8;

import java.sql.*;

public class group8 {

    public static void main(String[] args) throws SQLException {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");             //jdbc

        } catch (ClassNotFoundException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/v_project", "root", "root");   //connection object 

        conn.setAutoCommit(false);   //for atomicty 

        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);   //isolation
 
        Statement stmt1 = null;

        try {

            stmt1 = conn.createStatement();

            // stmt1.executeUpdate("insert into product values('p6','radio',65)");

            stmt1.executeUpdate("DELETE FROM `v_project`.`depot` WHERE (`dep_id` = 'd1')");

            // stmt1.executeUpdate("DELETE FROM `project`.`stock` WHERE (`dep_id` = 'd1')");

        } catch (SQLException e) {

            System.out.println("An exception was thrown");

            e.printStackTrace();

            conn.rollback();

            stmt1.close();

            conn.close();

            return;

        }

        conn.commit();

        stmt1.close();

        conn.close();

        System.out.println("Object deleted!");
    }
}