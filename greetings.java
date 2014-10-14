 // greetings.java
      // Greet everyone listed in people.txt
      import static java.lang.System.*;
      import java.io.InputStreamReader;
      import java.io.BufferedReader;
      import java.io.IOException;
      import java.io.FileReader;
      class greetings {
          public static void main( String[] args ) throws IOException {
              BufferedReader in = new BufferedReader(
                  new FileReader("people.txt"));
              while(true) {
                  String name = in.readLine();
                  if (name == null) break;
                  System.out.println("Hello, " + name + ".");
              }
              in.close();
          }
}
