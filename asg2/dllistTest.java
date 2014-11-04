// dllistTest.java
// Unit tests for dllist

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class dllistTest {

    @Test
    public void startsEmptyTest() {
        dllist lst = new dllist();
        assertEquals(true, lst.isEmpty());
    }

    @Test
    public void insertLastTest() {
    	dllist lst = new dllist();
    	String word = "hello";
    	lst.insert(word, dllist.position.LAST);
    	assertEquals(false, lst.isEmpty());
    }
    @Test
    public void insertFirstTest() {
    	dllist lst = new dllist();
    	String word = "hello";
    	lst.insert(word, dllist.position.FIRST);
    	assertEquals(false, lst.isEmpty());
    }   
    @Test(expected=Exception.class)
    public void insertPrevExcepTest() {
    	dllist lst = new dllist();
    	String word1 = "hello";
    	lst.insert(word1, dllist.position.FIRST);
    	String word3 = "world";
    	lst.insert(word3, dllist.position.PREVIOUS);
    }
    /*@Test
    public void insertPrevTest() {
    	dllist lst = new dllist();
    	String word1 = "hello";
    	lst.insert(word1, dllist.position.FIRST);
    	String word2 = "kind";
    	lst.insert(word2, dllist.position.LAST);
    	String word3 = "world";
    	lst.insert(word3, dllist.position.PREVIOUS);
    	assertEquals( true, lst.getItem() == word3);
    } // checks position once setPosition is created*/
}


