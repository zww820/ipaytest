package org.ipay.utils;


import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Forutil {
    public static void main(String[] args){
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        List<Integer> l2 = new ArrayList<>();
        l2.add(5);
        l2.add(6);
        l2.add(7);
        l2.add(8);
//        IntStream.range(0, l2.size()).forEach(i -> System.out.println(l1.get(i) + l2.get(i)));
//        Stream.of(l1, l2).flatMap(n -> n.stream()).filter(n->n%2==0).forEach(System.out::println);
        List<List<Integer>> list=new ArrayList<>();
        list.add(l1);
        list.add(l2);
        aaa(list);
    }

    public static void aaa(List<List<Integer>> list) {
        if (list.size()<=0) {
            return;
        }else{
            for (Object i : list.get(list.size() - 1)) {
                System.out.println(i);
            }
            list.remove(list.size() - 1);
            aaa(list);
        }
    }
}
