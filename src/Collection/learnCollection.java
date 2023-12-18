package Collection;

import java.sql.SQLOutput;
import java.util.*;

public class learnCollection {

    public static void main(String[] args) {

        /*

        creating collection
        1. Type Safe : Store Data of Same Type
        2. UnType Safe : Store Different Types Of Data

         */

        // Type Safe
        ArrayList<String> names = new ArrayList<>();
        names.add("TUSHAR");
        names.add("PRASHANT");
        names.add("DURGESH");
        names.add("NANDKISHORE");
        names.add("VISHAL");

//        System.out.println(names);
//        System.out.println("Size = " + names.size());

        //check elements is present or not
        System.out.println(names.contains("Rajendra"));

        //check for empty
        System.out.println(names.isEmpty());

        // remove all elements
//        names.clear();
//        System.out.println(names);

        Vector vector = new Vector();
        vector.addAll(names);

        // Forward travering using Iterator
        System.out.println("+++++++++++++++++++ Forward Travering ++++++++++++++++++++++++++");


        Iterator<String> itr = names.iterator();

        while(itr.hasNext()){

            String str = itr.next();
            System.out.println(str);
        }

        System.out.println("+++++++++++++++++++ Backward Travering ++++++++++++++++++++++++++");
        // Backward Travering using ListIterator

        ListIterator<String> listitr = names.listIterator(names.size());

        while(listitr.hasPrevious())
        {
            String  str1 = listitr.previous();
            System.out.println(str1);
        }

        System.out.println("++++++++++++++ For Each Method +++++++++++++++++++++++");

        names.forEach(e -> {
            System.out.println(e);
        });

        System.out.println("++++++++++++++ Treeset +++++++++++++++++++++++");

        Set<String> set = new TreeSet<>();
        set.addAll(names);
        set.forEach(e -> {
            System.out.println(e);
        });
    }
}
