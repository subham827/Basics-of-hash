import java.util.*;

public class Hashmapinjava {
    public static void main(String[] args) {
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("key1", 1);
        numbers.put("key2", 2);
        System.out.println(numbers);
        
        numbers.put("key1", 10);
        System.out.println("Updated values: " + numbers);
        numbers.putIfAbsent("key1", 11);
        System.out.println(numbers.get("key2"));
        String s = "abrakadabra";
        int[] a = { 1, 1, 1, 2, 3, 4, 4, 5, 8 };
        int[] b = { 7, 7, 1, 1, 2, 2, 5, 5, 9 };
        int[] c = { 10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2 };
        highestfrequencyofacharacter(s);
        IntersectionoftwoArrays(a, b);
        MaximumSequence(c);

    }

    static void highestfrequencyofacharacter(String s) {
        System.out.println("The highest frequency is");
        System.out.println();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int of = map.get(ch);
                int nf = of + 1;
                map.put(ch, nf);
            } else {
                map.put(ch, 1);
            }
        }
        int mf = map.get(s.charAt(0));
        char mfc = s.charAt(0);
        for (Character iterable_element : map.keySet()) {
            if (map.get(iterable_element) > map.get(mfc)) {
                mf = iterable_element;
            }

        }
        System.out.println(mf);
    }

    static void IntersectionoftwoArrays(int[] a, int[] b) {
        System.out.println("Intersection of two arrays are");

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int val = a[i];
            if (map.containsKey(a[i])) {
                int of = map.get(val);
                int nf = of + 1;
                map.put(val, nf);

            } else {
                map.put(val, 1);
            }

        }
        for (int i = 0; i < b.length; i++) {
            int val = b[i];
            if (map.containsKey(val) && map.get(val) > 0) {
                System.out.println(val);
                int of = map.get(val);
                int nf = of - 1;
                map.put(val, nf);

            }

        }

    }

    static void MaximumSequence(int[] c) {
        System.out.println("The maximum sequence present is");

        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < c.length; i++) {
            int val = c[i];
            map.put(val, true);

        }

        for (int val : c) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);

            }
        }
        int msp = 0;
        int ml = 0;
        for (int val : c) {
            int tl = 1;
            int tsp = val;
            while (map.containsKey(tsp + tl)) {
                tl++;
            }
            if (tl > ml) {
                msp = tsp;
                ml = tl;

            }

        }
        for (int i = 0; i < ml; i++) {
            System.out.print(msp + i + " ");

        }
    }

}
