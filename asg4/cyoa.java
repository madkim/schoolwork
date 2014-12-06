// Matthew Kim
// madkim
// cmps12b
// 12/8/14
// cyoa.java
// creates a basic choose your own adventure game

import java.util.Scanner;
import static java.lang.System.*;
import java.io.*;
import java.util.*;

class cyoa{
	
	public static void main(String[] args) throws IOException{
		int rCount = 0;
		int oCount = 0;
		int dCount = 0;
		
		Scanner stdin = new Scanner(in);
		try{
			if(args.length == 1){
				BufferedReader in = new BufferedReader(new FileReader(args[0]));
				String read1 = in.readLine();
				while(read1 != null){
					
					String[] text = read1.split(" ", 2);
					String command = text[0];
					
					if( command.equals("r") ){
						rCount++;
						read1 = in.readLine();
					}
					else if( command.equals("o") ){
						oCount++;
						read1 = in.readLine();
					}
					else if( command.equals("d") ){
						dCount++;
						read1 = in.readLine();
					}
					else{
						read1 = in.readLine();
					}

				}
				System.out.println("r count: "+rCount+"\no count: "+oCount+"\nd count: "+dCount); //delete

				doubleArray game = new doubleArray(rCount, oCount, dCount);
				rCount = -1;
				oCount = 0;
				dCount = 0;
				BufferedReader in2 = new BufferedReader(new FileReader(args[0]));
				String read2 = in2.readLine();
				while(read2 != null){
					if(read2.isEmpty()){
						read2 = in2.readLine();
					}
					else{
						String[] text = read2.split(" ", 2);
						String command = text[0];
						String commandInfo = text[1];
						System.out.println(commandInfo); //delete
						if( command.equals("r") ){
							oCount = 0;
							dCount = 0;
							rCount++;
							game.insertName(rCount, commandInfo);
							read2 = in2.readLine();
						}
						else if( command.equals("o") ){
							game.insertOption(rCount, oCount, commandInfo);
							oCount++;
							read2 = in2.readLine();
						}
						else if( command.equals("d") ){
							game.insertDetail(rCount, dCount, commandInfo);
							dCount++;
							read2 = in2.readLine();
						}					
						else{
							read2 = in2.readLine();
						}
					}
				}
				System.out.println("r count: "+rCount+"\no count: "+oCount+
					"\nd count: "+dCount); //delete

				game.display();
			}
		}
		catch(Exception e){
			System.out.println("SYNOPSIS: cyoa adventurefile");
		}

		while(true) {
			if (! stdin.hasNextLine()) break;	//code from edfile.java
			String input = stdin.nextLine();
			if (input.matches ("^\\s*$")) continue;
			char option = input.charAt(0);
			switch (option){
				case '#':
					break;

				case 'a':
					game.printDetail();
					break;

				case 'b':
					break;

				case 'c':
					break;

				case 'd':
					break;

				case 'e':
					break;

				case 'f':
					break;

				case 'g':
					break;

				case 'h':
					break;

				case 'i':
					break;

				case 'j':
					break;

				case 'k':
					break;

				case 'l':
					break;

				default:
					System.out.println("invalid command");
					break;
			}
		}
	}
}