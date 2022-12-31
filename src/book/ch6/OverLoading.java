package ch6;

public class OverLoading {
    //  (과적하다)
    //  오버로딩 -> 한 클래스 안에 같은 이름의 메서드 여러 개 정의하는 것
    //
    //  오버로딩이 성립하기 위한 조건 3가지
    //  1.메서드 이름이 같아야 한다.
    //  2. 매개변수의 개수 또는 타입이 달라야 한다.
    //  3 반환 타입은 영향없다.
    //
    //  오버로딩의 올바른 예 - 매개변수는 다르지만 같은 의미의 기능 수행
    //  해당 예제에서는 더하다 라는 의미의 메서드 명으로 재정의
    //
    //  정확한 명칭 메서드 오버로딩.
    //  + 같은 연산자도 3개의 기능을 수행함.

    public static void main(String[] args) {
        OverLoading overLoading = new OverLoading();
        System.out.println("overLoading.add(3,3) = " + overLoading.add(3,3));
        System.out.println("overLoading.add(3L,3) = " + overLoading.add(3L,3));
        System.out.println("overLoading.add(3,3L) = " + overLoading.add(3,3L));
        System.out.println("overLoading.add(new int[] {300,400,500,600})) = " + overLoading.add(new int[] {300,400,500,600}));


    }

    public int add(int a ,int b){
        return a+b;
    }
    public long add(int a ,long b){
        return a + b;
    }
    public long add(long a ,int b){
        return a+b;
    }
    public int add(int[] a){
        int result = 0;

        for (int i : a) {
            result += i;
        }

        return result;
    }

}
