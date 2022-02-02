package DataLayer;

import java.io.*;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Data {
    private static final String Admin = "Admin.txt";

    public <T> void AddToFile(T obj) /*throws JsonProcessingException*/{
        String jsonString = null;
        
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonString = mapper.writeValueAsString(obj);

            System.out.println(jsonString);
            
            FileWriter fWriter = new FileWriter(Admin, true);
            
            fWriter.write(jsonString + System.lineSeparator());

            fWriter.close();

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
}
