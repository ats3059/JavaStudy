package ch14;


public class Ramda3 {
/*
메서드 참조
	하나의 메서드만 호출하는 람다식은 '메서드 참조'로 간단히 할 수 있다.

생성자의 메서드 참조

	Supplier<MyClass> s = () -> new MyClass();


스트림
	다양한 데이터(컬렉션,배열) 소스를 표준화된 방법으로 다루기 위한 것
	중간연산과 최종연산으로 나뉨. 중간연산은 n번 가능 최종연산은 1번만 가능


스트림의 특징
	스트림은 데이터 소스(원본)로부터 데이터를 읽기만할 뿐 변경하지 않는다.

	스트림은 Iterator처럼 일회용이다.(필요하면 다시 스트림을 생성해야 함)

	최종 연산 전까지 중간연산이 수행되지 않는다. - 지연된 연산

	스트림은 작업을 내부 반복으로 처리한다. //코드가 간결해진다.

	스트림의 작업을 병렬로 처리 - 병렬스트림 // 멀티쓰레드로 병렬처리

	기본형 스트림 IntStream,LongStream,DoubleStream
	오토박싱&언박싱의 비효율이 제거됨(Stream<Integer> 대신 IntStream 사용)
	숫자와 관련된 유용한 메서드를 Stream<T>보다 더 많이 제공



 */
    public static void main(String[] args) {
        //익명객체이다 -> 익명클래스의 제약조건과 같음 // 사실상 내부클래스임..
        TripleRamda<String,Integer,String,TestClass> tripleRamda = TestClass::new;

        System.out.println(tripleRamda);
        TestClass testClass = tripleRamda.method("name", 13, "seoul");
        System.out.println(testClass);

    }

}

class TestClass {
    String name;
    Integer age;
    String locale;

    TestClass(String name, Integer age, String locale) {
        this.name = name;
        this.age = age;
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", locale='" + locale + '\'' +
                '}';
    }
}