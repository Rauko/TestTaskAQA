import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

import org.junit.jupiter.api.Test;


public class CheckImageTask {
	// TEST-1 (API)
	@Test
	static void getRequest() throws IOException {
		URL url = new URL("http://apimeme.com/meme?meme=Alarm-Clock&top=Top+text&bottom=Bottom+text");
	    URLConnection connection = url.openConnection();
	    connection.setRequestProperty("Host", "apimeme.com");	// this helps to avoid  
	    connection.setRequestProperty("Cookie", "*");			// 403 server response
	    connection.setRequestProperty("User-Agent", "*");		// "no access"

	    byte[] imageData = new byte[2048];
	    File downloadFile = new File("download.png");
	    FileOutputStream outputStream = new FileOutputStream(downloadFile);
	    int read;
	    while ((read = connection.getInputStream().read(imageData)) != -1) {
	        outputStream.write(imageData, 0, read);
	    }
	    outputStream.close();
	    System.out.println("TEST-1 (API)\nImage downloaded. Checking for Base64 standart: " 
	    					+ isBase64(downloadFile.getAbsolutePath()) 
	    					+ "\nPre-saved image as example.jpeg : " 
	    					+ isBase64("C:\\TestTaskResources\\images\\example.jpeg") + "\n\n");
	}
		
	static boolean isBase64(String path) {
		   try {
		        Base64.getDecoder().decode(path);
		        return true;
		    } catch(IllegalArgumentException e) {   
		        return false;
		    }
	}
	
}
