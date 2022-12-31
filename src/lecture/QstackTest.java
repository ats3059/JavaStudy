package lecture;


import java.util.Scanner;
import java.util.Stack;

public class QstackTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();


        QstackTest qst = new QstackTest();
        System.out.println(qst.solution(str));


    }
    String solution(String str){
        String answer = "YES";
        Stack<Character> st = new Stack<>();

        int len = str.length();


            for(int i = 0; i < len; i++){
                if(str.charAt(i) == '(') st.push(str.charAt(i));
                else {
                    if(!st.isEmpty()){
                        st.pop();
                    }else{
                        answer = "NO";
                    }
                }
            }


        if(st.size() > 0) answer = "NO";



        return answer;
    }

}
