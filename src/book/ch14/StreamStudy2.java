package book.ch14;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamStudy2 {
    public static void main(String[] args) {

        String[] strArr = {"Abc.txt","Abc","hello.java","hello.txt","hello"};

        Stream<String[]> stream = Stream.of(new String[]{"123.txt","Abc.txt","hello.java"},strArr);
        //String 배열을 스트림으로 열고 해당 스트림으로 map() -> 요소변환을 하게되면
        // <Stream<String>>을 반환한다 => 이유는 Stream<String[]> 의 요소는 ? -> String[]
        // String[]의 요소는 String -> Arrays::stream 사용시 Stream<String>을 반환하게된다.
//        Stream<Stream<String>> streamStream = stream.map(Arrays::stream);

        //이렇게 사용할때에는 스트림의 스트림을 스트림으로 변환시키는 flatMap() 사용해야함
        Stream<String> stringStream = stream.flatMap(Arrays::stream);
        //Stream<String> 내부에는 위에서 작업했던 new String[] , strArr 배열이 병합되어 하나의 배열로서 스트림을 사용하게 된다

        stringStream.distinct()
                .peek(str -> System.out.printf("peek0 호출 %s %n" , str))
                .filter(str -> str.indexOf(".")!=-1)
                .peek(str -> System.out.printf("peek1 호출 %s %n" , str))
                .map(str -> str.substring(0,str.indexOf(".")))
                .peek(str -> System.out.printf("peek2 호출 %s %n" , str))
                .map(String::toUpperCase)
                .forEach(System.out::println);



    }


}
