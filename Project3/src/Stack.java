import Exceptions.EmptyStackException;
import Exceptions.FullStackException;

/**
 * {@inheritDoc}
 */
@SuppressWarnings("unchecked")
public class Stack<T> implements StackADT<T> {

    private T[] stack;
    private int top = -1;
    public final int DEFAULT_CAPACITY = 100;

    public Stack(int capacity) {
        stack = (T[]) new Object[capacity];
    }

    public Stack() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(T element) throws FullStackException {
        try {
            stack[top + 1] = element;
            top++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new FullStackException("Stack full");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T pop() throws EmptyStackException {
        T popped;
        try {
            popped = stack[top];
            stack[top] = null;
            top--;
            return popped;

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new EmptyStackException("Stack empty");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T peek() throws EmptyStackException {
        try {
            return stack[top];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new EmptyStackException("Stack empty");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFull() {
        return top + 1 == stack.length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        int count = 0;
        for (T t : stack) {
            if (t != null) {
                count++;
            }
        }
        return count;
    }

    public int maxSize() {
        return stack.length;
    }
}
