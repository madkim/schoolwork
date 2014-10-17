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

class BusinessSearch{

  public static void main( String[] args) throws IOException{
    BufferedReader in = new BufferedReader(
      new FileReader("favorites.txt"));
    while(true){
      String name = in.readLine();
      if (name == null) break; 
      System.out.println(name);
    }
  }
}