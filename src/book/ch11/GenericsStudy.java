package book.ch11;

import java.util.*;

class Product  {
    String name;

    Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("이름은 %s", name);
    }

    public static void printProductChildList(List<? extends Product> list) {
        MakeJcf.printJcf(list.iterator());
    }

    /*
     사용이유 : 지네릭 메서드는 메서드를 호출할 대마다 다른 지네릭 타입을 대입할 수 있게 한 것
     */
    public static <T> void printGenericMethod(List<T> list) {
        MakeJcf.printJcf(list.iterator());
    }

}

class Tv extends Product {
    Tv() {
        super("티비");
    }

}

class Audio extends Product {
    Audio() {
        super("오디오");
    }
}

public class GenericsStudy {

    public static void main(String[] args) {
        //iterator 실험
        MakeJcf makeJcf = new MakeJcf();
        Map<String, String> map = makeJcf.makeMap();
        makeJcf.printJcf(map.entrySet().iterator());

        // 타입변수는 일치해야 한다. 조상과 자손 (다형성 성립불가)
//        ArrayList<Product> products = new ArrayList<Tv>();
        ArrayList<Product> products = new ArrayList<Product>();

        //지네릭 클래스간의 다형성은 성립가능
        List<Product> list = new ArrayList<>();

        // 매개변수는 다형성 가능  
        // ex) E add() -> Product add() 변환되기 때문에 -> 다형성 적용가능
        products.add(new Audio());
        products.add(new Tv());
        makeJcf.printJcf(products.iterator());

        // 지네릭 클래스에서의 다형성 활용
        //와일드카드 -> 하나의 참조변수로 대입된 (지네릭)타입이 다른 객체를 참조가능 (물론 extends || super 제약 걸어야함)
        List<? extends Product> prChildList = new ArrayList<Tv>();

        List<Tv> tvList = new ArrayList<>();
        tvList.add(new Tv());

        List<Audio> audioList = new ArrayList<>();
        audioList.add(new Audio());
        Product.printProductChildList(audioList);
        //GenericMethod 사용
        Product.printGenericMethod(tvList);
        //형변환 List<Audio> -> List<? extends Product>
        List<? extends Product> convertGenericList = audioList;

    }
}

class MakeJcf {

    Map<String, String> makeMap() {
        Map<String, String> map = new HashMap<>();
        map.put("123", "456");
        map.put("124", "456");
        map.put("125", "456");
        map.put("126", "456");
        map.put("127", "456");
        map.put("128", "456");
        map.put("129", "456");
        return map;
    }

    static void printJcf(Iterator<?> iter) {
        while (iter.hasNext()) {
            System.out.println("iter.next = " + iter.next());
        }
    }

}
