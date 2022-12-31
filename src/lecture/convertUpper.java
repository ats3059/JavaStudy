package lecture;

public class convertUpper {

    public static void main(String[] args) {
        String str = "it is time to study sttttttt";

        convert(str);
    }

    static String convert(String str){
        String temp = "";
        int pos = 0;
        int m = 0;
        while((pos = str.indexOf(' ')) > -1){
            int len = str.substring(0,pos).length();
            if(len > m){
                m = len;
                temp = str.substring(0,pos);
            }
            str = str.substring(pos+1);
        }

        if(str.length() > temp.length()) temp = str;


        System.out.println(temp);


//       for(int i = 0,j = 0; j < strArr.length; i++, j = i+1){
//           if(strArr[i].length() > strArr[j].length())temp = strArr[i];
//           else if(strArr[i].length() < strArr[j].length())temp = strArr[j];
//           else temp = strArr[i];
//
//       }

        return temp;
    }


}
