package ch14;

import java.util.function.Function;

public class Ramda3 {

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