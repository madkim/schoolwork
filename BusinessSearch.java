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

  public static void main( String[] args) throws IOException{
    
    Scanner sc = new Scanner(System.in);
    int count=0;	//keep track of array length
  
  	try{
  	if(args.length == 1){

  		BufferedReader in = new BufferedReader(new FileReader("favorites.txt"));
    	while(true){
      	String name = in.readLine();
      	if (name == null) break;  
      	count++; 
    	}

      BusinessSort list;
      list = new BusinessSort(count);
      
      list.display(count);

      list.mergeSort(count);

      list.display(count);
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

class BusinessSort{
  private String[] businesses;

  public BusinessSort(int businessSize) throws IOException{
    businesses = new String[businessSize];
    BufferedReader insert = new BufferedReader(new FileReader("favorites.txt"));
    for(int i=0; i<businessSize; i++){
      businesses[i] = insert.readLine();
    }
  }

  //----------------------------------------------------------- 
  public void display(int arrLength){      
    for(int j=0; j<arrLength; j++) 
      System.out.println(businesses[j] + " "); 
    }

  //----------------------------------------------------------- 
  public void mergeSort(int size){    
    String[] workSpace = new String[size]; 
    recMergeSort(workSpace, 0, size-1);
    }

  //----------------------------------------------------------- 
  private void recMergeSort(String[] workSpace, int lowerBound, int upperBound)
    {
    if(lowerBound == upperBound)                                
      return;                    
    else 
      {           
      int mid = (lowerBound+upperBound) / 2;
      recMergeSort(workSpace, lowerBound, mid); 
      recMergeSort(workSpace, mid+1, upperBound);
      merge(workSpace, lowerBound, mid+1, upperBound);
      } 
    } 

  //----------------------------------------------------------- 
  private void merge(String[] workSpace, int lowPtr, int highPtr, int upperBound)
    {
    int j = 0;             
    int lowerBound = lowPtr;
    int mid = highPtr-1;
    int n = upperBound-lowerBound+1; 

    while(lowPtr <= mid && highPtr <= upperBound) 
      if( businesses[lowPtr].compareToIgnoreCase(businesses[highPtr]) < 0)
        workSpace[j++] = businesses[lowPtr++]; 
      else
        workSpace[j++] = businesses[highPtr++];

    while(lowPtr <= mid)
      workSpace[j++] = businesses[lowPtr++];

    while(highPtr <= upperBound) 
      workSpace[j++] = businesses[highPtr++];

    for(j=0; j<n; j++)
      businesses[lowerBound+j] = workSpace[j];
    } 

}










