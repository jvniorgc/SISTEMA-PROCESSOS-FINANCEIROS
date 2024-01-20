/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.DataUser;
import model.ManegmentDataUser;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DataBankAccount;
/**
 *
 * @author gabri
 */
public class GestManegmentDataUser {
    
    public void insertUser(DataUser DU) throws SQLException{
        ManegmentDataUser.insertUser(DU);
    }//insert user

    public void deleteUser(DataUser DU) throws SQLException{
        ManegmentDataUser.deleteUser(DU);
    }//delete user
    
    public void atualizeUser(DataUser DU) throws SQLException{
        ManegmentDataUser.atualizeUser(DU);
    }//update user

    public void atualizePassword(DataUser DU) throws SQLException{
        ManegmentDataUser.atualizePassword(DU);
    }//Update user password

    public ArrayList<DataUser> login(DataUser DU) throws SQLException{
        return ManegmentDataUser.login(DU);
    }//login

    public ArrayList<DataBankAccount> listBankingAccount(DataUser DU) throws SQLException{
        return ManegmentDataUser.listAllBankAccount(DU);
    }//list Bank Accounts
}
