import java.util.Scanner;

public class LanguageAnalysator {

	public static void main (String[]args){
		
		Scanner scanner = new Scanner(System.in);
		
		Language german = new Language("German", FileInput.readFile("Deutch.txt"));
		Language estonian = new Language("Estonian", FileInput.readFile("Eesti.txt"));
		Language english = new Language("English", FileInput.readFile("English.txt"));
		Language french = new Language("French", FileInput.readFile("francais.txt"));
		Language italian = new Language("Italian", FileInput.readFile("Italiano.txt"));
		Language norwegian = new Language("Norwegian", FileInput.readFile("Norsk.txt"));
		Language finnish = new Language("Finnish", FileInput.readFile("Suomi.txt"));
		Language swedish = new Language("Swedish", FileInput.readFile("Svenska.txt"));
		
		System.out.println(german.getLanguageLabel() + " First char " + german.getFirstCharDistribution());
		System.out.println(german.getLanguageLabel() + " Singel char " + german.getSingelCharDistribution());
		System.out.println(german.getLanguageLabel() + " Three char " + german.getThreeCharDistribution());	
		
		Ui.startText();
		String userInput = scanner.nextLine();
		System.out.println(userInput);
		Language userText = new Language("UserInput", userInput);
		
		System.out.println(userText.getLanguageLabel() + " First char " + userText.getFirstCharDistribution());
		System.out.println(userText.getLanguageLabel() + " Singel char " + userText.getSingelCharDistribution());
		System.out.println(userText.getLanguageLabel() + " Three char " + userText.getThreeCharDistribution());	
		
		System.out.println(userText.getParsedContent());
	}
	
}
