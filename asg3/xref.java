// Matthew Kim & Susan Kim
// madkim
// cmps12b
// 11/21/14
// xref.java 
// reads in a file with a list of words 

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class xref {

    static void processFile(String filename, boolean debug) throws IOException {
        Scanner scan = new Scanner (new File(filename));
        Tree tree = new Tree();
        for (int linenr = 1; scan.hasNextLine (); ++linenr) {
            for (String word: scan.nextLine().split ("\\W+")) {
                tree.insert(word, linenr);
            }
        }
        scan.close();
        if (debug) {
            tree.debug();
        } else {
            tree.output();
        }
    }

    public static void main(String[] args) {
        boolean want_debug = check(args);
        try {
            if(want_debug == true){
                String filename = args[1];
                processFile(filename, want_debug);
            }
            else if(want_debug == false){
                String filename = args[0];
                processFile(filename, want_debug);
            }
        }catch (IOException error) {
            auxlib.warn (error.getMessage());
        }
        auxlib.exit();
    }

    public static boolean check (String[] args){ 
      if(args.length > 0){
         String check = "-d";
         return args[0].equals(check); 
      }
      else{
         return false;
      }

    }
}

