import java.io.IOException;
import java.util.Scanner;

public class startTest {
	
	private static Scanner userChoice;

	@SuppressWarnings({ "unused", "static-access" })
	public static void main(String[] args) throws IOException {
		boolean start=false;
		if(start== false)
			System.out.println("Hello! This is a Test Task for AQA!\n");
		
		System.out.println("Choose test scenario for execution or press Q for Quit:\n\n"
							+ "1.Execute all scenarios\n"
							+ "2.TEST-1 (API)\n"
							+ "3.TEST-2 (DB)\n"
							+ "4.TEST-3 (iFrame)");
		start=false;
		
		userChoice = new Scanner(System.in);
		while(userChoice != null) {
			String choice = userChoice.nextLine();
		
			CheckImageTask checkImage = new CheckImageTask();
			CheckCountriesInSQLiteDBTask CheckCountriesInSQLiteDB = new CheckCountriesInSQLiteDBTask();
			CheckLinkInBrowserTask CheckLinkInBrowser = new CheckLinkInBrowserTask();
			
			switch (choice) {
        		case  ("1"):
        			System.out.println("You choosed " + choice + ". Sequential execution of all tests begins:");
        			CheckImageTask.getRequest();
        			CheckCountriesInSQLiteDB.checkInDB();
        			CheckLinkInBrowser.openBrowser();
        			break;
        		case ("2"):
        			System.out.println("You choosed " + choice + ". Test execution begins:");
        			CheckImageTask.getRequest();
        			break;
        		case ("3"):
        			System.out.println("You choosed " + choice + ". Test execution begins:");
        			CheckCountriesInSQLiteDB.checkInDB();
        			break;
        		case ("4"):
        			System.out.println("You choosed " + choice + ". Test execution begins:");
        			CheckLinkInBrowser.openBrowser();
        			break;
        		case ("q"):
        			System.out.println("You choosed " + choice + ". Program is shutting down.");
        			break;
        		default:
        			System.out.println("Your enter is not valid."
        							+ "\nPlease re-enter scenario number or press Q for Quit:\n");
				}
			}
	}
}
