// Matthew D. Kim & Susan Inha Kim
// madkim
// cmps12b
// 12/8/14
// Option.java
// creates a Option object for cyoa.java

class Option{
	public String optionDescription;
	public Room tag; 

	public Option(String optionName){
		optionDescription = optionName;
		tag = null;
	
	}
}