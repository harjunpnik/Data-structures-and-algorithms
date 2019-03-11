import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Language {

	private ArrayList<String> content;
	private String languageLabel;
	private HashMap <String, Double> singelCharDistribution = new HashMap<String, Double>();
	private HashMap <String, Double> firstCharDistribution = new HashMap<String, Double>();
	private HashMap <String, Double> threeCharDistribution = new HashMap<String, Double>();
	
	public Language(String languageLabel, ArrayList<String> content) {
		setLanguageLabel(languageLabel);
		setContent(content);
		calcFirstCharDistribution();
		calcSingelCharDistribution();
	}
	
	private void setLanguageLabel(String languageLabel) {
		this.languageLabel = languageLabel;
	}
	
	private void setContent(ArrayList<String> content) {
		this.content = content;
	}
	
	public String getLanguageLabel() {
		return languageLabel;
	}
	
	public ArrayList <String> getContent(){
		return content;
	}
	
	public String getString() {
		String listString = String.join("", content).toLowerCase();
		
		return listString;
	}
	
	public HashMap <String, Double> getFirstCharDistribution(){
		return firstCharDistribution;
	}
	
	public HashMap <String, Double> getSingelCharDistribution(){
		return singelCharDistribution;
	}
	
	private void calcFirstCharDistribution() {
		//Temporary text String
		String tempText = ""; 
		//Takes first letter from each word in array
		for(String letter : content) {
			tempText += letter.toLowerCase().charAt(0);
		}
		
		//Char array that is sorted
		char[] chars = tempText.toCharArray();
		Arrays.sort(chars);
		//amount of letters
		double charDistributionLength = chars.length;
		
		//Loop that saves amount of each unique character
		for(char character : chars) {
			String tempChar = String.valueOf(character);
			
			if(firstCharDistribution.containsKey(tempChar)) {
				firstCharDistribution.put(tempChar,firstCharDistribution.get(tempChar) + 1);
			}else {
				firstCharDistribution.put(tempChar, 1.);
			}
		}
		
		//Loop through list and assign percentage value
		for(String key : firstCharDistribution.keySet()) {
			firstCharDistribution.put(key, firstCharDistribution.get(key) / charDistributionLength );
		}
	} 
	
	private void calcSingelCharDistribution() {
		String result = String.join("", content).toLowerCase();
        System.out.println(result);
        char[] chars = result.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
        
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
      	for(String key : singelCharDistribution.keySet()) {
      		singelCharDistribution.put(key, singelCharDistribution.get(key) / charDistributionLength );
      	}
	}
	
	
	//FOR TESTING ONLY
	public String getStringFirstChar() {
		String tempText = ""; 
		for(String letter : content) {
			tempText += letter.toLowerCase().charAt(0);
		}
		System.out.println(tempText);
		char[] chars = tempText.toCharArray();
		Arrays.sort(chars);
		String sortedText = new String(chars);
		
		System.out.println(sortedText.length());
		System.out.println(sortedText);
		
		double charDistributionLength = sortedText.length();
		
		for(char character : chars) {
			//System.out.print(character);
			String tempChar = String.valueOf(character);
			
			//if hashmap contains key then 
			// hashmap.put word , word.get +1
			//else
			// hahsmap .put word , 1
			if(firstCharDistribution.containsKey(tempChar)) {
				//System.out.println("true");
				firstCharDistribution.put(tempChar,firstCharDistribution.get(tempChar) + 1);
			}else {
				firstCharDistribution.put(tempChar, 1.);
			}
		}
		
		//Loop through list and assign percentage value
		for(String key : firstCharDistribution.keySet()) {
			System.out.print(key);
			System.out.print(firstCharDistribution.get(key));
			firstCharDistribution.put(key, firstCharDistribution.get(key) / charDistributionLength );
		}
		
		System.out.println();
		System.out.println(firstCharDistribution);

		
		
		
		return sortedText;
	}
	
}
