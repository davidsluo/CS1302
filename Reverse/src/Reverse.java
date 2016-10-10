import java.util.Stack;

/**
 * Reverses a string using a stack.
 *
 * @author David Luo
 */

public class Reverse {

    static Stack<Character> stack = new Stack<>();

    public static String reverse(String s) {
        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        String output = "";

        while (!stack.isEmpty()) {
            output += stack.pop();
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(Reverse.reverse("potato"));
        System.out.println(Reverse.reverse("12345"));
        System.out.println(Reverse.reverse("abcdefghijklmnopqrstuvwxyz"));
    }
}