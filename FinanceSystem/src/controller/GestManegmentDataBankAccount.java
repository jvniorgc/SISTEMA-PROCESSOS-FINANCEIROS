/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ManegmentDataBankAccount;
import model.DataUser;
import model.DataTransaction;
import model.DataBankAccount;
import model.ManegmentDataUser;
import java.sql.Statement;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;

/**
 *
 * @author gabri
 */
public class GestManegmentDataBankAccount {
    
    public void insertBankAccount(DataUser DU, DataBankAccount DBA) throws SQLException{
        ManegmentDataBankAccount.insertBankAccount(DU, DBA);
    }//insert bank account
    
    public void deleteBankAccount(DataBankAccount DBA, DataTransaction DT) throws SQLException{
        ManegmentDataBankAccount.deleteBankAccount(DBA, DT);
    }//insert bank account
    
    public void atualizeBalanceBankAccount(DataBankAccount DBA) throws SQLException{
        ManegmentDataBankAccount.atualizeBalanceBankAccount(DBA);
    }//insert bank account
    
    public void atualizePasswordBankAccount(DataBankAccount DBA) throws SQLException{
        ManegmentDataBankAccount.atualizePasswordBankAccount(DBA);
    }
    public void insertTransaction(DataBankAccount DBA , DataTransaction DT) throws SQLException{
        ManegmentDataBankAccount.insertTransaction(DBA, DT);
    }
    
    public ArrayList<DataBankAccount> listAllBankAccountSystem(DataUser DU) throws SQLException{
        return ManegmentDataUser.listAllBankAccount(DU);
    }
    
    public void PDFtransactions(DataBankAccount DBA) throws SQLException, DocumentException{
        ManegmentDataBankAccount.PDFtransactions(DBA);
        
    }

    
}//class
