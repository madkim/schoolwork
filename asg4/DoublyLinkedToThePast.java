// Matthew D. Kim & Susan Inha Kim
// madkim
// cmps12b
// 12/8/14
// DoublyLinkedToThePast.java
// creates a doublylinked list for cyoa.java

class LinkToThePast{                  // code from doublyLinked.java
   public Room room;                
   public LinkToThePast  next;                  
   public LinkToThePast  previous;              

   public LinkToThePast(Room previous){              
      room = previous; 
   }
}  

class DoublyLinkedToThePast{
   public LinkToThePast  first;              
   public LinkToThePast  last;                

   public DoublyLinkedToThePast(){       
      first = null;                
      last = null;
   }

   public boolean isEmpty(){ 
      return first == null; 
   }

   public void insertLast(Room previous){   
      LinkToThePast newLink = new LinkToThePast(previous);  
      if( isEmpty() )                
         first = newLink;            
      else{
         last.next = newLink;        
         newLink.previous = last;    
      }
      last = newLink;                
   }

   public LinkToThePast deleteLast(){                            
      LinkToThePast temp = last;
     
         last.previous.next = null;  
         last = last.previous;          
      return temp;
   }
}