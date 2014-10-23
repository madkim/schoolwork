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
    int count;	//keep track of array length
  
  	try{
  	if(args.length == 1){

  		BufferedReader in = new BufferedReader(new FileReader(args[0]));
        count = Integer.parseInt(in.readLine()); 

      BusinessSort list;
      list = new BusinessSort(count);
      
      for(int i=0; i<count; i++){
      list.insert(in.readLine());
      }

      list.display();

      list.mergeSort();

      list.display();
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
  private int bElems=0;

  public BusinessSort(int businessSize){
    businesses = new String[businessSize];
  }

  //----------------------------------------------------------- 
  public void insert(String name){
    businesses[bElems] = name;
    bElems++;
  }
  
  //----------------------------------------------------------- 
  public void display(){      
    for(int j=0; j<bElems; j++) 
      System.out.println(businesses[j] + " "); 
    System.out.println();
    }

  //----------------------------------------------------------- 
  public void mergeSort(){            //meregeSort from book
    String[] workSpace = new String[bElems]; 
    recMergeSort(workSpace, 0, bElems-1);
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










