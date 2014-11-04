// dllist.java
// Template code for doubly-linked list of strings.

public class dllist {

   public enum position {FIRST, PREVIOUS, FOLLOWING, LAST};

   private class node {
      String item;
      node prev;
      node next;
   }

   private node first = null;
   private node current = null;
   private node last = null;
   private int currentPosition = 0;

   public void setPosition (position pos) {
    /*  switch(pos) {
         case FIRST:

            break;
         case LAST:

            break;
         case PREVIOUS:

            break;
         case: FOLLOWING:

            break;
      }
*/
      throw new UnsupportedOperationException();
   }

   public boolean isEmpty () 
   { return first==null; }

   public String getItem () 
   { return current.item; }

   public int getPosition () {
      throw new UnsupportedOperationException();
   }

   public void delete () {
      throw new UnsupportedOperationException();
   }

   public void insert (String item, position pos) {
      switch(pos) {
         case FIRST:
            node nFirst = new node();  //Code from doublyLinked.java
            nFirst.item = item;
            if( isEmpty() )                
               last = nFirst;             
            else{
               first.prev = nFirst;   
               nFirst.next = first;          
            }
            first = nFirst;   
            current = nFirst;
            break;
         case LAST:
            node nLast = new node();
            nLast.item = item;  
            if( isEmpty() )                
               first = nLast;            
            else{
               last.next = nLast;       
               nLast.prev = last;    
            }
            last = nLast; 
            current = nLast;   
            break;
         case PREVIOUS:
         node nPre = new node();
            nPre.item = item;  
            if( current != first ){
               current.prev.next = nPre;
               nPre.prev = current.prev;
               nPre.next = current;
               current.prev = nPre;
            }else{
               throw new IllegalArgumentException("can't insert before first!");
            }
            current = nPre;    
            break;
     /*    case: FOLLOWING:

            break;
     */
      }
   }

}

