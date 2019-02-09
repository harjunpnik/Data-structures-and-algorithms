import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class FileHandler implements Serializable{

	//	File Reader
	public static HashMap<Long, Account> readFromFile(){
		
		HashMap<Long, Account> accountListDB = new HashMap();
		String path = "AccountDataBase.txt";
		
		try {
			FileInputStream fileInput = new FileInputStream(new File(path));
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			
			accountListDB = (HashMap<Long, Account>) objectInput.readObject();
			
			fileInput.close();
			objectInput.close();
			
		}catch(ClassNotFoundException ex) {
			System.out.println("Class not found Exception: " + ex.getMessage());
		}catch(FileNotFoundException ex) {
			System.out.println("File not found Exception: " + ex.getMessage());
		}catch(IOException ex){
			System.out.println("Input/output Exception: " + ex.getMessage());
		}
		
		return accountListDB;
	}
	
	//	File Writer
	public static void saveToFile(HashMap<Long, Account> accountList){
		
		try {
			FileOutputStream fileOutput = new FileOutputStream(new File("AccountDataBase.txt"));
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			
			objectOutput.writeObject(accountList);
			
			fileOutput.close();
			objectOutput.close();
			
		}catch(IOException ex) {
			System.out.println("Input/output Exception: " + ex.getMessage());
		}
	}	
}
