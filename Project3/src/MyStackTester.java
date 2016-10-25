import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by David on 10/24/2016.
 */
public class MyStackTester {

    public Stack<String> stringStack;


    @Before
    public void before() {
        stringStack = new Stack<>();
    }

    @Test
    public void testPush() {
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        assertEquals(stringStack.pop(), "c");
    }

    @Test
    public void testPop() {
        String popped = stringStack.pop();

    }
}
