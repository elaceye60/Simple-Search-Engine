package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Search {
	
	public static void main(String[] args) {		// TODO Auto-generated method stub
		
		Hashtable<String, ArrayList<String> > hash = new Hashtable<String, ArrayList<String> >();
		
		Scanner search = new Scanner(System.in);
		
		BufferedReader input;
		
		try{
			 input = new BufferedReader(new FileReader("C:\\TestData\\TestFile.txt"));
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.out.println("Unable to read test file C:\\TestData\\TestFile.txt");
			return;
		}	 
	
		try{
			 String webSiteURL;
			 String webSiteDescription;
			 String[] webSiteKeywords = new String[20];
			 String str;
			
			  while ((str = input.readLine()) != null) {
				 
				 String[] tokens=str.split(",");
				 if (tokens.length>2)
				    {
				    webSiteURL = tokens[0];
				    webSiteDescription = tokens[1];
				    //System.out.printf("%nSite %s%n",webSiteURL);
				    //System.out.printf("Description %s%n",webSiteDescription);
				    //System.out.println("Key Words:");
				    //for (int i=2;i<tokens.length; i++)
					  // System.out.printf("%s ",tokens[i]);
			       }
				 else{
					 for(int i = 0; i < tokens.length; i++){
							if(!hash.containsKey(tokens[i])){
								ArrayList<String> temp = new ArrayList<String>(1);
								temp.add(str);
								hash.put(tokens[i], temp);//assigns a key to anonymous ArrayList that stores the value
							}
					 }
				 }
			 }
		}
		
	    catch (IOException ioException){
	    	System.out.println("Unable to read test file C:\\TestData\\TestFile.txt");
	    }
		
		
		//System.out.println(hash);
		do{
			System.out.println("Enter a key to search for: .\n");
			System.out.println(hash.get(search.nextLine()));
			System.out.println("\nKeep searching or enter 'done' to end : ");
		}while(!search.nextLine().equalsIgnoreCase("done"));
		try{
			
			}
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(1);
		}

	}
