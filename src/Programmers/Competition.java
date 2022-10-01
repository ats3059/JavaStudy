package Programmers;

public class Competition {

    public static void main(String[] args) {
        Competition competition = new Competition();
        System.out.println(competition.solution(8,4,7));


    }

    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while((n=n/2) >= 1){
            a = (a+1)/2;
            b = (b+1)/2;
            answer++;
            if(a==b) break;
        }

        return answer;
    }

}
