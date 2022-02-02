package LogicLayer;

public class Logic {
    
    
    public String EncryptionDecryption(String username) {
        String output = "";
        char[] ch = username.toCharArray();
        for (char c : ch) {

            if(c >= 'A' && c <= 'Z'){
                output += (char)('Z' - (c - 'A'));

            } else if(c >= 'a' && c <= 'z'){
                output += (char)('z' - (c - 'a'));
                
            } else if(c >= '0' && c <= '9'){
                output += 9 - Character.getNumericValue(c);
            }
        }
        return output;
    }
}
