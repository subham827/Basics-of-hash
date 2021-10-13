
import java.util.*;

public class Hashing1 {
    public static void main(String[] args) {
        int[] a = { 5, 10, 5, 15, 4, 6 };
        int[] b = { 10, 15, 4, 7 };
        countData(a);
        Unionoftwoarrays(a, b);
        IntersectionoftwoArrays(a, b);
        subarrayofgivensum(a, 20);
        countDistinctelementsineverywindowofsizeK(a, 3);

    }

    static void countData(int[] a) {

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            s.add(a[i]);

        }
        System.out.println(s);
        System.out.println(s.size());
    }

    static void Unionoftwoarrays(int[] a, int[] b) {
        Set<Integer> s = new HashSet<>();
        for (int x : a) {
            s.add(x);

        }
        for (int y : b) {
            s.add(y);

        }
        System.out.println(s);
    }

    static void IntersectionoftwoArrays(int[] a, int[] b) {
        Set<Integer> s = new HashSet<>();
        int c = 0;
        for (int x : a) {
            s.add(x);

        }
        for (int x : b) {
            if (s.contains(x)) {
                c++;
                s.remove(x);

            }

        }
        System.out.println(c);
    }

    static void subarrayofgivensum(int[] a, int sum) {
        int cursum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            cursum += a[i];
            if (cursum - sum == 0) {
                start = 0;
                end = i;
                break;

            }
            // The above if method is a special case if the starting element is a part of
            // subarray
            if (map.containsKey(cursum - sum)) {
                start = map.get(cursum - sum) + 1;
                end = i;
                break;
            }
            map.put(cursum, i);

        }
        if (end == -1) {
            System.out.println("Not found");
        } else {
            System.out.println(start + " " + end);
        }

    }

    static void countDistinctelementsineverywindowofsizeK(int[] a, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < k; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);

        }
        System.out.println(map.size());
        for (int i = k; i < a.length; i++) {
            if (map.get(a[i - k]) == 1) {
                map.remove(a[i - k]);

            } else {
                map.put(a[i - k], map.get(a[i - k]) - 1);
            }
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            System.out.println(map.size());
        }

    }
}
