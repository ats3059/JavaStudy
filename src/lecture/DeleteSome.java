package lecture;

import java.util.Stack;

public class DeleteSome {
    public static void main(String[] args) {
        System.out.println(new DeleteSome().solution("baabaa"));

    }
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();


        for (char c : s.toCharArray()) {
            if(stack.isEmpty()) stack.push(c);
            else {
                if(stack.peek() == c)stack.pop();
                else stack.push(c);
            }
        }

        answer = stack.size() > 0 ?  0 : 1;

        return answer;
    }
}
