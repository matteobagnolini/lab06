package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final int START_FROM = 1000;
        final int END_TO = 2000;
        List<Integer> al = new ArrayList<>();
        for (int i = START_FROM; i < END_TO; i++) {
            al.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> ll = new LinkedList<>(al);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int tmp = al.get(0);
        al.set(0, al.get(al.size() -1));
        al.set(al.size()-1, tmp); 
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer i : al) {
            System.out.println("["+i+"]");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        final long ITEMS_TO_ADD = 100_000;

        long time = System.nanoTime();

        for (int i = 0; i < ITEMS_TO_ADD; i++) {
            al.add(0, i);
        }

        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);

        System.out.println(millis + "milliseconds used for ArrayList");


        time = System.nanoTime();

        for (int i = 0; i < ITEMS_TO_ADD; i++) {
            ll.add(0, i);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);

        System.out.println(millis + "milliseconds used for add in LinkedList");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        final long ITEMS_TO_READ = 999;

        time = System.nanoTime();

        for (int i = 0; i < ITEMS_TO_READ; i++) {
            al.get(al.size()/2);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(millis + "milliseconds used for get in ArrayList");


        time = System.nanoTime();

        for (int i = 0; i < ITEMS_TO_READ; i++) {
            ll.get(al.size()/2);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(millis + "milliseconds used for get in LinkedList");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final long AFRICA_POPULATION = 1_110_635_000L;
        final long AMERICA_POPULATION = 972_005_000L;
        final long ANTARCTICA_POPULATION = 0L;
        final long ASIA_POPULATION = 4_298_723_000L;
        final long EUROPE_POPULATION = 742_452_000L;
        final long OCEANIA_POPULATION = 38_304_000L;
        Map<String, Long> map = new HashMap<>();
        map.put("Africa", AFRICA_POPULATION);
        map.put("Americas", AMERICA_POPULATION);
        map.put("Antarctica", ANTARCTICA_POPULATION);
        map.put("Asia", ASIA_POPULATION);
        map.put("Europe", EUROPE_POPULATION);
        map.put("Oceania", OCEANIA_POPULATION);
        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0;
        for (Long i : map.values()) {
            worldPopulation += i;
        }

        System.out.println("Total world population: " + worldPopulation);
    }
}
