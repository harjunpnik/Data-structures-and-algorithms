import java.util.HashMap;
import java.util.Scanner;

public class LanguageAnalysator {

	public static void main (String[]args){
		
		Scanner scanner = new Scanner(System.in);
		
		HashMap<String, Language> languages = Functions.createLanguages();
		
		System.out.println(languages.get("German").getLanguageLabel() + " First char " + languages.get("German").getFirstCharDistribution());
		System.out.println(languages.get("German").getLanguageLabel() + " Three char " + languages.get("German").getThreeCharDistribution());
		System.out.println(languages.get("German").getLanguageLabel() + " Singel char " + languages.get("German").getSingleCharDistribution());	
		
		Ui.startText();
		//String userInput = scanner.nextLine();
		//System.out.println(userInput);
		Language userText = new Language("UserInput", "mayakeskus, joka kuitenkin hylättiin mayojen huippukauden aikana. Vuonna 1502 Kristoffer Kolumbus saapui ");
		
		System.out.println(userText.getLanguageLabel() + " First char " + userText.getFirstCharDistribution());
		System.out.println(userText.getLanguageLabel() + " Singel char " + userText.getSingleCharDistribution());
		System.out.println(userText.getLanguageLabel() + " Three char " + userText.getThreeCharDistribution());	
		
		System.out.println(userText.getParsedContent());
		
		LanguageStats test = new LanguageStats(languages, userText);
		System.out.println(test.getResult());
		
		Ui.resultText(test.getResult());
		
		scanner.close();
	}
	
}
