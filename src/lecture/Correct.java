package algo;

import java.util.Stack;

public class Correct {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        if(s.charAt(0) == ')') return false;
        int size = s.length();
        for(int i = 0; i < size; i++){
            char temp = s.charAt(i);
            if(temp == '(') stack.push(temp);
            if(!stack.isEmpty()){
                if(temp == ')') stack.pop();
            }
        }

        return stack.size() == 0 ? answer : false;
    }
}
