// Matthew Kim
// madkim
// cmps12b
// 11/5/14
// dllist.java 
// creates a doubly linked list for edfile.java

import java.util.*;

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
   private int numItems = 0;

   public void setPosition (position pos) {
      switch(pos) {
         case FIRST:
            current = first;
            currentPosition = 1;
            break;

         case LAST:
            current = last;
            currentPosition = numItems;
            break;

         case PREVIOUS:
            if(current != first){
               current = current.prev;
               currentPosition--;
            }else{
               throw new NoSuchElementException("can't set position previous to first.");
            }
            break;

         case FOLLOWING:
            if(current != last){
               current = current.next;
               currentPosition++;
            }else{
               throw new NoSuchElementException("can't set position following last.");
            }
            break;
      }
   }

   public boolean isEmpty () 
   { return first==null; }

   public String getItem () {
      if( !isEmpty() ){
      System.out.println(current.item);
      return current.item; 
      }
      else{
         throw new NoSuchElementException("can't get item in empty list.");
      }

   }

   public int getPosition () {
      if ( !isEmpty() ){
         return currentPosition;
      }else{
         throw new NoSuchElementException("List is empty, no element position to return");
      }
   }

   public void delete () {
      if((current != first) && (current != last) && (!isEmpty())){
         current.prev.next = current.next;
         current.next.prev = current.prev;
         current = current.next;
         numItems--;
      }else if((current != null) && (current == first) && (first == last)){
         current = first = last = null;
         numItems--;
         currentPosition--;
      }else if((current != null) && (current == first) && (first != last)){
         first = current.next;
         current.next.prev = first;
         current = current.next; 
         numItems--;
         currentPosition = 1;
      }else if((current != null) && (current == last) && (first != last)){
         last = current.prev;
         current.prev.next = null;
         current = current.prev;
         numItems--;
         currentPosition = numItems;
      }else if( isEmpty() ){
         throw new NoSuchElementException("can't delete from empty list.");
      }
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
            numItems++;
            currentPosition = 1;
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
            numItems++;
            currentPosition = numItems; 
            break;
         
         case PREVIOUS:
         node nPre = new node();
            nPre.item = item;  
            if( isEmpty() ){
               throw new IllegalArgumentException("list is empty!");
            }
            else{
               current.prev.next = nPre;
               nPre.prev = current.prev;
               nPre.next = current;
               current.prev = nPre;
            }
            current = nPre;
            numItems++;
            currentPosition--;    
            break;
         
         case FOLLOWING:
         node nFollow = new node();
            nFollow.item = item;
            if( isEmpty() ){
               throw new IllegalArgumentException("list is empty!");
            }
            else{
               current.next.prev = nFollow;
               nFollow.next = current.next;
               nFollow.prev = current;
               current.next = nFollow;
   
            }
            current = nFollow;
            numItems++;
            currentPosition++;
            break;
     
      }
   }

   public int getNumItems () {
      return numItems;
   }

}

