package stack;

import java.util.HashMap;
import java.util.Stack;

public class validParentheses_20 {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();


        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');


        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (map.get(open) != c) {
                    return false;
                }
            }
        }


        return stack.isEmpty();
    }
}
