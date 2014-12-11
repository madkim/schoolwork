// Matthew D. Kim & Susan Inha Kim
// madkim
// cmps12b
// 12/8/14
// Room.java
// creates a Room object for cyoa.java

class Room{
	public String name;
	public String roomDescription;
	public Option[] choice;


	public Room(String roomName){
		name = roomName;
		roomDescription = null;
		choice = new Option[12];
	}

}

