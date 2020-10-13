package taylorcodes;

/**
 * Application:	 Kath and Kim Random Epsiode Generator
 * Author:		 Conkle, Taylor
 * 
 * ABOUT:
 * 
 * This is an application that generates a random episode 
 * of Kath and Kim.
 * 
 * In it's most basic form, it loops thru lines in a file
 * containing episode names. A number is randomly selected
 * using the Random implementation. Then, the line of the 
 * corresponding random number is printed to the screen.
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class EpisodeGenerator {
	
	public static void main(String args[]) {
		
		try {
			printHeader();
			generateEpisode();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//END main()
	
	
/*********************************************************************************/
	
	// Print the header
	private static void printHeader() {
		
		System.out.println("\n=====================================================================");
		System.out.println("\n=====\tWelcome to the Kath and Kim Random Episode Generator!\t=====");
		System.out.println("\n=====================================================================");
		
	}//END printHeader()
	
	// Generate an episode
	public static void generateEpisode() throws Exception {
		
		File file = new File("/Users/taylorconkle/eclipse-workspace/KathAndKimEpisodeGenerator/src/episodes");
		BufferedReader br = new BufferedReader(new FileReader(file));

		Random random = new Random();
		
		int lines =  fileLines(file);
		
		int randomNumber = random.nextInt(lines + 1);
		
		System.out.print("\nYour Generated Number is " + randomNumber);
		
		int i = 0; 
		String episodeName; 
		while ((episodeName = br.readLine()) != null) {
			i++;
			if (i == randomNumber) {
				System.out.println("\n\nIt's time to watch " + episodeName);	
			}
		}
		br.close();
	}//END generateEpisode()


/*********************************************************************************/
	
	// Print all episodes. Uncomment this and place the method in main() to print
	// all episodes
//	private static void printallEpisodes(File file) throws Exception {
//		
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		
//		String episodeName; 
//		while ((episodeName = br.readLine()) != null) 
//			System.out.println(episodeName);
//		
//	}//END printallEpisodes()
	

/*********************************************************************************/	
	
	// Calculate the number of lines in a file
	public static int fileLines(File file) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		int lines = 0;
		
		try {
			while (br.readLine() != null) {
				lines++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		br.close();
		
		return lines;
		
	}//END fileLines()
	
	
}//END Class EpisodeGenerator