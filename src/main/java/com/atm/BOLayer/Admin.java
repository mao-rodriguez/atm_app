package com.atm.BOLayer;

public class Admin implements java.io.Serializable{
    private String Username;
    private String Pin;
    
    public Admin(String username, String pin) {
        Username = username;
        Pin = pin;
    }

    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getPin() {
        return Pin;
    }
    public void setPin(String pin) {
        Pin = pin;
    }
}
