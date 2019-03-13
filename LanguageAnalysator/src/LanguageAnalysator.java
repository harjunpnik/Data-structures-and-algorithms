import java.util.HashMap;

public class LanguageAnalysator {

	public static void main (String[]args){
		
		//	Creates the language instances and calculates all the known values
		HashMap<String, Language> languages = Functions.createLanguages();

		//	User inputs a string
		String userInput = Ui.startText();
		//	Creates instance of user input and calculates its values
		Language userText = new Language("UserInput", "Hej Kalle! Hur gammal är du?");

		//	Creates instance of LanguageStats that calculates the differences
		LanguageStats stats = new LanguageStats(languages, userText);
		
		//	Pass the Result HashMap to UI to be displayed
		Ui.resultText(stats.getResult());		
		
	}
	
}
