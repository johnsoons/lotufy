/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Subject;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author johnson
 */
public class SubjectDAO {
    public static ArrayList selectAll() throws SQLException, ClassNotFoundException {        
        String sql = "SELECT id, description FROM subject";
                
        Connection con = ConnectionDB.getConnection();
        Statement stmt = con.createStatement();                
        ResultSet rs = stmt.executeQuery(sql);
        
        ArrayList<Subject> subjects = new ArrayList<>();        
        
        while (rs.next()) {
            Subject s = new Subject();
            s.setId(rs.getInt("id"));
            s.setDescription(rs.getString("description"));
            subjects.add(s);
        }
        
        stmt.close();        
        con.close(); 
        
        return subjects;
    }
    
    public static Subject findByIndex(int index) throws SQLException, ClassNotFoundException {        
        ArrayList<Subject> subjects = selectAll();        
        return subjects.size() > 0 ? subjects.get(index) : new Subject();        
    }
}
