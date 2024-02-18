package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.*;

public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {
                
                ResultSetMetaData rsmd = rs.getMetaData();
                
                while (rs.next()) {
                    
                    int columns = rsmd.getColumnCount();
                    LinkedHashMap<String, String> json = new LinkedHashMap();                    
                    
                    for (int i = 0; i < columns; i++) {
                        json.put(rsmd.getColumnLabel(i + 1), rs.getString(i + 1));
                    }
                    
                    
                    records.add(json);
                }            
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
