// Matthew Kim & Susan Kim
// madkim
// cmps12b
// 11/21/14
// Queue.java 
// creates a queue of list lines 

import java.util.Iterator;
import java.util.NoSuchElementException;

class Queue <Item> implements Iterable <Item> {

   private class Node {
      Item item;
      Node next;
   }
   private Node head = null;
   private Node tail = null;

   public boolean isEmpty() { 
      return head==null; 
   }

   public void insert(Item newitem) {
      Node queueItem = new Node();
      queueItem.item = newitem;  
      if( isEmpty() )                
         head = queueItem;            
      else
         tail.next = queueItem;       
         tail = queueItem;           
   }

   public Iterator <Item> iterator() {
      return new Itor ();
   }

   class Itor implements Iterator <Item> {
      Node current = head;
      public boolean hasNext() {
         return current != null;
      }
      public Item next() {
         if (! hasNext ()) throw new NoSuchElementException();
         Item result = current.item;
         current = current.next;
         return result;
      }
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

}
