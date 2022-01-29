package ch14;

import java.util.function.Function;
import java.util.function.Predicate;

public class Ramda2 {

    public static void main(String[] args) {
        Function<String,Integer> hexConvert = i -> Integer.parseInt(i,16);
        Function<Integer,String> binaryConvert = i -> Integer.toBinaryString(i);

        Function<String,String> mixConvert = hexConvert.andThen(binaryConvert);

        System.out.println(String.format("hex -> %d",hexConvert.apply("30")));
        System.out.println(String.format("binary -> %s",binaryConvert.apply(30)));
        System.out.println(String.format("mix -> %s",mixConvert.apply("30")));


        Predicate<Integer> is100Up = i -> i < 100;
        Predicate<Integer> is200Down = i -> i < 200;
        Predicate<Integer> isMod = i -> i % 2 == 0;
        Predicate<Integer> not100Up = is100Up.negate();
        Predicate<Integer> all = not100Up.and(is200Down.or(isMod));
        
        if(all.test(150)) System.out.println("통과");
        String str1 = "pass";
        String str2 = "pass";
        Predicate<String> equalString = Predicate.isEqual(str1);
        boolean equalString2 = equalString.test(str2);
        boolean isEqual = Predicate.isEqual(str1).test(str2);

        System.out.println(equalString2);
        System.out.println("isEqual = " + isEqual);


        
        
        





    }
}
