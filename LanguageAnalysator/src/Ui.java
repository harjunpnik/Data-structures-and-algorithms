import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

public class Ui {

	public static void startText() {
		System.out.println("LANGUAGE ANALYSATOR");
		System.out.println("-------------------");
		System.out.println("Please enter text and this application will try to guess which language it is.");
		System.out.println("This analysator can guess German, Estoninan, English, French, Italian, Norwegian, Finnish and Swedish");
		System.out.println();
		System.out.print("Your Text: ");
	}
	
	public static void resultText(HashMap<String, double[]> result) {
		System.out.println();
		System.out.println("\t RESULT");
		System.out.println("-------------------------");
		System.out.println();
		System.out.println(String.format("%1s%10s%14s%14s%14s%14s", "Rank", "Language", "Total", "Single Char","First Char","Three Char"));
		System.out.println("-----------------------------------------------------------------------");
		
		int rank = 1;
		NumberFormat formatter = new DecimalFormat("#0.00"); 
		while(!result.isEmpty()) {
			
			double leastValue = 100;
			String currentLanguage = "";
			double[] currentValue = {};
			for (HashMap.Entry<String, double[]> RENAMEME : result.entrySet()) {
				double value = RENAMEME.getValue()[3];
			    if(value < leastValue) {
			    	leastValue = value;
			    	currentLanguage = RENAMEME.getKey();
			    	currentValue  = RENAMEME.getValue();
			    }
			}
			String.format("%1s%10s%15s%20s", "a","a","A","a","a");
			System.out.println(String.format("%-6s%-19s%-13s%-14s%-14s%-1s", rank, currentLanguage, formatter.format(currentValue[0]), formatter.format(currentValue[1]), formatter.format(currentValue[2]), formatter.format(currentValue[3]) ) );
			rank++;
			result.remove(currentLanguage);
		}
	}
	
}
