package com.atm.BOLayer;

public class Customer {
    public String Username;
    public String Name;
    public String AccountType;
    public int Balance;
    public String Status;
    public int AccountNo;
    public String Pin;
    
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getAccountType() {
        return AccountType;
    }
    public void setAccountType(String accountType) {
        AccountType = accountType;
    }
    public int getBalance() {
        return Balance;
    }
    public void setBalance(int balance) {
        Balance = balance;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public int getAccountNo() {
        return AccountNo;
    }
    public void setAccountNo(int accountNo) {
        AccountNo = accountNo;
    }
    public String getPin() {
        return Pin;
    }
    public void setPin(String pin) {
        Pin = pin;
    }
}
