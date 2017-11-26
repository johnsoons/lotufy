/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shayron
 */
public class PostgreSQL {
 
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "P@ssWordLocal";

    public PostgreSQL() {
        this.createSchema();
    }
 
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conectado no banco de dados.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }

    public void createSchema() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = this.connect();
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS TESTE( id int PRIMARY KEY, nome char(60) );";
            stmt.execute(sql);
            System.out.println("Schema criado.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(stmt!=null)
                stmt.close();
            } catch(SQLException se2) {
            }// nothing we can do
            try {
               if(conn!=null)
                  conn.close();
            } catch(SQLException se) {
               se.printStackTrace();
            }
        }
    }
}
