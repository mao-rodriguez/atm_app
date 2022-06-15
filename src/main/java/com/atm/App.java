package com.atm;

import com.atm.BOLayer.Admin;

import DataLayer.Data;
import LogicLayer.Logic;
import ViewLayer.View;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Code Used to write an admin to the file

        // Logic logic = new Logic();
        // Admin admin = new Admin(logic.EncryptionDecryption("Mao"), logic.EncryptionDecryption("8080"));
        Data data = new Data();
        //data.AddToFile(admin);
        data.ReadFile("Admin");

        // View view = new View();
        // view.loginScreen();
    }
}
