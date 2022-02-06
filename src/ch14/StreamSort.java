package ch14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
