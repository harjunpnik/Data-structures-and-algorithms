import java.util.HashMap;

public class LanguageStats {
	
	//	VARIABELS
	private HashMap<String, Language> languages;
	private Language inputLanguage;
	private HashMap<String, double[]> result;
	
	//	CONSTRUCTOR	
	public LanguageStats(HashMap<String, Language> languages, Language inputLanguage) {
		setLanguages(languages);
		setInputLanguage(inputLanguage);
		guessLanguage();
	}
	
	//	SET
	private void setLanguages(HashMap<String, Language> languages) { this.languages = languages; }
	
	private void setInputLanguage(Language inputLanguage) { this.inputLanguage = inputLanguage; }
	
	private void setResult(HashMap<String, double[]> result) { this.result = result; }
	
	//	GET
	public HashMap<String, double[]> getResult(){ return result; }
	
	//	GUESS LANGUEAGE METHOD
	//	This method calculates the differences for each language and saves the result
	public void guessLanguage() {	
		//	This saves the result with the key being name of language and a double array containing [total, single, first, three] char differences in that order
		HashMap<String, double[]> result = new HashMap<String, double[]>();
		
		//	Loops every language and calculates the difference between input and language data
		for (HashMap.Entry<String, Language> lang : languages.entrySet()) {
		    String key = lang.getKey();
		    Language value = lang.getValue();
		    
		    //	Calculates input minus language data
		    double singleDiff = calcDifference(inputLanguage.getSingleCharDistribution(), value.getSingleCharDistribution());
		    double firstDiff = calcDifference(inputLanguage.getFirstCharDistribution(), value.getFirstCharDistribution());
		    double threeDiff = calcDifference(inputLanguage.getThreeCharDistribution(), value.getThreeCharDistribution());
		    double total = singleDiff + firstDiff + threeDiff;
		    total = total /3;
		    
		    double[] values = {total, singleDiff, firstDiff, threeDiff };
		    
		    result.put(key, values);
		    
		}
		
		//	Saves the result
		setResult(result);
		
	}
	
	//	CALC DIFFERENCE METHOD
	//	This method is called upon each calculation of difference. Returns the total difference in data tables
	public double calcDifference(HashMap<String, Double> inputLangValue, HashMap<String, Double> comparisonLangValue) {
		
		double totalDifference = 0;
		
		//	For every key in users input it checks if there is same key in languages data and adds the difference
		for (HashMap.Entry<String, Double> entry : inputLangValue.entrySet()) {
		    String key = entry.getKey();
		    Double value = entry.getValue();
		    
		    //	If same key is found take the absolute value of difference and add to total
		    if(comparisonLangValue.containsKey(key)) {
		    	double temp = Math.abs(value - comparisonLangValue.get(key));
		    	totalDifference += temp;
		    }else {
		    	//	Else add the value of user input
		    	totalDifference += value;
		    }

		}
		return totalDifference;
	}
	
}
