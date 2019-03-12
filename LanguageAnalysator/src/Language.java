import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Language {

	//	VARIABELS
	private String content;
	private ArrayList<String> parsedContent;
	private String languageLabel;
	private HashMap <String, Double> singelCharDistribution = new HashMap<String, Double>();
	private HashMap <String, Double> firstCharDistribution = new HashMap<String, Double>();
	private HashMap <String, Double> threeCharDistribution = new HashMap<String, Double>();
	
	//	CONSTRUCTOR
	public Language(String languageLabel, String content) {
		setLanguageLabel(languageLabel);
		setContent(content);
		parseData(content);
		calcFirstCharDistribution();
		calcSingelCharDistribution();
		calcThreeCharDistribution();
	}
	
	//	SET
	private void setLanguageLabel(String languageLabel) { this.languageLabel = languageLabel; }
	
	private void setContent(String content) { this.content = content; }
	
	//	GET
	public String getLanguageLabel() { return languageLabel; }
	
	public String getContent(){ return content; }
	
	public HashMap <String, Double> getFirstCharDistribution(){ return firstCharDistribution; }
	
	public HashMap <String, Double> getSingelCharDistribution(){ return singelCharDistribution; }
	
	public HashMap <String, Double> getThreeCharDistribution(){ return threeCharDistribution; }
	
	//	PARSE DATA METHOD
	//	This method takes the text string and saves the parsed data in parsedContent variable
	private void parseData(String text) {
		// Regex for Deutch,Estonina,English,French,Italian,Norwegian,Finnish,Swedish
		// This regex will only pass letters from the above mentioned languages
		String regex = "[^A-Za-zÂ≈‰ƒˆ÷Ê∆¯ÿ¿‡‚¬Á«È…Ë»Í ÎÀÏÃÌÕÓŒÔœÚ“Û”Ù‘ı’öäﬂúå˘Ÿ˙⁄˚€¸‹ˇüûé ]";
		String tempText;
		tempText = text.replaceAll(regex, "");
		//System.out.println(tempText);
		// Lastly it splits the string into an ArrayList on one or more spaces 
		ArrayList<String> words = new ArrayList<>(Arrays.asList(tempText.split("\\s+")));
		//System.out.println(words);
		this.parsedContent = words;
	}
	
	//	CALC FIRST CHAR DISTRIBUTION METHOD
	//	This method calculates the character distribution of first letter in each word
	private void calcFirstCharDistribution() {
		//Temporary text String
		String tempText = ""; 
		//Takes first letter from each word in array
		for(String letter : parsedContent) {
			tempText += letter.toLowerCase().charAt(0);
		}
		
		//Char array that is sorted
		char[] chars = tempText.toCharArray();
		Arrays.sort(chars);
		//amount of letters
		double charDistributionLength = chars.length;
		//System.out.println(chars);
		//Loop that saves amount of each unique character
		//TODO Decide if this is going to be separate method for first char and singel char 
		for(char character : chars) {
			String tempChar = String.valueOf(character);
			
			if(firstCharDistribution.containsKey(tempChar)) {
				firstCharDistribution.put(tempChar,firstCharDistribution.get(tempChar) + 1);
			}else {
				firstCharDistribution.put(tempChar, 1.);
			}
		}
		
		//Loop through list and assign percentage value
      	calculateFrequency(firstCharDistribution, charDistributionLength);
	} 
	
	private void calcSingelCharDistribution() {
		String result = String.join("", parsedContent).toLowerCase();
        //System.out.println(result);
        char[] chars = result.toCharArray();
        Arrays.sort(chars);
        //System.out.println(chars);
        
        //amount of letters
      	double charDistributionLength = chars.length;
      	
      	//Loop that saves amount of each unique character
      	for(char character : chars) {
      		String tempChar = String.valueOf(character);
      		
      		if(singelCharDistribution.containsKey(tempChar)) {
      			singelCharDistribution.put(tempChar,singelCharDistribution.get(tempChar) + 1);
      		}else {
      			singelCharDistribution.put(tempChar, 1.);
      		}
      	}
      	
      	//Loop through list and assign percentage value
      	calculateFrequency(singelCharDistribution, charDistributionLength);
	}
	
	private void calcThreeCharDistribution() {
		String result = String.join("", parsedContent).toLowerCase();
        //System.out.println(result);
        char[] chars = result.toCharArray();
        
        //amount of letters
      	double charDistributionLength = chars.length;
      	
      	for(int i=0; i< charDistributionLength - 2; i++) {
      		String tempChar = String.valueOf(chars[i] +""+ chars[i+1] +""+ chars[i+2]);
      		
      		if(threeCharDistribution.containsKey(tempChar)) {
      			threeCharDistribution.put(tempChar,threeCharDistribution.get(tempChar) + 1);
      		}else {
      			threeCharDistribution.put(tempChar, 1.);
      		}
      	}
      	
      	//Loop through list and assign percentage value
      	calculateFrequency(threeCharDistribution, charDistributionLength);
      	
	}
	
	//	CALCULATE FREQUENCY
	//	Loop through list and assign percentage value
	private void  calculateFrequency(HashMap <String, Double> characterDistribution, double length){
		double charLength = length;
		HashMap <String, Double> charDistribution = characterDistribution;
      	for(String key : charDistribution.keySet()) {
      		charDistribution.put(key, charDistribution.get(key) / charLength );
      	}
	}
}
