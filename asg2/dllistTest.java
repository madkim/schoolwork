// Matthew Kim
// madkim
// cmps12b
// 11/5/14
// dllistTest.java
// contains JUnit tests for dllist

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class dllistTest {

    @Test
    public void startsEmptyTest() {
        dllist lst = new dllist();
        assertEquals(true, lst.isEmpty());
    }
    @Test
    public void isEmptyTest () {
        dllist lst = new dllist();
        String word = "hello";
        lst.insert(word, dllist.position.LAST);
        assertEquals(false, lst.isEmpty());
    }
    @Test
    public void lastGetItemTest () {
        dllist lst = new dllist();
        String word = "hello";
        lst.insert(word, dllist.position.LAST);
        String word2 = "world";
        lst.insert(word2, dllist.position.LAST);
        lst.getItem();
        assertEquals("world", lst.getItem());
    }
    @Test
    public void firstGetItemTest () {
        dllist lst = new dllist();
        String word = "world";
        lst.insert(word, dllist.position.FIRST);
        String word2 = "hello";
        lst.insert(word2, dllist.position.FIRST);
        lst.getItem();
        assertEquals("hello", lst.getItem());
    }
    @Test
    public void setPositionFirstTest () {
        dllist lst = new dllist();
        String word = "hello";
        lst.insert(word, dllist.position.LAST);
        String word2 = "world";
        lst.insert(word2, dllist.position.LAST);
        lst.setPosition(dllist.position.FIRST);
        lst.getItem();
        assertEquals("hello", lst.getItem());
    }
    @Test
    public void setPositionLastTest () {
        dllist lst = new dllist();
        String word = "hello";
        lst.insert(word, dllist.position.FIRST);
        String word2 = "world";
        lst.insert(word2, dllist.position.FIRST);
        lst.setPosition(dllist.position.LAST);
        lst.getItem();
        assertEquals("hello", lst.getItem());
    }
    @Test
    public void insertPrevTest () {
        dllist lst = new dllist();
        String a = "A";
        lst.insert(a, dllist.position.LAST);
        String b = "B";
        lst.insert(b, dllist.position.LAST);
        String c = "C";
        lst.insert(c, dllist.position.LAST);
        String d = "D";
        lst.insert(d, dllist.position.PREVIOUS);
        lst.setPosition(dllist.position.LAST);
        lst.getItem();
        assertEquals("C", lst.getItem());

    }
    @Test
    public void insertFollowTest () {
        dllist lst = new dllist();
        String a = "A";
        lst.insert(a, dllist.position.FIRST);
        String b = "B";
        lst.insert(b, dllist.position.FIRST);
        String c = "C";
        lst.insert(c, dllist.position.FIRST);
        String d = "D";
        lst.insert(d, dllist.position.FOLLOWING);
        lst.setPosition(dllist.position.FIRST);
        lst.getItem();
        assertEquals("C", lst.getItem());
    }
    @Test
    public void fiveElemTest () {
        dllist lst = new dllist();
        String a = "A";
        lst.insert(a, dllist.position.LAST);
        String b = "B";
        lst.insert(b, dllist.position.FIRST);
        String c = "C";
        lst.insert(c, dllist.position.FOLLOWING);
        lst.setPosition(dllist.position.LAST);
        String d = "D";
        lst.insert(d, dllist.position.PREVIOUS);
        lst.setPosition(dllist.position.FIRST);
        String e = "E";
        lst.insert(e, dllist.position.FOLLOWING);
        lst.setPosition(dllist.position.FIRST);
        lst.getItem();
        assertEquals("B", lst.getItem());
        lst.setPosition(dllist.position.FOLLOWING);
        lst.getItem();
        assertEquals("E", lst.getItem());
        lst.setPosition(dllist.position.FOLLOWING);
        lst.getItem();
        assertEquals("C", lst.getItem());
        lst.setPosition(dllist.position.LAST);
        lst.getItem();
        assertEquals("A", lst.getItem());
        lst.setPosition(dllist.position.PREVIOUS);
        lst.getItem();
        assertEquals("D", lst.getItem());
    }
    @Test
    public void fivePosTest () {
        dllist lst = new dllist();
        String a = "A";
        lst.insert(a, dllist.position.LAST);
        String b = "B";
        lst.insert(b, dllist.position.FIRST);
        String c = "C";
        lst.insert(c, dllist.position.FOLLOWING);
        lst.setPosition(dllist.position.LAST);
        String d = "D";
        lst.insert(d, dllist.position.PREVIOUS);
        lst.setPosition(dllist.position.FIRST);
        String e = "E";
        lst.insert(e, dllist.position.FOLLOWING);
        lst.setPosition(dllist.position.FIRST);
        lst.getPosition();
        assertEquals(1, lst.getPosition());
        lst.setPosition(dllist.position.FOLLOWING);
        lst.getPosition();
        assertEquals(2, lst.getPosition());
        lst.setPosition(dllist.position.FOLLOWING);
        lst.getPosition();
        assertEquals(3, lst.getPosition());
        lst.setPosition(dllist.position.FOLLOWING);
        lst.getPosition();
        assertEquals(4, lst.getPosition());
        lst.setPosition(dllist.position.FOLLOWING);
        lst.getPosition();
        assertEquals(5, lst.getPosition()); 
    }
    @Test
    public void deleteTest () {
        dllist lst = new dllist();
        String a = "A";
        lst.insert(a, dllist.position.FIRST);
        String b = "B";
        lst.insert(b, dllist.position.FIRST);
        String c = "C";
        lst.insert(c, dllist.position.FIRST);
        lst.setPosition(dllist.position.FIRST);
        lst.delete();
        assertEquals("B", lst.getItem());
        lst.delete();
        assertEquals("A", lst.getItem());
    }
    @Test(expected=Exception.class)
    public void setPosistionPrevExeptionTest () {
        dllist lst = new dllist();
        String a = "A";
        lst.insert(a, dllist.position.FIRST);
        lst.setPosition(dllist.position.PREVIOUS);
    }    
    @Test(expected=Exception.class)
    public void setPosistionFollowingExeptionTest () {
        dllist lst = new dllist();
        String b = "B";
        lst.insert(b, dllist.position.LAST);
        lst.setPosition(dllist.position.FOLLOWING);
    }
    @Test(expected=Exception.class)
    public void getItemExceptionTest () {
        dllist lst = new dllist();
        lst.getItem();
    }
    @Test(expected=Exception.class)
    public void getPositionExceptionTest () {
        dllist lst = new dllist();
        lst.getPosition();
    }
    @Test(expected=Exception.class)
    public void deleteExceptionTest () {
        dllist lst = new dllist();
        lst.delete();
    }
    @Test(expected=Exception.class)
    public void insertPrevExeptionTest () {
        dllist lst = new dllist();
        String a = "A";
        lst.insert(a, dllist.position.PREVIOUS);
    }
    @Test(expected=Exception.class)
    public void insertFollowExeptionTest () {
        dllist lst = new dllist();
        String a = "A";
        lst.insert(a, dllist.position.FOLLOWING);
    }
}