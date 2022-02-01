package ch14;


public class Ramda3 {
/*
서드 참조
	하나의 메서드만 호출하는 람다식은 '메서드 참조'로 간단히 할 수 있다.

생성자의 메서드 참조

	Supplier<MyClass> s = () -> new MyClass();


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