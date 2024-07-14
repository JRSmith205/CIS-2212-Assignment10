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

		String otherNames = getRemoveWhiteSpace();
		String duplicateNames = getDuplicates(otherNames);
		System.out.print(duplicateNames);

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
				String name = inputOpener.nextLine();

				name = name.replaceAll("[^a-zA-Z]", "");
				String[] splitNames = name.split("(?=\\p{Upper})");
				for (String splitName : splitNames) {
					updatedNames += splitName;
					updatedNames += ",";
				}

			}

//			System.out.print(updatedNames);
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
	 
	 public static String getDuplicates(String passedString) {
		 String passedDuplicate = "";
		 try {
			 String[] splitNames = passedString.split(",");
			 String currentName = "";

			 for(int i = 0; i < splitNames.length-1; i++){
				 currentName = splitNames[i];
				 for(int j =0; j < i; j++){
					 if (currentName.matches(splitNames[j])){
						 passedDuplicate += currentName;
						 passedDuplicate += ",";
					 }
				 }

			 }
			 
			 return passedDuplicate;

		 }
		 catch(Exception ex){
			 ex.printStackTrace();
			 return "Unexpected Exception";
		 }

}
}