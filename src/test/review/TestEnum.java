package test.review;

import java.util.function.Function;
// Enum 인자에 함수를 추가하고 각각 다르게 동작하도록 계산식을 넣어준다
public enum TestEnum {

    A(10,(value) -> value),B(20,(value) -> value * 2),C(30,(value) -> value * 3);
    private final int value;
    private Function<Long,Long> expression;

    TestEnum(int value , Function<Long,Long> expression){
        this.value = value;
        this.expression = expression;
    }

    public long calc(long value){ return expression.apply(value);}

    public int getValue() {
        return value;
    }



}

class Execute{
    public static void main(String[] args) {
        String str = "value = { %d } , calc = { %d }";
        System.out.println(String.format(str ,TestEnum.A.getValue(), TestEnum.A.calc(10)));
        System.out.println(String.format(str ,TestEnum.B.getValue(), TestEnum.B.calc(10)));
        System.out.println(String.format(str ,TestEnum.C.getValue(), TestEnum.C.calc(10)));

    }
}
