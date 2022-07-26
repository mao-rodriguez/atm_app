package com.atm;

import java.util.ArrayList;
import java.util.List;

import com.atm.BOLayer.Admin;
import com.fasterxml.jackson.core.JsonProcessingException;

import DataLayer.Data;
import LogicLayer.Logic;
// import ViewLayer.View;

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
        Admin admin = new Admin(logic.EncryptionDecryption("uch"), logic.EncryptionDecryption("5555"));
        Data data = new Data();
        data.AddToFile(admin, false);
        

        ArrayList<Admin> adminData = (ArrayList<Admin>) data.ReadAdminFile();
        try {
            data.saveToFile(adminData);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(Admin AdminObj : adminData){
            System.out.println(AdminObj.getPin());
        }

        // View view = new View();
        // view.loginScreen();
    }
}
