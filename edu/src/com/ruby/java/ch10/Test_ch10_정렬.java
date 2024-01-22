package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/*
 * 1) 정수의 정렬
 *  1.1) 정수 배열의 정렬
 *  1.2) ArrayList의 정렬
 * 2) 객체의 정렬
 *  2.1 객체 배열의 정렬
 *  2.2 ArrayList<Employee>의 정렬
 *
 */
class Student {
    int sid;
    String name;
    public Student(int sid, String name) {
        this.sid=sid;this.name=name;
    }
    public String toString() {
        return "sid = " + sid + "  name = "+name;
    }
}
class StComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}
public class Test_ch10_정렬 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //-------------------
        System.out.println("1. 정수 배열의 정렬\n");
        int data[] = new int[10];
        Random rdm = new Random();
        for (int i = 0; i < data.length; i ++) {
            data[i] = rdm.nextInt(1, 100);//
        }
        for (int n : data)
            System.out.print(n + " ");

        Arrays.sort(data);//
        //Collections.sort(null);//배열은 collection이 아니므로 사용 안됨
        System.out.println();
        for (int n : data)
            System.out.print(n + " ");
        System.out.println("\n");
        //---------------------
        System.out.println("2. ArrayList<Integer>정수 배열의 정렬\n");
        for (int i = 0; i < data.length; i ++) {
            data[i] = rdm.nextInt(1, 100);//
        }
        ArrayList<Integer> alist = new ArrayList<>();
        for (int j = 0; j < data.length; j++) {
            alist.add(data[j]);//
        }
        for (int n : alist)
            System.out.print(n + " ");
        Collections.sort(alist);//
        //alist.sort(null);
        System.out.println();
        for (int n : alist)
            System.out.print(n + " ");
        System.out.println("\n");
        //---------------
        System.out.println("3. 객체 배열의 정렬\n");
        Student []st = new Student[6];
        st[0] = new Student(11,"hong");st[1] = new Student(51,"kim");st[2] = new Student(31,"han");
        st[3] = new Student(88,"park");st[4] = new Student(33,"go");st[5] = new Student(55,"song");
        for (Student stx : st)
            System.out.println(stx);

        Arrays.sort(st, new StComparator());//
        System.out.println();
        for (Student stx : st)
            System.out.println(stx);
        System.out.println();
        //---------------
        System.out.println("4. 객체 리스트의 정렬\n");
        ArrayList<Student> blist = new ArrayList<>();
        st[0] = new Student(11,"hong");st[1] = new Student(51,"kim");st[2] = new Student(31,"han");
        st[3] = new Student(88,"park");st[4] = new Student(33,"go");st[5] = new Student(55,"song");
        for (int j = 0; j < st.length; j++) {
            blist.add(st[j]);//
        }
        for (Student stx : blist)
            System.out.println(stx);
        
        Collections.sort(blist, new StComparator());//
        //blist.sort(new StComparator());
        System.out.println();
        for (Student stx : blist)
            System.out.println(stx);
    }

}
