package ch14;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FinalAcu1 {

    public static void main(String[] args) {
        Stream<String> strStream = Stream.of("안녕하세요" , "helloooo" , "hihihi" , "neeeeet" , "http" , "ps");
        Stream<String> strStream2 = Stream.of("안녕하세요" , "helloooo" , "hihihi" , "neeeeet" , "http" , "ps");
        Stream<String> strStream3 = Stream.of("안녕하세요" , "helloooo" , "hihihi" , "neeeeet" , "http" , "ps");
        Stream<String> strStream4 = Stream.of("안녕하세요" , "helloooo" , "hihihi" , "neeeeet" , "http" , "ps");
        Stream<String> strStream5 = Stream.of("안녕하세요" , "helloooo" , "hihihi" , "neeeeet" , "http" , "ps");

        //모든 요소가 조건을 만족시키지 않으면 true
        strStream2.noneMatch(s -> s.length() < 10);
        //한 요소라도 조건을 만족시키면 true
        strStream3.anyMatch(s -> s.length() < 10);
        // 모든 요소가 조건을 만족시키면 true
        strStream4.allMatch(s -> s.length() < 10);

        IntStream intStream = strStream.mapToInt(String::length);
        IntStream intStream2 = strStream5.mapToInt(String::length);

        //병렬로 처리시
        intStream.parallel().forEach(s -> System.out.printf("병렬처리 -> %d \n",s));
        //직렬로 처리시 ///// stream 기본이 sequential()
        intStream2.parallel().forEach(s -> System.out.printf("직렬처리 -> %d \n",s));

        IntStream testStream = IntStream.range(1,10);
        IntStream testStream2 = IntStream.range(1,10);
        IntStream testStream3 = IntStream.range(1,10);
        IntStream testStream4 = IntStream.range(1,10);

        //최종연산
        OptionalInt max = testStream.reduce(Integer::max);
        OptionalInt min = testStream2.reduce(Integer::min);
        int sum = testStream3.reduce(0,(a,b) -> a + b);

        System.out.println(sum);
        System.out.println(max.getAsInt());
        System.out.println(min.getAsInt());






        



    }


}
