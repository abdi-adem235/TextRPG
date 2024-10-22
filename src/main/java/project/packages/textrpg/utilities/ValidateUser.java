package project.packages.textrpg.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ValidateUser {
	
	String user;
	String password;
	
	
	    private Map<String, String> userMap = new HashMap<>();

	    public void loadUsers() {
	        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/project/packages/textrpg/userpassword.txt"))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split("\\s+",2);
	                if (parts.length >= 2) {
	                    userMap.put(parts[0], parts[1]);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public boolean validateUser(String username, String password) {
	        return userMap.containsKey(username) && userMap.get(username).equals(password);
	    }

	
	

}
