package com.entertainments.model;

import java.util.*;

import static javax.swing.UIManager.put;

public class HW5 {

        static Map<Integer, Set<Integer>> subSets = new HashMap<>();

        public static void put(Integer key, int value)
        {
            if(!subSets.containsKey(key)) subSets.put(key, new HashSet<Integer>());
            subSets.get(key).add(value);
        }

        public static Collection<Integer> getRandomKeys()
        {
            List<Integer> vals = new ArrayList<Integer>();
            for(int i=0; i<(int)(Math.random()*500); i++)
            {
                vals.add((int)(Math.random()*1000));
            }
            return vals;
        }

        public static void main(String[] args)
        {
            new Scanner(System.in).nextLine();
            for(Integer i=0; i<100000; i++)
            {
                for(Integer key: getRandomKeys())
                    put(key, i);
            }
            new Scanner(System.in).nextLine();
        }
}
