// edfile.java
// Template for a line-oriented text editor inspired by ed.

import java.util.Scanner;
import static java.lang.System.*;
import java.io.*;

class edfile{

   public static void main (String[] args) throws IOException{
      boolean want_echo = false;
      dllist lines = new dllist ();
      System.out.println("Welcome!");      
      auxlib.STUB ("Check for -e option");
      auxlib.STUB ("Load file from args filename, if any.");
      Scanner stdin = new Scanner (in);
      if(args.length == 1){
         BufferedReader in = new BufferedReader(new FileReader(args[0]));  
         System.out.println("filename: "+args[0]); //delete
      }
      else if(args.length == 2){
         want_echo = true;
         BufferedReader in = new BufferedReader(new FileReader(args[1]));
         System.out.println("option: "+args[0]+"\nfilename: "+args[1]); //delete
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
               lines.setPosition(dllist.position.LAST); 
               lines.getItem(); 
               break;
            case '*':   
               lines.setPosition(dllist.position.FIRST);
               while(lines.getItem() != null){
                  System.out.println(lines.getItem());
                  lines.setPosition(dllist.position.FOLLOWING);
               } 
               lines.setPosition(dllist.position.LAST); 
               break;
            case '.': 
               lines.getItem(); 
               break;
            case '0': 
               lines.setPosition(dllist.position.FIRST); 
               lines.getItem(); 
               break;
            case '<': 
               lines.setPosition(dllist.position.PREVIOUS); 
               lines.getItem(); 
               break;
            case '>': 
               lines.setPosition(dllist.position.FOLLOWING); 
               lines.getItem(); 
               break;
            case 'a': 
               String[] splitNext = inputline.split(" ", 2);
               System.out.println(splitNext[1]); //delete
               lines.insert(splitNext[1], dllist.position.FOLLOWING);
               lines.setPosition(dllist.position.FOLLOWING);
               lines.getItem();
               break;
            case 'd': 
               lines.delete(); 
               break;
            case 'i': 
               String[] splitPre = inputline.split(" ", 2);
               System.out.println(splitPre[1]); //delete
               lines.insert(splitPre[1], dllist.position.PREVIOUS);
               lines.setPosition(dllist.position.PREVIOUS);
               lines.getItem();
               break;
            case 'r': 
               int countRead = 0;
               String[] read = inputline.split(" ", 2);
               try{
                  BufferedReader readIn = new BufferedReader(new FileReader(read[1]));
                  String line = readIn.readLine();
                  while(line != null){
                     lines.insert(line, dllist.position.FOLLOWING);
                     countRead++;
                  }  
                  lines.setPosition(dllist.position.LAST); 
                  System.out.println("Number of lines inserted: "+countRead);

               }catch(FileNotFoundException e){
                  System.out.println("Error: File Cannot Be Read");
               }
               break;
            case 'w': 
               int countWrite = 0;
               String[] write = inputline.split(" ", 2);
               try{
               PrintWriter writeIn = new PrintWriter(write[1]);
               lines.setPosition(dllist.position.FIRST);
               while(lines.getItem() != null){
                  writeIn.print(lines.getItem());
                  countWrite++;
                  }
                  System.out.println("Number of lines written: "+countWrite);

               }catch(Exception e){
                  System.out.println("Error: Cannot Be Written");
               }
               break;
            default : auxlib.STUB ("Print invalid command."); break;
         }
      }
      auxlib.STUB ("(eof)");
   }

}

