package book.ch10;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class NewTimeEx1 {
    //상세내용 https://ats3059.tistory.com/32
    public static void main(String[] args) {
        LocalDate today = LocalDate.now(); // 오늘
        LocalTime now = LocalTime.now(); // 현재시간

        LocalDate birthDate = LocalDate.of(1999, 12, 31); // 1999년 12월 31일
        LocalTime birthTime = LocalTime.of(23, 59, 59); // 23:59:59

        System.out.println(birthDate.withYear(2000)); // 2000.12.31
        System.out.println(birthDate.plusDays(1)); //2000.1.1
        System.out.println(birthDate.plus(1, ChronoUnit.DAYS)); //2000.1.1

        Period period = Period.between(LocalDate.now().minusDays(7), LocalDate.now());
        System.out.println(period.get(ChronoUnit.DAYS));

        long until = birthDate.until(LocalDate.now(), ChronoUnit.DAYS);
        System.out.println(until);

        // 지금날짜와 이번달의 마지막날 남은 D-day
        long until1 = LocalDate.now().until(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()), ChronoUnit.DAYS);
        System.out.println(until1);
        // Period와 달리 Duration은 getHours() getMinites()같은 메서드가 없다..
        //그래서 시간의 차이를 구할 때 좋은 방법은 아래처럼 해보자!
        Duration du = Duration.between(LocalTime.of(1, 23, 40),LocalTime.of(12, 31, 54));
        LocalTime localTime = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
        System.out.println(localTime);


    }
}
