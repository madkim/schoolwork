// Matthew Kim
// madkim
// CMPS12B
// 10/22/14
// BusinessSearch.java
// Searches through txt document and sorts businesses. 

import static java.lang.System.*;
import java.io.InputStreamReader; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

class BusinessSearch{

  public static void main( String[] args){
    
    Scanner sc = new Scanner(System.in);
    int count=0;	//keep track of array length
  
  	try{
  	if(args.length == 1){

  		BufferedReader in = new BufferedReader(
    		new FileReader("favorites.txt"));
    	while(true){
      	String name = in.readLine();
      	if (name == null) break;  
      	count++; 
    	}
    	//System.out.println(count);	//print count = new array length
  		String[] businesses = new String[count];
  		BufferedReader insert = new BufferedReader(
    		new FileReader("favorites.txt"));
  		for(int i=0; i<businesses.length; i++){
  			String name = insert.readLine();
  			businesses[i] = name;
  			System.out.println(businesses[i]);
  		}
  	}

  	}catch(Exception e){
  		System.out.println("Usage: BusinessSearch businessDB");
  		System.exit(1);
  	}
  	if(args.length == 0 || args.length >=2){
  		System.out.println("Usage: BusinessSearch businessDB");
  		System.exit(1);
  	}



  }
}