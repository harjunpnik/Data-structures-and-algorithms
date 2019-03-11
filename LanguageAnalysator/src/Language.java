import java.util.ArrayList;
import java.util.HashMap;

public class Language {

	private ArrayList<String> content;
	private String languageLabel;
	private HashMap <String, Double> singelCharDistribution;
	private HashMap <String, Double> firstCharDistribution;
	private HashMap <String, Double> threeCharDistribution;
	
	public Language(String languageLabel, ArrayList<String> content) {
		setLanguageLabel(languageLabel);
		setContent(content);
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
}
