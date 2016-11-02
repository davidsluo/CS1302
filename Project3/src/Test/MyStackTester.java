package Test;

import MyStack.IntegerStackEmulator;
import MyStack.Stack;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.*;

/**
 * @author David Luo
 *         Tests the MyStack.Stack class.
 */
public class MyStackTester {

    private Stack<String> stack;

    public static void main(String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("test")) {
            JUnitCore.main("Test.MyStackTester");
        } else {
            IntegerStackEmulator emulator = new IntegerStackEmulator();
        }
    }

    @Before
    public void makeStack() {
        stack = new Stack<>();
    }

    @Test
    public void testDefaultConstructor() {
        Stack<String> stack = new Stack<>();
        assertEquals(stack.maxSize(), Stack.DEFAULT_CAPACITY);
    }

    @Test
    public void testConstructor() {
        Stack<String> stack = new Stack<>(3);
        assertEquals(stack.maxSize(), 3);
    }

    @Test
    public void testIsEmpty() {
        Stack<String> stack = new Stack<>(1);
        assertTrue(stack.isEmpty());
        stack.push("1");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsFull() {
        Stack<String> stack = new Stack<>(1);
        assertFalse(stack.isFull());
        stack.push("1");
        assertTrue(stack.isFull());
    }

    @Test
    public void testSize() {
        for (int i = 0; i < 10; i++) {
            stack.push(String.valueOf(i));

            assertEquals(stack.size(), i + 1);
        }
    }

    @Test
    public void testMaxSize() {
        assertEquals(stack.maxSize(), Stack.DEFAULT_CAPACITY);
    }

    @Test
    public void testPeek() {
        stack.push("asdf");
        assertEquals(stack.peek(), "asdf");
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testPush() {
        stack.push("a");
        assertEquals(stack.peek(), "a");
        stack.push("b");
        assertEquals(stack.peek(), "b");
        stack.push("c");
        assertEquals(stack.peek(), "c");
        stack.push("d");
        assertEquals(stack.peek(), "d");
        stack.push("e");
        assertEquals(stack.peek(), "e");
    }

    @Test
    public void testPop() {
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        assertEquals(stack.size(), 5);
        assertEquals(stack.pop(), "e");
        assertEquals(stack.size(), 4);
        assertEquals(stack.pop(), "d");
        assertEquals(stack.size(), 3);
        assertEquals(stack.pop(), "c");
        assertEquals(stack.size(), 2);
        assertEquals(stack.pop(), "b");
        assertEquals(stack.size(), 1);
        assertEquals(stack.pop(), "a");
        assertEquals(stack.size(), 0);

    }
}
