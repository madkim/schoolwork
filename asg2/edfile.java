// Matthew Kim
// madkim
// cmps12b
// 11/5/14
// edfile.java
// creates a basic text editor using a doubly linked list

import java.util.Scanner;
import static java.lang.System.*;
import java.io.*;
import java.util.*;

class edfile{

   public static void main (String[] args) throws IOException{
      boolean want_echo = check(args);
      dllist lines = new dllist ();
      System.out.println("Welcome!");      
      Scanner stdin = new Scanner (in);
      try{
         if(args.length == 1 && !check(args)){
            BufferedReader in = new BufferedReader(new FileReader(args[0]));  
            String sentence = in.readLine();
            while(sentence != null){
               lines.insert(sentence, dllist.position.LAST);
               sentence = in.readLine();
            }
         }
         else if(args.length == 1 && check(args)){
         }
         else if(args.length == 2 && check(args)){
            BufferedReader in = new BufferedReader(new FileReader(args[1]));
            String sentence = in.readLine();
            while(sentence != null){
               lines.insert(sentence, dllist.position.LAST);
               sentence = in.readLine();
            } 
         }
      }catch(Exception e){
         System.out.println("Error: File Not Found");
      }

      for (;;) {
         if (! stdin.hasNextLine()) break;
         String inputline = stdin.nextLine();
         if (want_echo) out.printf ("%s%n", inputline);
         if (inputline.matches ("^\\s*$")) continue;
         char command = inputline.charAt(0);
         switch (command) {
            case '#': 
               break;
            
            case '$': 
               try{
                  lines.setPosition(dllist.position.LAST); 
                  lines.getItem(); 
               }catch(Exception e){
                  System.out.println("list is empty.");
               }
               break;
            
            case '*':   
               lines.setPosition(dllist.position.FIRST);
               if( lines.isEmpty() ){
                  System.out.println("list is empty, no lines to display.");
               }
               else{
               try{
                  while(lines.getItem() != null ){
                  lines.setPosition(dllist.position.FOLLOWING);
                  }
               }catch(Exception e){
               } 
               lines.setPosition(dllist.position.LAST); 
               } 
               break;
            
            case '.': 
               try{
                  lines.getItem(); 
               }catch(Exception e){
                  System.out.println("list is empty.");
               }
               break;
            
            case '0': 
               try{
                  lines.setPosition(dllist.position.FIRST); 
                  lines.getItem(); 
               }catch (Exception e) {
                  System.out.println("list is empty.");                  
               }
               break;
            
            case '<': 
               try{
               lines.setPosition(dllist.position.PREVIOUS); 
               lines.getItem(); 
               }catch(Exception e){
                  System.out.println("first line in list.");
               }
               break;

            case '>': 
               try{
                  lines.setPosition(dllist.position.FOLLOWING); 
                  lines.getItem(); 
               }catch(Exception e){
                  System.out.println("last line in list.");
               }
               break;

            case 'a': 
               String[] splitNext = inputline.split("a", 2);
               if( lines.isEmpty() ){
                  lines.insert(splitNext[1], dllist.position.FIRST);
                  lines.getItem();
                  lines.setPosition(dllist.position.LAST);
               }
               else if(lines.getPosition() != lines.getNumItems()){
                  lines.insert(splitNext[1], dllist.position.FOLLOWING);
                  lines.getItem();
               }
               else{
                  lines.insert(splitNext[1], dllist.position.LAST);
                  lines.getItem();
               }
               break;
            
            case 'd': 
               try{
                  lines.delete();
               }catch(Exception e){
                  System.out.println("can't delete, list empty.");
               } 
               break;
            
            case 'i': 
               String[] splitPre = inputline.split("i", 2);
               if( lines.isEmpty() ){
                  lines.insert(splitPre[1], dllist.position.FIRST);
                  lines.setPosition(dllist.position.FIRST);
                  lines.getItem();
               }
               else if(lines.getPosition() != 1 ){
                  lines.insert(splitPre[1], dllist.position.PREVIOUS);
                  lines.getItem();
               }
               else{
                  lines.insert(splitPre[1], dllist.position.FIRST);
                  lines.getItem();
               }
               break;
            
            case 'r': 
               int countRead = 0;
               String[] read = inputline.split("r", 2);
               try{
                  if( lines.isEmpty() ){
                     BufferedReader readIn = new BufferedReader(new FileReader(read[1]));  
                     String line = readIn.readLine();
                     while(line != null){
                        lines.insert(line, dllist.position.LAST);
                        line = readIn.readLine();
                        countRead++;
                     }
                  }
                  else if(lines.getPosition() != lines.getNumItems()){
                     BufferedReader readIn = new BufferedReader(new FileReader(read[1]));
                     String line = readIn.readLine();
                     while(line != null){
                        lines.insert(line, dllist.position.FOLLOWING);
                        line = readIn.readLine();
                        countRead++;
                     }  
                  }
                  else{
                     BufferedReader readIn = new BufferedReader(new FileReader(read[1]));
                     String line = readIn.readLine();
                     while(line != null){
                        lines.insert(line, dllist.position.LAST);
                        line = readIn.readLine();
                        countRead++;
                     }
                  }
                  lines.setPosition(dllist.position.LAST); 
                  System.out.println("Number of lines inserted: "+countRead);

               }catch(FileNotFoundException e){
                  System.out.println("Error: File Cannot Be Read");
               }
               break;
            
            case 'w': 
               int countWrite = 0;
               String[] write = inputline.split("w", 2);
               try{
                  PrintWriter writeIn = new PrintWriter(write[1]);
                  lines.setPosition(dllist.position.FIRST);
                  while(lines.getPosition() != lines.getNumItems()){
                     writeIn.println(lines.getItem());
                     lines.setPosition(dllist.position.FOLLOWING);
                     countWrite++;
                     }
                  writeIn.println(lines.getItem());
                  countWrite++;
                  writeIn.close();
                  System.out.println("Number of lines written: "+countWrite);

               }catch(Exception e){
                  System.out.println("Error: Cannot Be Written");
               }
               break;

            default : 
               System.out.println("invalid command"); 
               break;
         }
      }
      auxlib.die();
   }

   public static boolean check (String[] args){ 
      if(args.length > 0){
         String check = "-e";
         return args[0].equals(check); 
      }
      else{
         return false;
      }
   }

}



