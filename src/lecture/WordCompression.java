package algo;

public class WordCompression {
    public static void main(String[] args) {
        String str = "KKHSSSSSSSE";
        answer1(str);
        answer2(str);


    }

    private static void answer2(String str) {
        String s = str +" ";
        int cnt = 1;
        String answer = "";
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1))cnt+=1;
            else{
                if(cnt != 1) answer+= s.charAt(i)+""+cnt;
                else answer+=s.charAt(i);
                cnt=1;
            }
        }
        System.out.println(answer);
    }

    private static void answer1(String str) {
        char[] c = str.toCharArray();
        int cnt = 1;
        StringBuilder sb = new StringBuilder("");
        for(int i = c.length-1 , j = c.length-2; j >= 0; j--, i--){
            if(c[i] == c[j]){
                cnt+=1;
            }else{
                sb.insert(0,c[i]);
                if(cnt != 1){
                    sb.insert(1,cnt);
                }
                cnt = 1;
            }
        }
        if(cnt > 1){
            sb.insert(0, str.charAt(0));
            sb.insert(1,cnt);
        }

//        System.out.println(sb.toString());
    }
}
