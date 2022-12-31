package lecture;

import java.util.Arrays;

public class WordReplace {
    public static void main(String[] args) {
//        answer1();
//        answer2_1();
//        answer2_2();
//        answer3();
//        answer3_1();
//        answer4();
        String input1 = "teachermode";
        char input2 = 'e';
        int[] ints = new int[input1.length()];
        int p = 100;
        for(int i = 0; i< input1.length(); i++){
            if(input1.charAt(i) == input2){
                p = 0;
            }else{
                ints[i] = p +=1;
            }
        }
        for(int i = input1.length()-1; i >= 0; i--){
            if(input1.charAt(i) == input2){
                p = 0;
            }else if(ints[i] > p){
                ints[i] = p+=1;
            }

        }



        System.out.println(Arrays.toString(ints));

//        answer5_1(input1);


    }

    private static void answer5_1(String input1) {
        String input2 = "e";
        StringBuilder sb = new StringBuilder(input1);
        int[] ints = new int[input1.length()];
        int front = sb.indexOf(input2);
        int back = sb.deleteCharAt(front).indexOf(input2)+1;
        int temp1 = 0;
        int temp2 = 0;

        for(int i = 0; i < input1.length(); i++){

            if(input1.charAt(i) == input2.charAt(0)){
                front = input1.indexOf(input2,i);
                back = input1.indexOf(input2,i+1);
            }else{
                if(front > i) temp1 = front - i;
                else temp1 = i - front;
                if(back > i) temp2 = back - i;
                else temp2 = i - back;
                ints[i] = temp1 < temp2 ? temp1 : temp2;
            }
//            System.out.printf("temp1 = %d , i = %d %n , temp2 = %d , i = %d %n %n" , temp1,i , temp2,i);

        }

        for(int i : ints){
            System.out.print(i+" ");
        }
    }

    private static void answer4() {
        String str = "g0en2T0s8eSoft".replaceAll("[^0-9]","");
        Integer i = Integer.parseInt(str);
        System.out.println(i);
    }

    private static void answer3_1() {
        String issue = "found7, time: study; Yduts; emit, 7Dnuof".toUpperCase();
        String issueRe = issue.toUpperCase().replaceAll("[^A-Z]","");
        String sb = new StringBuilder(issueRe).reverse().toString();
        String answer = "Yes";

        if(!issueRe.equals(sb)) answer = "NO";
        System.out.println(answer);
    }

    private static void answer3() {
        String issue = "found7, time: study; Yduts; emit, 7Dnuof".toUpperCase();
        String sb = new StringBuilder(issue).reverse().toString().toUpperCase();
        String answer = "YES";

        for(int i = 0; i < issue.length()/2; i++){
            char c = issue.charAt(i);
            char v = sb.charAt(i);
            if(Character.isAlphabetic(c) && Character.isAlphabetic(v)){
                if(c != v){
                    answer = "NO";
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static void answer2_2() {
        String str = "gooddd";
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();

        for(int i = 0; i < len/2; i++){
            if(str.charAt(i) != str.charAt(len-i-1)){
                answer = "NO";
                break;
            }
        }

//        System.out.println(answer);
    }

    private static void answer2_1() {
        String str = "gooG";
        String answer = "";

        int lt = 0 , rt = str.length()-1;

        while(lt < rt){
            Character front = Character.toLowerCase(str.charAt(lt));
            Character back = Character.toLowerCase(str.charAt(rt));
            if(!front.equals(back)){
                answer = "NO";
                break;
            }else{
                answer = "YES";
            }
            lt++;
            rt--;
        }
//        System.out.println(answer);
    }

    private static void answer1() {
        String str = "ksekkset";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< str.length(); i++){
            char temp = str.charAt(i);
            if(str.indexOf(temp) == i){
                sb.append(temp);
            }
        }
//        System.out.println(sb.toString());
    }
}
