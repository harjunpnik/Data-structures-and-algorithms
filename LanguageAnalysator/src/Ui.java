import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Ui {

	//	START TEXT
	//	Shows  user instructions and returns the user input as a string
	public static String startText() {
		System.out.println(" _____________________");
		System.out.println("|                     |");
		System.out.println("| LANGUAGE ANALYSATOR |");
		System.out.println("|_____________________|");
		System.out.println();
		System.out.println("Please enter text and this application will try to guess which language it is.");
		System.out.println("This application works best when it gets a long text.");
		System.out.println("This analysator can guess German, Estoninan, English, French, Italian, Norwegian, Finnish and Swedish.");
		System.out.println();
		System.out.print("Your Text: ");
		
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		scanner.close();

		return userInput;
	}
	
	//	RESULT TEXT
	//	Shows user the result
	public static void resultText(HashMap<String, double[]> result) {
		System.out.println();
		System.out.println("\t RESULT");
		System.out.println("-------------------------");
		System.out.println();
		System.out.println(String.format("%-6s%-14s%-10s%-14s%-14s%-14s", "Rank", "Language", "Total", "Single Char","First Char","Three Char"));
		System.out.println("---------------------------------------------------------------------");
		
		//	Loop through list and print out each result in ascending order
		int rank = 1;
		NumberFormat formatter = new DecimalFormat("#0.00"); 
		while(!result.isEmpty()) {
			
			double leastValue = 100;
			String currentLanguage = new String();
			double[] currentValue = {};
			for (HashMap.Entry<String, double[]> RENAMEME : result.entrySet()) {
				double value = RENAMEME.getValue()[0];
				//	If total value is lower, save it as current
			    if(value < leastValue) {
			    	leastValue = value;
			    	currentLanguage = RENAMEME.getKey();
			    	currentValue  = RENAMEME.getValue();
			    }
			}
			
			System.out.println(String.format("%-6s%-14s%-14s%-13s%-14s%-1s", rank, currentLanguage, formatter.format(currentValue[0]), formatter.format(currentValue[1]), formatter.format(currentValue[2]), formatter.format(currentValue[3]) ) );
			rank++;
			//	Remove curent from list and loop until list is empty
			result.remove(currentLanguage);
		}
	}
	
}
