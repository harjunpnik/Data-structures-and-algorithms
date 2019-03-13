import java.util.HashMap;

public class Functions {

	//	Creates the Language instances and returns a HashMap containing all of them
	public static HashMap<String, Language> createLanguages(){
		
		Language german = new Language("German", FileInput.readFile("Deutch.txt"));
		Language estonian = new Language("Estonian", FileInput.readFile("Eesti.txt"));
		Language english = new Language("English", FileInput.readFile("English.txt"));
		Language french = new Language("French", FileInput.readFile("francais.txt"));
		Language italian = new Language("Italian", FileInput.readFile("Italiano.txt"));
		Language norwegian = new Language("Norwegian", FileInput.readFile("Norsk.txt"));
		Language finnish = new Language("Finnish", FileInput.readFile("Suomi.txt"));
		Language swedish = new Language("Swedish", FileInput.readFile("Svenska.txt"));
		
		HashMap<String, Language> languages = new HashMap<String, Language>();
		languages.put(german.getLanguageLabel(), german);
		languages.put(estonian.getLanguageLabel(), estonian);
		languages.put(english.getLanguageLabel(), english);
		languages.put(french.getLanguageLabel(), french);
		languages.put(italian.getLanguageLabel(), italian);
		languages.put(norwegian.getLanguageLabel(), norwegian);
		languages.put(finnish.getLanguageLabel(), finnish);
		languages.put(swedish.getLanguageLabel(), swedish);
		
		return languages;
	}
	
}
