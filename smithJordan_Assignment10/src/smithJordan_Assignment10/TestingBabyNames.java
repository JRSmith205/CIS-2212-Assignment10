/*NAME: Jordan Smith
 * COURSE: CIS 2212-800
 * DATE: 07/08/2024
 * DESCRIPTION: This program is meant to read the file from a webpage and uses exception handling in case something goes wrong
 * */

package smithJordan_Assignment10;

import java.util.Scanner;
import java.io.*;
import java.net.*;


public class TestingBabyNames {

	 public static void main(String[] args) throws IOException {
			
		 Scanner input = new Scanner (System.in);
			TestingBabyNames object1 = new TestingBabyNames();//this object will call the getOpenWeb
			String otherNames = object1.getRemoveWhiteSpace();
			
			if (otherNames == "MalformedURLException") {
				System.out.println("Malformed URL Exception");
			}
			
			else if (otherNames == "IOException") {
				System.out.println("IOException");
			}
			else if (otherNames == "Exception") {
				System.out.println("Exception");
			}
			else {
				String duplicateGenders = getDuplicates(otherNames);
				System.out.println(duplicateGenders);
			}

	}
	 
	 public static String getRemoveWhiteSpace() {
		 Scanner input = new Scanner (System.in);
		 try {	
		 System.out.println("Enter a file name for baby name ranking: ");
			String fileName = input.nextLine();
			String updatedNames = "";//the end product for this method is the updatedNames as they are without the white spaces

			
			String fileURL = "https://liveexample.pearsoncmg.com/data/babynameranking2001.txt" ;//fileURL is now connected to the actual URL that will be used
				URL url = new URL (fileURL);//retrieve the url
			Scanner inputOpener = new Scanner (url.openStream());//open the url through stream --> Should now have access to the url data?? --> The inputOpener is now tied to the openStream
			
			
			while (inputOpener.hasNext()) {//checks if the next thing for input opener is a white space
				String line = inputOpener.nextLine();
				String name = line;
				
				/*if (name == "1") {//change ever instance of numbers into a whitespace --> NOT A WHITESPACE, it has to be something just nothing so it's not too long 
					name = ", ";
				}THIS WON'T WORK BECAUSE IT'S NOT REPLACING ANYTHING!!! YOU HAVE TO USE THE .replace TO REPLACE SOMETHING*/
			
				name = name.replaceAll(" ", "");
				name = name.replaceAll("\t", "");
				name = name.replace("1", "");//.replace will only replace a character, which is relevant in this regard because they're numbers!!
				name = name.replace("2", "");
				name = name.replace("3", "");
				name = name.replace("4", "");
				name = name.replace("5", "");
				name = name.replace("6", "");
				name = name.replace("7", "");
				name = name.replace("8", "");
				name = name.replace("9", "");
				
				
				updatedNames += name;
			}
			return updatedNames;
			}
			catch(MalformedURLException ex) {
				System.out.println("The URL is broken: ");
				System.out.println(ex.getMessage());
				return "MalformedURLException";
			} catch (IOException ex) {
				ex.printStackTrace();
				return "IOException";
			}
			catch (Exception ex) {
				System.out.println("Unexpected exception: ");
				ex.printStackTrace();
				return "Unexpected Exception";
			}
		
	 }
	 
	 public static String getDuplicates(String passedString) {//do i have to open the stream again? Or does it stay open even in another method, so long as I don't close it?
		 //WHAT THE HELL DO I DO HERE???
		 String passedDuplicate = "";
		 try {
			 
			 
			 
			 return passedDuplicate;//this needs to return something so we can return it to the main method!!!

		 }
		 catch(Exception ex){
			 ex.printStackTrace();
			 System.out.println("Unexpected Exception");
			 return "Unexpected Exception";
		 }

}
}


/*	try {
BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));//initialize the file in the local, maybe?
writer.write(fileName);
System.out.println(fileName);


//using this as a reference to what to do here: https://www.baeldung.com/java-buffered-reader
//using this as a reference to how to read/write to text file https://www.youtube.com/watch?v=ScUJx4aWRi0&list=PLGosS6_bGnC6mSTmbvUC7sMf3VUq_4cMm&index=3


java.net.URL url = new java.net.URL(fileURL);


try (InputStream is = url.openStream(); //is object = "input stream" | the url object is tapping into the openStream() method to open the URL from the web
	BufferedReader reader = new BufferedReader (new InputStreamReader(is))){//We're passing the "is" object to the BufferedReader (reader) object which will then be passed to line variable
String line;

while ((line = reader.readLine()) != null) {//found this tutorial on https://www.youtube.com/watch?v=f4T3uirbJqA --> He said that while the readLine is active, it will read until there are no lines (aka null)
	System.out.println(line);
}
}
}*/
		
		

