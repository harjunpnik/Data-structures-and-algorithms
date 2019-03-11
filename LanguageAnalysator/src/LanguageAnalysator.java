import java.util.ArrayList;

public class LanguageAnalysator {

	public static void main (String[]args){
		ArrayList<String> words = FileInput.readFile("Deutch.txt");
		System.out.println(words);
		System.out.println(words.get(1));
		
//		for(String str : words) {
//			System.out.println(str);;
//		}
		
		Language german = new Language("German", words);
		System.out.println(german.getContent());
		
		
	}
	
}
