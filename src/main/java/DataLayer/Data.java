package DataLayer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.atm.BOLayer.Admin;
import com.atm.BOLayer.Customer;
import com.atm.BOLayer.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Data {
    
    // Appends object to a file in json format
    public <T> void AddToFile(ArrayList<T> obj, Boolean appending){
        String fileBoString = null;
        String jsonString = null;
        fileBoString = getFileToWrite(obj.get(0), fileBoString);

        try (FileWriter fWriter = new FileWriter(fileBoString, appending);){
// TODO: Fix the way string is write to the file, it may write each object in new line
            ObjectMapper mapper = new ObjectMapper();
            jsonString = mapper.writeValueAsString(obj);
            fWriter.write(jsonString + System.lineSeparator());

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    // Clears last data and save new list to file in json format
    public <T> void saveToFile(ArrayList<T> list) throws JsonProcessingException{
        
        if(list.get(0) instanceof Admin){
            AddToFile(list, false);
        }
        else if(list.get(0) instanceof Customer){
            AddToFile(list, false);
        }

        // Appends the other objects of list to the file

    }

    // Choose the file to store an object.
    private <T> String getFileToWrite(T obj, String fileBoString) {
        // Check what is the right file to write the object
        if(obj instanceof Admin){
            fileBoString = "Admin.txt";
        } else if(obj instanceof Customer){
            fileBoString = "Customer.txt";
        } else if(obj instanceof Transaction){
            fileBoString = "Transaction.txt";
        }
        return fileBoString;
    }

    // Returns a list of Admin objects from a file
    public List<Admin> ReadAdminFile(){
        List<String> lines = Collections.emptyList();
        List<Admin> list = new ArrayList<Admin>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            lines = Files.readAllLines(Paths.get("Admin.txt"));
            for(String Obj : lines){
                Admin adminObject = mapper.readValue(Obj, Admin.class);
                list.add(adminObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Returns a list of Customer objects from a file
    public List<Customer> ReadCustomerFile(String FileName){
        List<String> lines = Collections.emptyList();
        List<Customer> list = new ArrayList<Customer>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            lines = Files.readAllLines(Paths.get("Customer.txt"));
            for(String Obj : lines){
                Customer customerObject = mapper.readValue(Obj, Customer.class);
                list.add(customerObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Returns a list of Transaction objects from a file
    public List<Transaction> ReadTransactionsFile(String FileName){
        List<String> lines = Collections.emptyList();
        List<Transaction> list = new ArrayList<Transaction>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            lines = Files.readAllLines(Paths.get("Transaction.txt"));
            for(String Obj : lines){
                Transaction transactionObject = mapper.readValue(Obj, Transaction.class);
                list.add(transactionObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    

}
