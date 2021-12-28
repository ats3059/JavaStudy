package ch11;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetStudy {

    public static void main(String[] args) {
/*
        HashSet 중복허용 불가
        1.equals
        2.hashcode()
*/

        Set set = new HashSet();

        while(set.size() < 7){
            set.add((int)(Math.random()*45)+1);
        }

        System.out.println(set);

        TreeSet treeSet = new TreeSet();

        while(treeSet.size() < 7){
            treeSet.add((int)(Math.random()*45)+1);
        }
        System.out.println("treeSet");
        System.out.println(treeSet);
        System.out.println("20보다 작은 값");
        System.out.println(treeSet.headSet(20));
        System.out.println("20보다 큰 값");
        System.out.println(treeSet.tailSet(20));
        System.out.println("1 ~ 20에 가까운 숫자까지. 20은 포함안됨.");
        System.out.println(treeSet.subSet(1 , 20));




    }


}
