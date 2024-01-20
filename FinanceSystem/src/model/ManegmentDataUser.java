/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author pedro
 */
public class ManegmentDataUser {
    public static void insertUser(DataUser DU) throws SQLException
    {
        try {
            Connection conn = ConnectionDB.conection();
            Statement sql = conn.createStatement();
            String query = "insert into accountUser values(null,'"+DU.getIdUser()+"','"+DU.getName()+"','"+DU.getCpf()+"','"+DU.getEmail()+"','"+DU.getPassword()+"');";
            sql.execute(query);
            sql.close();
            conn.close();
        } catch (SQLException error) {
            throw new SQLException("Error in insert new user "+error.getMessage());
        }
    }// method insert

    public static void deleteUser(DataUser DU) throws SQLException
    {
        try {
             Connection conn = ConnectionDB.conection();
            Statement sql = conn.createStatement();
            String query = "delete from accountUser where  id ="+DU.getIdUser();
            sql.execute(query);
            sql.close();
            conn.close();
        } catch (SQLException error) {
            throw new SQLException("Erro to delete this user"+error.getMessage());
        }
    }// method deleteUser
     public static void atualizeUser(DataUser DU) throws SQLException
    {
        try {
             Connection conn = ConnectionDB.conection();
            Statement sql = conn.createStatement();
            String query = "update accountUser SET nameUser='"+DU.getName()+"', cpf='"+DU.getCpf()+"', email='"+DU.getEmail()+"' where id="+DU.getIdUser()+";";
            sql.executeUpdate(query);
            sql.close();
            conn.close();
        } catch (SQLException error) {
            throw new SQLException("Error in update this user "+error.getMessage());
        }
    }// method atualizeUser
     public static void atualizePassword(DataUser DU) throws SQLException
    {
        try {
             Connection conn = ConnectionDB.conection();
            Statement sql = conn.createStatement();
            String query = "update accountUser SET passwords = '"+DU.getPassword()+"' where id="+DU.getIdUser()+";";
            sql.executeUpdate(query);
            sql.close();
            conn.close();
        } catch (SQLException error) {
            throw new SQLException("Error at update the password "+error.getMessage());
        }
    }// method atualize password user
      public static ArrayList<DataUser> login(DataUser DU) throws SQLException
    {
       try { 
    
           Connection conn = ConnectionDB.conection();
            Statement sql = conn.createStatement();
            String query = "SELECT id, cpf, passwords FROM accountUser WHERE cpf = '" + DU.getCpf() + "' AND passwords = '" + DU.getPassword() + "';";
            ResultSet  Rs = sql.executeQuery(query);
            ArrayList<DataUser> DataLogin = new ArrayList<>();
            while(Rs.next())
            {
                DU.setCpf(Rs.getString("cpf"));
                DU.setPassword(Rs.getString("passwords"));
                DU.setIdUser (Integer.parseInt(Rs.getString("id")));
                DataLogin.add(DU);
            } // end while
            sql.close();
            conn.close();
            return DataLogin;
       } catch (SQLException error) {
            throw new SQLException("Error in verify login"+error.getMessage());
        }
    }// method login
      public static ArrayList<DataBankAccount> listAllBankAccount(DataUser DU) throws SQLException
    {
       try { 
            
           Connection conn = ConnectionDB.conection();
            Statement sql = conn.createStatement();
            String query = "SELECT * from bankAccount WHERE userId = "+DU.getIdUser()+";";
            ResultSet  Rs = sql.executeQuery(query);
            ArrayList<DataBankAccount> lista = new ArrayList<>();
             while(Rs.next())
            {       
                DataBankAccount DBA = new DataBankAccount();
                DBA.setIdAccount(Integer.parseInt(Rs.getString("id")));
                DBA.setPassword(Rs.getString("passwords"));
                DBA.setBalance(Float.parseFloat(Rs.getString("balance")));
                DBA.setUserId(Integer.parseInt(Rs.getString("userId")));
                DBA.setBankId(Integer.parseInt(Rs.getString("bankId")));
                lista.add(DBA);
            } // end while
            sql.close();
            conn.close();
            return lista;
       } catch (SQLException error) {
            throw new SQLException("Error at get your bank account login"+error.getMessage());
        }
    }// method listAllBankAccount  
}// class
