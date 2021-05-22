import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;

public class CheckCountriesInSQLiteDBTask {
	// TEST-2 (DB)
	@Test	 
	public static void checkInDB() {
			CheckCountriesInSQLiteDBTask app = new CheckCountriesInSQLiteDBTask();  
	        app.checkPopulationDensityForAllCountriesInDB();  
	 }
	   
	private Connection connect() {  
		// SQLite connection string  
		String url = "jdbc:sqlite:C:\\TestTaskResources\\db\\Countries.db";  
		Connection conn = null;  
		try {  
			conn = DriverManager.getConnection(url);  
		} catch (SQLException e) {  
			System.out.println(e.getMessage());  
		}  
		return conn;  
	}  	  
	
	public void checkPopulationDensityForAllCountriesInDB(){  
	        String sql = "SELECT * FROM Countries";  
	        int allPop = 0;
	        int totalCountryNumber=0;
	        try {  
	            Connection conn = this.connect();  
	            Statement stmt  = conn.createStatement();  
	            ResultSet rs    = stmt.executeQuery(sql);  
	            System.out.println("TEST-2 (DB)");
	            // loop through the result set  
	            while (rs.next()) {  
	            	totalCountryNumber++;
	                if(lessThan50onSqKM(rs.getInt("Population"),rs.getInt("Area")))
	                	System.out.println("Population density in " 
	                						+ rs.getString("CountryName")
	                	              		+ " is lower than 50 ppl/sqKM.");
	                allPop=allPop+rs.getInt("Population");
	            }
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
            if(allPop<2000000000) {
	        	System.out.println("Population of all " 
	        						+ totalCountryNumber 
	        						+ " countries is less than 2.000.000.000 people: " 
	        						+ formatNumbers(allPop) + ". \n\n");
	        						
	        } else {
	        	System.out.println("Population of all " 
	        						+ totalCountryNumber 
	        						+ " countries is more than 2.000.000.000 people: " 
	        						+ formatNumbers(allPop) + ". \n\n");
	        }
	}  
	    
	private static String formatNumbers(int value) {
	   DecimalFormat df = new DecimalFormat("###,###,###");
	   return df.format(value);
	}
	      
	static boolean lessThan50onSqKM(int population, int area) {
		if(Math.abs(population/area)<50) {
			return true;
		}
		return false;
	}
}
