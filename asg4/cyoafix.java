// Matthew D. Kim & Susan Inha Kim
// madkim
// cmps12b
// 12/8/14
// cyoa.java
// creates a basic choose your own adventure game

import java.util.Scanner;
import static java.lang.System.*;
import java.io.*;
import java.util.*;

class cyoafix{

	public static void main(String[] args) throws IOException{
		Scanner stdin = new Scanner(in);
		char letter;
		int r = 0;
		int o = -1;

		if( args.length == 1 ){
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			String line = in.readLine();

			while( line != null ){

				if(line.isEmpty()){
					line = in.readLine();
				}
				else{

					letter = line.charAt(0);

					if( letter == 'r' ){
						r++;
						line = in.readLine();
					}
					else{
						line = in.readLine();
					}
				}
			}

			Room[] rooms = new Room[r];

			String[] splitLine;
			String text;
			line = null;
			r = -1;


		/*	rooms[0] = new Room("room1");					//debug output used to check if 
			System.out.println(rooms[0].name);				//values are being inputted correctly
			rooms[0].roomDescription = "Looks Dark";
			System.out.println(rooms[0].roomDescription);
			rooms[0].choice[0] = new Option("Open Door 1?");
			System.out.println(rooms[0].choice[0].optionDescription);
			rooms[0].choice[1] = new Option("Open Door 2?");
			System.out.println(rooms[0].choice[1].optionDescription);



			rooms[1] = new Room("room2");
			System.out.println(rooms[1].name);
			rooms[1].roomDescription = "It's brighter here!";
			System.out.println(rooms[1].roomDescription);
			rooms[1].choice[0] = new Option("Go back?");
			System.out.println(rooms[1].choice[0].optionDescription);
		*/


			BufferedReader next = new BufferedReader(new FileReader(args[0]));
			line = next.readLine();

			for(int i = 0; i < rooms.length; i++){

				while( line != null && !line.isEmpty()){

					letter = line.charAt(0);
					splitLine = line.split(" ", 2);
					text = splitLine[1];

					if( letter == 'r' ){
						++r;
						o = -1;
						rooms[r] = new Room(text);
					
					}
					else if( letter == 'd'){
						if(rooms[r].roomDescription == null)
							rooms[r].roomDescription = "\n" + text + "\n";
						
						else{
							rooms[r].roomDescription = rooms[r].roomDescription 
							+ "\n" + text + "\n";
						}
				
					}
					else if( letter == 'o'){
						++o;
						rooms[r].choice[o] = new Option(text);

					}
					else if( letter == 't'){
						rooms[r].choice[o].tag = new Room(text);

					}
					line = next.readLine();

				}
				if( line != null){
					line = next.readLine();
				
				}
			}
			/*for( int i = 0; i < rooms.length; i++){			//debug output that checks
				System.out.println(rooms[i].name);				//rooms and their options
				System.out.println(rooms[i].roomDescription);
				for( int j = 0; j < 12; j++){
					if(rooms[i].choice[j] != null)
						System.out.println(rooms[i].choice[j].optionDescription);
				}
				System.out.println();

			}*/
			
			for( int i = 0; i < rooms.length; i++ ){

				for( int j = 0; j < 12; j++){

					if( rooms[i].choice[j] == null ){
						break;

					}
					for( int h = 0; h < rooms.length; h++ ){

						if( rooms[i].choice[j].tag.name.equals(rooms[h].name) ){
							rooms[i].choice[j].tag = rooms[h];
							break;
						}
					}
				}
			}

		/*	System.out.println(rooms[0].choice[0].tag.roomDescription);		//debug out that checks the
			System.out.println(rooms[0].choice[1].tag.roomDescription);		//tags for each room object
			System.out.println(rooms[1].choice[0].tag.roomDescription);
			System.out.println(rooms[1].choice[1].tag.roomDescription);
		*/

			Room current = rooms[0];
			DoublyLinkedToThePast undo = new DoublyLinkedToThePast();
			undo.insertLast(current);

			System.out.println(current.roomDescription);

				for( int j = 0; j < 12; j++ ){
					if( rooms[0].choice[j] != null){
						System.out.println((char)(0x0061 + j) + " - " + 
							rooms[0].choice[j].optionDescription);
					}
				}
				System.out.println();


				while(stdin.hasNextLine()){
					try{
						String inputLine = stdin.nextLine();
						char inputChar = inputLine.charAt(0);

						if( inputChar == 'q' ){
							System.out.println("[quit]\n");
							System.exit(0);
						}
						else if( inputChar == 'r' ){
							current = rooms[0];
							System.out.println("[restart]");
							System.out.println(current.roomDescription);
							
							for( int j = 0; j < 12; j++ ){
								if( rooms[0].choice[j] != null){
									System.out.println((char)(0x0061 + j) + " - " + 
									rooms[0].choice[j].optionDescription);
								}
							}
							System.out.println();
						}
						else if( inputChar == 'y' ){
							System.out.println("[information]\n");
							String[] order = new String[rooms.length];
							String temp = null;
							
							for( int i = 0; i < rooms.length; i++){	
								order[i] = (rooms[i].name + " : ");
								for( int j = 0; j < 12; j++){
									if(rooms[i].choice[j] != null)
										order[i] = order[i] + (rooms[i].choice[j].tag.name + " ");
								}
							}
							for( int i = 0; i < rooms.length - 1; i++ ){
								for( int j = i + 1; j < rooms.length; j++ ){
									if( order[i].compareTo(order[j]) > 0 ){
										temp = order[i];
										order[i] = order[j];
										order[j] = temp;
									}
									else
										break;
								}
							}
							for( int i = 0; i < rooms.length; i++ ){
								System.out.println(order[i]);
							}

							System.out.println(current.roomDescription);

							for( int k = 0; k < 12; k++ ){
								if( current.choice[k] != null){
									System.out.println((char)(0x0061 + k) + " - " + 
									current.choice[k].optionDescription);
								}
							}
						}	
						else if( inputChar == 'z' ){
							
							if( undo.first.next == null ){
								System.out.println("nothing to undo");
								current = undo.first.room;
								System.out.println(current.roomDescription);

								for( int j = 0; j < 12; j++ ){
									if( current.choice[j] != null){
										System.out.println((char)(0x0061 + j) + " - " + 
										current.choice[j].optionDescription);
									}
								}
								System.out.println();

							}
							else{
							System.out.println("[undo]\n");
							current = undo.last.room;
							undo.deleteLast();
							System.out.println(current.roomDescription);


							for( int j = 0; j < 12; j++ ){
								if( current.choice[j] != null){
									System.out.println((char)(0x0061 + j) + " - " + 
									current.choice[j].optionDescription);
								}
							}
							System.out.println();
							}

						}

							for( int j = 0; j < 12; j++ ){

								if( current.choice[j] != null ){

									if( inputChar == (char)(0x0061 + j) ){
										System.out.print("["+current.choice[j].optionDescription+"]\n");
										undo.insertLast(current);
										current = current.choice[j].tag;
										System.out.println(current.roomDescription);

										for( int k = 0; k < 12; k++ ){
											if( current.choice[k] != null){
												System.out.println((char)(0x0061 + k) + " - " + 
												current.choice[k].optionDescription);
											}
										}

									}	
								}
								else{
									//System.out.println("Invalid Command")
								}
								
							}
							System.out.println();
					}
					catch(Exception e){
					System.out.println("Invalid Command\n");
					}
			}

		}
	}
}