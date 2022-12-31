package ch14;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class StreamGroupCollect {
    public static void main(String[] args) {
        StudentCol[] stuArr = {
                new StudentCol("나자바", true,  1, 1, 300),
                new StudentCol("김지미", false, 1, 1, 250),
                new StudentCol("김자바", true,  1, 1, 200),
                new StudentCol("이지미", false, 1, 2, 150),
                new StudentCol("남자바", true,  1, 2, 100),
                new StudentCol("안지미", false, 1, 2,  50),
                new StudentCol("황지미", false, 1, 3, 100),
                new StudentCol("강지미", false, 1, 3, 150),
                new StudentCol("이자바", true,  1, 3, 200),

                new StudentCol("나자바", true,  2, 1, 300),
                new StudentCol("김지미", false, 2, 1, 250),
                new StudentCol("김자바", true,  2, 1, 200),
                new StudentCol("이지미", false, 2, 2, 150),
                new StudentCol("남자바", true,  2, 2, 100),
                new StudentCol("안지미", false, 2, 2,  50),
                new StudentCol("황지미", false, 2, 3, 100),
                new StudentCol("강지미", false, 2, 3, 150),
                new StudentCol("이자바", true,  2, 3, 200)
        };


        System.out.printf("1. 단순분할(성별로 분할)%n");

        Map<Boolean,List<StudentCol>> group = Stream.of(stuArr).collect(partitioningBy(StudentCol::isMale));
        group.get(true).forEach(System.out::println);
        group.get(false).forEach(System.out::println);

        System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
        Map<Boolean, Long> group2 = Stream.of(stuArr).collect(partitioningBy(StudentCol::isMale, counting()));
        System.out.printf("성별 = 남자 // 학생수 = %d \n",group2.get(true));
        System.out.printf("성별 = 여자 // 학생수 = %d \n",group2.get(false));


        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<StudentCol>> collect = Stream.of(stuArr).collect(partitioningBy(StudentCol::isMale, maxBy(comparingInt(StudentCol::getScore))));
        System.out.println("남자일등 = " + collect.get(true).get());
        System.out.println("여자일등 = " + collect.get(false).get());

        //같은방법인데 Optional 이 아닌 객체를 꺼내온다
        Map<Boolean, StudentCol> collect2 = Stream.of(stuArr)
                .collect(partitioningBy(StudentCol::isMale,
                        collectingAndThen(
                                maxBy(comparingInt(StudentCol::getScore)),Optional::get
                        )
                ));

        System.out.printf("%n4. 다중분할(성별 불합격자, 150점 미만)%n");

        Map<Boolean, Map<Boolean, List<StudentCol>>> mapMap = Stream.of(stuArr)
                .collect(
                        partitioningBy(StudentCol::isMale
                                , partitioningBy(s -> s.getScore() < 150))
                );

        mapMap.get(true).get(true).forEach(System.out::println);

        System.out.printf("%n4. 다중분할(성별 ,학년, 반)%n");
        Map<Boolean,Map<Boolean,List<StudentCol>>> isMaleIsHakMap =
                Stream.of(stuArr).sorted(Comparator.comparing(StudentCol::getBan).thenComparing(StudentCol::getScore))
                .collect(
                        partitioningBy(StudentCol::isMale
                                ,partitioningBy(obj -> obj.getHak() == 1)
                        )
                );
        isMaleIsHakMap.forEach((k,v) -> v.forEach((key,val) -> System.out.println(val)));





    }



}

class StudentCol {
    String name;
    boolean isMale; // 성별
    int hak;		    // 학년
    int ban;		    // 반
    int score;

    StudentCol(String name, boolean isMale, int hak, int ban, int score) {
        this.name	= name;
        this.isMale	= isMale;
        this.hak	= hak;
        this.ban	= ban;
        this.score  = score;
    }
    String	getName()  { return name;}
    boolean isMale()    { return isMale;}
    int		getHak()   { return hak;}
    int		getBan()   { return ban;}
    int		getScore() { return score;}

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]",
                name, isMale ? "남":"여", hak, ban, score);
    }


}
// groupingBy()에서 사용
enum Level { HIGH, MID, LOW }  // 성적을 상, 중, 하 세 단계로 분류