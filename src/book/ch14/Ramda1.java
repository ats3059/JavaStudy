package ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ramda1 {


    public static void main(String[] args) {
        // 공급자 -> 매개변수 없고 반환값은 있음. -> 1 ~ 100까지의 난수발생기
        Supplier<Integer> randomValue = () -> (int)(Math.random()*100)+1;
        //소비자 -> 매개변수 있고 반환값은 없음
        Consumer<Integer> printValue = i -> System.out.print(i + " ,");
        //Predicate -> 매개변수 받아서 Boolean 으로 반환 원래 <T,R>인데 => Return 타입이 Boolean 고정이기 때문에 R은 정의하지 않아도 된다.
        Predicate<Integer> isEven = i -> i%2==0;
        //Function<T,R> 매개변수 타입 , 반환값 두개 전부 존재
        //1의 자리 버린다.
        Function<Integer,Integer> func = i -> i / 10 * 10;

        List<Integer> list = new ArrayList();
        //난수값으로 List 내부에 넣는다.
        addList(randomValue,list);
        //List 내부의 난수값을 출력한다.
        printElement(printValue,list);
        //짝수만 반환한다
        printElement(printValue,resultEvenList(isEven,list,printValue));
        // 1의자리를 버린다.
        printElement(printValue,doSomething(func,list));



    }

    static <T> void addList(Supplier<T> s ,List<T> list){
        for(int i = 0; i < 10; i++){
            list.add(s.get());
        }
    }
    static <T> List<T> resultEvenList(Predicate<T> p , List<T> list , Consumer<T> c){
        List<T> newList = new ArrayList<>();
        for(T inner : list){
            if(p.test(inner)) newList.add(inner);
        }

        return newList;
    }

    static <T> void printElement(Consumer<T> c,List<T> target){
        for(T inner : target){
            c.accept(inner);
        }
    }

    static <T> List<T> doSomething(Function<T,T> func, List<T> list){
        List<T> somethingList = new ArrayList();
        for(T inner : list){
            somethingList.add(func.apply(inner));
        }
        return somethingList;
    }



}


