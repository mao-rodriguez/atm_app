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
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Data {
    
    // Appends object to a file in json format
    public <T> void AddToFile(T obj){
        String fileBoString = null;
        String jsonString = null;
        fileBoString = getFileToWrite(obj, fileBoString);

        try (FileWriter fWriter = new FileWriter(fileBoString, true);){
            ObjectMapper mapper = new ObjectMapper();
            jsonString = mapper.writeValueAsString(obj);

            fWriter.write(jsonString + System.lineSeparator());

            // Serialize the object and save the binary data
            // FileOutputStream fileOut = new FileOutputStream(Admin);
            // ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // out.writeObject(obj);
            // out.close();
            // fileOut.close();
        
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    // Choose the write file to store an object.
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

    // Returns a list of objects from a file
    public <T> ArrayList<T> ReadFile(String FileName){
        // List<String> lines = Collections.emptyList();
        // List<Admin> list= new ArrayList<Admin>();
        // ObjectMapper mapper = new ObjectMapper();
        // try {
        //     lines = Files.readAllLines(Paths.get("Admin.txt"));
        //     for(String Obj : lines){
        //         Admin adminObject = mapper.readValue(Obj, Admin.class);
        //         list.add(adminObject);
        //         System.out.println(Obj);
        //     }
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        List<String> lines = Collections.emptyList();
        List<T> list= new ArrayList<T>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            lines = Files.readAllLines(Paths.get(FileName+".txt"));
            //List<Admin> myAdmins = mapper.readValue(lines, new TypeReference<List<Admin>>(){ });
            //assertThat(asList.get(0), instanceOf(Admin.class));
            for(String Obj : lines){
                Admin adminObject = mapper.readValue(Obj, Admin.class);
                list.add(adminObject);
                //System.out.println(Obj);
            }
            for(Admin AdminObj : list){
                System.out.println(AdminObj.getUsername());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
        
    }

    public <T> ArrayList<T> ReadFile2(String FileName, Class<?> contentClass){
        
        List<String> lines = Collections.emptyList();
        List<T> list= new ArrayList<T>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            //JavaType type = mapper.getTypeFactory().constructParametricType(Data.class, contentClass);
            lines = Files.readAllLines(Paths.get(FileName+".txt"));
            
            for(String Obj : lines){
                
                list.add(mapper.readValue(Obj, contentClass));
                //System.out.println(Obj);
            }
            for(Admin AdminObj : list){
                System.out.println(AdminObj.getUsername());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
        
    }
    
    public static <T> List<T> parseJsonArray(String json,Class<T> classOnWhichArrayIsDefined)throws IOException, ClassNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        Class<T[]> arrayClass = (Class<T[]>) Class.forName("[L" + classOnWhichArrayIsDefined.getName() + ";");
        T[] objects = mapper.readValue(json, arrayClass);
        return Arrays.asList(objects);
}
}
