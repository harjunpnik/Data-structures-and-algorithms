import java.util.ArrayList;

public class LanguageAnalysator {

	public static void main (String[]args){
		String msg = FileInput.readFile("Deutch.txt");
		ArrayList<String> words = FileInput.regexTest(msg);
		System.out.println(words);
		System.out.println(words.get(1));
		
		for(String str : words) {
			System.out.println(str);;
		}
		
	}
	
}
