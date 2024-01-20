
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionDB {
    
    private static final String URL= "jdbc:mysql://localhost:3306/financeSystem?useTimeZone=true&serverTimeZone=UTC";
    private static final String USER="root";
    private static final String PASSWORD="";
    
    public static Connection conection() throws SQLException
    {
        try{
        return DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(SQLException error)
        {
            throw new SQLException("Error in try connection. ERROR "+error.getMessage());
        }
    }// method  jdbc:mysql://localhost:3306/financeSystem
}// class
