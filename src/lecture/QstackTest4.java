package algo;

import java.util.Scanner;
import java.util.Stack;

public class QstackTest4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        QstackTest4 qst = new QstackTest4();
        System.out.println(qst.solution(str));

    }

    int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(str.charAt(i))) {
                stack.push((int) str.charAt(i) - '0');
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (str.charAt(i) == '+')
                    stack.push(lt + rt);
                else if (str.charAt(i) == '-')
                    stack.push(lt - rt);
                else if (str.charAt(i) == '*')
                    stack.push(lt * rt);
                else if (str.charAt(i) == '/')
                    stack.push(lt / rt);

            }

        }


        return stack.pop();
    }


}
