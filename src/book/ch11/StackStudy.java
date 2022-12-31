package book.ch11;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackStudy {
    /*
            스택 : LIFO 구조 마지막에 저장된 것을 제일 먼저 꺼내게 된다.
            밑이 막힌 상자
        큐 : FIFO 구조 . 제일 먼저 저장한 것을 제일 먼저 꺼내게 된다.
            큐는 양끝이 뚫린 상자다.
            저장 (OFFER) 추출 (POLL)

        스택을 구현하려면 배열이 알맞다
        큐는 링크드 리스트로 구현하는게 좋다

        링크드 리스트 (자리이동 필요없음)

        자바에서 Queue는 인터페이스임. 객체생성 불가 / 구현객체로 객체생성해야함


        스택의 활용 예 - 수식계산 , 수식괄호 검사 , 워드프로세서의 undo / redo
                        웹브라우저의 뒤로/앞으로

        큐의 활용 예 - 최근 사용문서 , 인쇄작업 대기목록 , 버퍼

     */
    public static void main(String[] args) {
        Stack stack = new Stack();

        String str = "((8*3)*2))))+15";

        try{
            for(char c : str.toCharArray()){
                if(c == '(') stack.push(c);
                else if(c == ')') stack.pop();
            }
            if(stack.isEmpty())
                System.out.println("검증완료");
            else
                System.out.println("검증실패");
        }catch(EmptyStackException e){
            e.getStackTrace();
            System.out.println("검증실패 스택에러");
        }
    }




}
