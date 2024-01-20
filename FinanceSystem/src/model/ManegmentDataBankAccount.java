/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.DataUser;
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
 * @author pedro
 */
public class ManegmentDataBankAccount {
    public static void insertBankAccount(DataUser DU,DataBankAccount DBA) throws SQLException
    {
        try {
            Connection conn = ConnectionDB.conection();
            Statement sql = conn.createStatement();
            String query = "insert into bankAccount values(null,'"+DBA.getPassword()+"',"+DBA.getBalance()+","+DBA.getUserId()+","+DBA.getBankId()+");";
            sql.execute(query);
            sql.close();
            conn.close();
        } catch (SQLException error) {
            throw new SQLException("Error at create new bank account user "+error.getMessage());
        }
    }// method insert
    public static void deleteBankAccount(DataBankAccount DBA, DataTransaction DT) throws SQLException
    {
        try {
             Connection conn = ConnectionDB.conection();
            Statement sqlDeleteTransactions = conn.createStatement();
            String queryDeleteTrasaction = "delete from transactions where  id ="+DBA.getIdAccount()+";";
            sqlDeleteTransactions.execute(queryDeleteTrasaction);
            sqlDeleteTransactions.close();
            Statement sql = conn.createStatement();
            String query = "delete from bankAccount where  id ="+DBA.getIdAccount();
            sql.execute(query);
            sql.close();
            conn.close();
        } catch (SQLException error) {
            throw new SQLException("Error at delete this bank account "+error.getMessage());
        }
    }// method deleteBankAccount
    
    public static void atualizeBalanceBankAccount(DataBankAccount DBA) throws SQLException
    {
        try {
             Connection conn = ConnectionDB.conection();
            Statement sql = conn.createStatement();
            String query = "update bankAccount SET balance="+DBA.getBalance()+";";
            sql.executeUpdate(query);
            sql.close();
            conn.close();
        } catch (SQLException error) {
            throw new SQLException("Error in update the balance "+error.getMessage());
        }
    }// method atualizeBalanceBankAccount
    public static void atualizePasswordBankAccount(DataBankAccount DBA) throws SQLException
    {
        try {
            Connection conn = ConnectionDB.conection();
            Statement sql = conn.createStatement();
            String query = "update bankAccount SET passwords="+DBA.getPassword()+";";
            sql.executeUpdate(query);
            sql.close();
            conn.close();
        } catch (SQLException error) {
            throw new SQLException("Error at update this password "+error.getMessage());
        }
    }// method atualizePasswordBankAccount
    public static void insertTransaction(DataBankAccount DBA, DataTransaction DT) throws SQLException
    {
        try {
            Connection conn = ConnectionDB.conection();
            Statement sql = conn.createStatement();
            String query = "insert into transactions values(null,"+DT.getValueTransation()+"NOW(),"+DBA.getUserId()+","+DT.getFinalAccount()+");";
            sql.executeUpdate(query);
            sql.close();
            conn.close();
        } catch (SQLException error) {
            throw new SQLException("Error at insert transaction "+error.getMessage());
        }
    }// method insertTransaction
    public static ArrayList<DataBankAccount> listAllBankAccountSystem() throws SQLException
    {
       try { 
           Connection conn = ConnectionDB.conection();
            Statement sql = conn.createStatement();
            String query = "SELECT * from  bankAccount;";
            ResultSet  Rs = sql.executeQuery(query);
            ArrayList<DataBankAccount> listAllBankAccountSystem = new ArrayList<>();
            while(Rs.next())
            {
                DataBankAccount DBA = new DataBankAccount();
                DBA.setIdAccount(Rs.getInt("id"));
                DBA.setUserId(Rs.getInt("userId"));
                DBA.setBankId(Rs.getInt("bankId"));
                listAllBankAccountSystem.add(DBA);
            } // end while
            sql.close();
            conn.close();
            return listAllBankAccountSystem;
       } catch (SQLException error) {
            throw new SQLException("Error in verify login"+error.getMessage());
        }
    }// method listAllBankAccount
    
    
public static void PDFtransactions( DataBankAccount DBA) throws SQLException, DocumentException {
    Document document = null;
    PdfWriter writer = null;

    try { 
        System.out.println("cheguei no metodo");
        Connection conn = ConnectionDB.conection();
        Statement sql = conn.createStatement();
        System.out.println("id passado -> "+DBA.getIdAccount());
        String query = "SELECT * from  transactions WHERE startAccountId = "+DBA.getIdAccount()+";";
        ResultSet  Rs = sql.executeQuery(query);

        document = new Document();
        try {
     
           writer = PdfWriter.getInstance(document, new FileOutputStream("transactionsPDF.pdf"));
        document.open(); 
        } catch (FileNotFoundException e) {
            System.out.println("Error -> "+e.getMessage());
        }
 
        while(Rs.next()) {
            int id = Rs.getInt("id");
            float value = Rs.getFloat("valueTransaction");
            String date = Rs.getString("dateTransaction");
            int finalAccountId = Rs.getInt("finalAccountId");
            try {
                Paragraph paragraph = new Paragraph("ID transação: " + id);
                paragraph.add("\n Valor: " + value);
                paragraph.add("\nData: " + date);
                paragraph.add("\nConta Final: " + finalAccountId);
                paragraph.add("\n\n"); // blank line in transactions
                document.add(paragraph);
            } catch (DocumentException errorPDF) {
                System.out.println("ERROR at add paragraph: " + errorPDF.getMessage());
            }
        }

        System.out.println("Após o loop while");
    } catch (SQLException error) {
        throw new SQLException("Error in verify login"+error.getMessage());
    } finally {
        if (document != null) {
            document.close();
        }
        if (writer != null) {
            writer.close();
        }
    }
}




}// class
