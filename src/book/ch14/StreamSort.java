package book.ch14;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;


public class StreamSort {
    public static void main(String[] args) {
        Supplier<Student> supplier = Student::new;
        List<Student> studentList = new ArrayList<>();

        IntStream intStream = new Random().ints(1,6);
        intStream.limit(10).forEach(s -> {
            Student student = supplier.get();
            student.classNum = s;
            student.total = (int)(Math.random() * 100) +1;
            studentList.add(student);
        });

        studentList.stream().sorted(Comparator.comparing(Student::getClassNum)
                            .thenComparing(Comparator.naturalOrder()))
                   .forEach(System.out::println);

        Optional<Student> max = studentList.stream().max(Comparator.comparing(Student::getTotal).thenComparing(Student::getClassNum));
        System.out.println(max);


    }
}


class Student implements Comparable<Student>{

    int classNum;
    int total;

    int getClassNum(){
        return classNum;
    }

    int getTotal(){
        return total;
    }

    Student(){
        super();
    }

    @Override
    public int compareTo(Student s) {
        return s.total - this.total;
    }

    @Override
    public String toString() {
        return "Student{" +
                "classNum=" + classNum +
                ", total=" + total +
                '}';
    }
}
