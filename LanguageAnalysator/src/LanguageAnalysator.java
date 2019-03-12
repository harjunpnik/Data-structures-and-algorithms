import java.util.ArrayList;

public class LanguageAnalysator {

	public static void main (String[]args){
		ArrayList<String> words = FileInput.readFile("English.txt");
		//System.out.println(words);
		//System.out.println(words.get(1));
		
//		for(String str : words) {
//			System.out.println(str);;
//		}
		
		Language testLang = new Language("Test Lan", words);
		//System.out.println(testLang.getContent());
		//System.out.println(testLang.getString());
		//System.out.println(testLang.getStringFirstChar());
		//testLang.getStringFirstChar();
		
		
		System.out.println("END");
		System.out.println(testLang.getLanguageLabel() + " " + testLang.getFirstCharDistribution());
		System.out.println(testLang.getLanguageLabel() + " " + testLang.getSingelCharDistribution());
		System.out.println(testLang.getLanguageLabel() + " " + testLang.getThreeCharDistribution());
	}
	
}
