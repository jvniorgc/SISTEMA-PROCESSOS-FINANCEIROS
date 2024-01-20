/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pedro
 */
public class DataTransaction {
    int idTransaction;
    float valueTransation;
    int startAccount;
    int finalAccount;

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public float getValueTransation() {
        return valueTransation;
    }

    public void setValueTransation(float valueTransation) {
        this.valueTransation = valueTransation;
    }

    public int getStartAccount() {
        return startAccount;
    }

    public void setStartAccount(int startAccount) {
        this.startAccount = startAccount;
    }

    public int getFinalAccount() {
        return finalAccount;
    }

    public void setFinalAccount(int finalAccount) {
        this.finalAccount = finalAccount;
    }
    
}// class
