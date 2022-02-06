package ch14;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/*
    스트림 만들기 - 컬렉션
	1. 스트림 생성
	2. 중간연산 ( 0 ~ n개 )
	3. 최종연산( 0 ~ 1 )


Collection 인터페이스의 stream()으로 컬렉션을 스트림으로 변환


	기본형 배열로부터 스트림 생성하기
	IntStream IntStream.of(int... values) //Stream이 아니라 IntStream
	IntStream IntStream.of(int [])
	IntStream Arrays.stream(int [])
	IntStream Arrays.stream(int[] array, int startInclusive,int endExclusive)


난수 스트림 만들기 - 임의의 수

new Random().ints(); -> 무한스트림
.limit(5) // 스트림에서 흐름을 자른다

특정 범위의 정수를 요소로 갖는 스트림 생성하기
	IntStream intStream = IntStream.range(1,5); 1~ 5 사이의 정수로 만든다.
	IntStream intStream = IntStream.rangeClosed(1,5) //1 ~ 5까지 나온다 (포함)

람다식을 소스로 하는 스트림 생성하기
	//무한 스트림
	static<T> Stream<T> iterate(T seed , UnaryOperator<T> f) // 이전 요소에 종속적
	static<T> Stream<T> generate(Supplier<T> s) //이전 요소에 독립적


	iterate()는 이전 요소를 seed로 해서 다음 요소를 계산한다
	Stream<Integer> evenStream = Stream.iterate(0,n-> n+2); //0,2,4,6

	generate()는 seed를 사용하지 않는다.
	Stream<Double> randomStream = Stream.generate(Math::random);
	Stream<Integer> oneStream = Stream.generate(()->1);

	파일을 소스로 하는 스트림 생성하기
	Stream<Path> Files.list(Path dir) // path는 파일 또는 디렉토리
	Stream<String> Files.lines(Path path) //파일의 내용을 한줄한줄 요소로 담긴다.
	Stream<String> Files.lines(Path path, Charset cs)
	Stream<String> lines() // BufferedReader클래스의 메서드

	비어있는 스트림 생성하기
	Stream emptyStream = Stream.empty();
	long count = emptyStream.count();


 */
public class StreamStudy {
    public static void main(String[] args) throws Exception{
        // 스트링타입의 LIST를 생성
        List<String> stringList = Arrays.asList("123","456");
        // List 생성 후 스트림 열고 최종연산 수행 ( 메서드 참조 )
        stringList.stream().forEach(System.out::println);

        // 무한 스트림 -> 5 ~ 10 사이의 값을 가져온다 5.6.7.8.9.10
        IntStream intStream = new Random().ints(5,10);
        // 5 ~ 10사이의 난수인 스트림을 10개까지만 생성. limit() 호출 후 출력
        intStream.limit(10).forEach(System.out::println);

        //iterate()는 무한 스트림이다.
        Stream<Integer> integerStream = Stream.iterate(0,n->n+2).limit(10);
        //짝수만 만드는 스트림
        integerStream.forEach(System.out::println);

        Stream<Double> integerStream2 = Stream.generate(Math::random).limit(10);
        integerStream2.forEach(System.out::println);

    }
}
