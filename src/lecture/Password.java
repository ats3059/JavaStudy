package lecture;

public class Password {
    public static void main(String[] args) {
        String str = "#****###**#####**#####**##**";
        str = str.replace("#","1").replace("*","0");
        int len = (str.length()-1)/7;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 , j = 0; i <= len; i++){
            sb.append((char)Integer.parseInt(str.substring(j,j+=7),2));
        }

        System.out.println(sb.toString());

    }
}
