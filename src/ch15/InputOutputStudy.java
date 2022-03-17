package ch15;

import java.io.*;


public class InputOutputStudy {
    /*
        15장 입출력 I/O

        입출력이란 Input과 Output의 약자로 입력과 출력
        간단히 줄여서 입출력이라고 한다. 입출력은 컴퓨터 내부 또는 외부의 장치와 프로그램간의 데이터를 주고받는 것을 말한다.
        예를 들면 키보드로부터 데이터를 입력받는다든가 System.out.println()을
        이용해서 화면에 출력한다던가 하는 것이 가장 기본적인 입출력의 예이다.


        자바에서 stream() (이전강의에서 배웠던 내용)과 IO의 스트림은
        같은 용어를 사용하지만 다른개념이다.

        ★★스트림이란 데이터를 운반하는데 사용되는 연결통로이다.★★

        스트림은 단방향통신만 가능하기 때문에 하나의 스트림으로 입력과 출력을
        동시에 처리할 수 없다.

        스트림은 먼저 보낸 데이터를 먼저 받게 되어 있으며 중간에 건너뜀 없이 연속적으로 데이터를 주고 받는다.
        큐와 같은 fifo 구조로 되어 있다고 생각하면 된다.

        InputStream, OutputStream
        자손 Filexxxx , filterxxxx 등등...

        문자열을 사용할때는 Reader , Writer를 사용한다
        java에서 char = 2byte
        일반 스트림으로 내용을 읽으면 1byte이므로 사용이 어렵지만
        문자 스트림을 사용하면 2byte로 사용 가능..
        단순히 2byte처리만을 위한것이 아닌 문자데이터를 다루는데 필요한 인코딩을 자동으로 처리해준다
        문자기반 스트림/ Reader와 Writer 그리고 그 자손들은 여러 종류의 인코딩과 자바에서 사용하는 유니코드(UTF-16)간의 변환을 자동으로 처리해준다
        Reader는 특정 인코딩을읽어서 유니코드로 변환하고 Writer는 유니코드를 특정 인코딩으로 변환하여 저장한다.

        보조 스트림 사용 시 (BufferedOutputStream) close() 호출하면
        기반 스트림(FileInputStream()같은..)의 close()를 호출하고
        flush() (버퍼의 남아있는 내용을 전부 출력하는)도 호출하기 때문에
        close()만 사용하면 된다 따로 기반스트림의 flush()나 close()를 호출하지 않아도 된다.

     */
    public static void main(String[] args) throws Exception{
        FileInputStream fis = null;
        String filePath = "C:\\Users\\user1\\Desktop\\StateLessUseReason.txt";
        fis = new FileInputStream(new File(filePath));
        FileReader fr = new FileReader(new File(filePath));
        FileWriter fw = new FileWriter(new File("C:\\Users\\user1\\Desktop\\copy.txt"));
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);
        //try - with - resources 이용하면 close()를 직접 호출하지 않아도 자동호출 되도록 한다.
        //BufferedOutputStream은 기본적으로 크기를 지정해주지 않는다면 8192byte의 크기를 갖게된다.
        int x = 0;
        int cnt = 0;
        while((x = fr.read()) > -1){
            cnt++;
            fw.write(x);
        }







        System.out.println(cnt);


//        try(  FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\user1\\Desktop\\copy.txt"));
//              BufferedOutputStream bos = new BufferedOutputStream(fos,5)){
//            for(int i = '1'; i <= '9'; i++){
//                bos.write(i);
//            }
//        }catch (Exception e){
//        }


//        while((i = fr.read()) > -1){
//            fw.write(i);
//        }


//        fw.append('c');
//
//        fw.close();
//        fr.close();


    }


}
