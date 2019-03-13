import java.util.HashMap;

public class LanguageStats {

	private HashMap<String, Language> languages;
	private Language inputLanguage;
	private HashMap<String, double[]> result;
	
	
	public LanguageStats(HashMap<String, Language> languages, Language inputLanguage) {
		setLanguages(languages);
		setInputLanguage(inputLanguage);
		guessLanguage();
	}
	
	private void setLanguages(HashMap<String, Language> languages) {
		this.languages = languages;
	}
	
	private void setInputLanguage(Language inputLanguage) {
		this.inputLanguage = inputLanguage;
	}
	
	private void setResult(HashMap<String, double[]> result) {
		this.result = result;
	}
	
	public HashMap<String, double[]> getResult(){
		return result;
	}
	
	public void guessLanguage() {	
		HashMap<String, double[]> result = new HashMap<String, double[]>();
		
		for (HashMap.Entry<String, Language> lang : languages.entrySet()) {
		    String key = lang.getKey();
		    Language value = lang.getValue();
		    
		    double singleDiff = calcDifference(inputLanguage.getSingleCharDistribution(), value.getSingleCharDistribution());
		    double firstDiff = calcDifference(inputLanguage.getFirstCharDistribution(), value.getFirstCharDistribution());
		    double threeDiff = calcDifference(inputLanguage.getThreeCharDistribution(), value.getThreeCharDistribution());
		    double total = singleDiff + firstDiff + threeDiff;
		    total = total /3;
		    System.out.println(key + " s: "  + singleDiff + " f: " + firstDiff + " t: " + threeDiff + " total: " + total);
		    
		    double[] tempo = {total, singleDiff, firstDiff, threeDiff };
		    
		    result.put(key, tempo);
		    
		}
		
		setResult(result);
		
	}
	
	public double calcDifference(HashMap<String, Double> inputLangValue, HashMap<String, Double> comparisonLangValue) {
		
		double totalDifference = 0;
		
		for (HashMap.Entry<String, Double> entry : inputLangValue.entrySet()) {
		    String key = entry.getKey();
		    Double value = entry.getValue();
		    
		    if(comparisonLangValue.containsKey(key)) {
		    	double temp = Math.abs(value - comparisonLangValue.get(key));
		    	totalDifference += temp;
		    }else {
		    	totalDifference += value;
		    }

		}
		
		return totalDifference;
	}
	
}
