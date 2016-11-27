import LinkedList.SortedDoublyLinkedList;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by David on 11/23/2016.
 */
public class ListTest {

    SortedDoublyLinkedList<Person> list;
    Person bob = new Person("bob", "Joe", 1, new Date(1999, 1, 1));

    @Before
    public void setup() {
        list = new SortedDoublyLinkedList<>();
    }
    @Test
    public void removeTest() {
        assertTrue(list.add(bob));
        assertTrue(list.remove(bob));
    }

    @Test
    public void dupeTest() {
        assertTrue(list.add(bob));
        assertFalse(list.add(bob));
    }

}
