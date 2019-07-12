package org.wm.mycontianer.arraylist;

import org.wm.mycontianer.Iterator;
import org.wm.mycontianer.MyList;

public class TestArrays {
    public static void main(String[] args) {
        MyList<String> ma = new MyArrayList<String>();
        ma.add("123");
        ma.add("223");
        ma.add("323");
        ma.add("423");
        ma.add("523");
        ma.add("623");
        ma.add("723");
        ma.add("883");
        ma.add("923");
        ma.add("1023");
        System.out.println(((MyArrayList<String>) ma).getElements().length);
        //System.out.println(ma);
        ma.add(10,"111");
        System.out.println(((MyArrayList<String>) ma).getElements().length);

        System.out.println(ma.get(10));
        /*Iterator iterator = ma.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        ma.remove("123");
        System.out.println("--------------------------");
        Iterator iterator1 = ma.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }*/
    }
}
