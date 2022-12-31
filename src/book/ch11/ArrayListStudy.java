package book.ch11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayListStudy {

    /*
    ArrayList

	ArrayList는 기존의 Vector를 개선한 것으로 구현원리와 기능적으로 동일
	Vector 동기화처리 ArrayList 동기화 x
	List인터페이스를 구현하므로 , 저장순서가 유지되고 중복을 허용한다.
	데이터의 저장공간으로 배열을 사용한다.(배열기반)

	ArrayList에는 객체만 저장가능


	//subList로 만들어진 읽기전용 list를 다시 ArrayList로 변경해줘야함.
	List list2 = new ArrayList(list.subList(1,4));



	capacity -> 용량
     */
    public static void main(String[] args) {
        //ArrayList에는 객체만 저장가능
        List list = new ArrayList(10);

        //int 아니다. 컴파일러가 new Integer(1) 변경을 해주는것.
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(2);
        printList(list,"list");


        //Collection -> 인터페이스 / Collections는 유틸 클래스
        // Collections.sort(list) 오름차순정렬
        Collections.sort(list);
        printList(list,"정렬 list");



        /*
        subList로 만들어진 list는 읽기전용(read-only)임
        쓰기까지 사용하려면?
        List list = new ArrayList();
        list.add() ....;
         */
        List list2 = new ArrayList(list.subList(0,3));
        list2.add("A");
        list2.add("B");
        printList(list2,"list2");

        //list에서 list2와 중복된 부분만 남기고 나머지는 제외
        list.retainAll(list2);
        printList(list,"list");

        for(int i = 0; i < list2.size(); i++){
            if(list.contains(list2.get(i))){
                list2.remove(i);
            }
        }
        printList(list,"retainAll list2");



    }

    static void printList(Collection c,String s){
        System.out.println(String.format("%s 시작함",s));
        for(Object o : c){
            System.out.println(o);
        }
        System.out.println(String.format("%s 종료 \n",s));
    }



}
