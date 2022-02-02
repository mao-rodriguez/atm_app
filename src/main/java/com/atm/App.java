package com.atm;

import com.atm.BOLayer.Admin;

import DataLayer.Data;
import LogicLayer.Logic;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Code Used to write an admin to the file

        Logic logic = new Logic();
        Admin admin = new Admin(logic.EncryptionDecryption("Yexx"), logic.EncryptionDecryption("80006"));
        Data data = new Data();
        data.AddToFile(admin);
    }
}
