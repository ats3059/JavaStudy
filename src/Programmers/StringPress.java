package Programmers;

public class StringPress {

    public static void main(String[] args) {
        StringPress sp = new StringPress();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 100; i++){
            sb.append("a");
        }
        int answer = sp.solution("aaaaaaaaaabbbbbbbbbb");
        System.out.println(answer);
    }

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int size = s.length();

        String prev = "";

        int plus = 1;
        while(plus <= size){

            //초기값
            int start = 0;
            int end = plus;
            int total = 0;
            int cnt = 0;
            String word = "";
            prev = s.substring(start, end);
            StringBuilder sb = new StringBuilder();

            start = end;
            end += plus;

//            if(size / end == 1) break;
            while(end <= size){
                String cur = s.substring(start, end);

                if(cur.equals(prev)){
                    word = cur;
                    cnt++;
                }else{
                    sb.append(prev);
                    if(cnt != 0)sb.append(cnt);
                    cnt = 0;
                }


                if(end + plus > size) sb.append(s.substring(start));
                prev = cur;
                start = end;
                end += plus;
            }
            if(cnt != 0) sb.append(cnt+1);
            System.out.println(sb.toString());

            int length = sb.length();
            if(length == 0) break;

            plus++;
            total = length;
            answer = Math.min(total,answer);
        }

        return answer;
    }


}
