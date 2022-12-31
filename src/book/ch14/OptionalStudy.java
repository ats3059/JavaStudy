package book.ch14;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

public class OptionalStudy {
    public static void main(String[] args) {
        String str = "1234";
        Optional<String> optional = Optional.of(str);
        //Optional 의 값을 가져온다
        optional.ifPresent(System.out::println);

        Optional<String> optional1 = Optional.of("456789");
        Integer integer = optional1.map(Integer::parseInt).orElseThrow(NoSuchElementException::new);
        System.out.println(integer);

        OptionalInt optionalInt = OptionalInt.of(0);
        OptionalInt optionalInt2 = OptionalInt.empty();

        // isPresent() -> null이면 false null이 아니면 true
        //null 아님.(empty 가 아니니까..) true
        System.out.println(optionalInt.isPresent());
        System.out.println(optionalInt.getAsInt());

        // false empty
        System.out.println(optionalInt2.isPresent());






    }
}
