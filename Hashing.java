import java.util.*;
public class Hashing{
    public static void main (String args[]){
        HashSet<Integer> s = new HashSet<>();
        s.add(5);
        s.add(10);
        System.out.println(s);
        if(s.contains(10)){
            System.out.println("Present");

        }else{
            System.out.println("Not present");
        }
        s.remove(10);
        System.out.println(s.isEmpty());
        System.out.println(s.size());
        s.clear();
    }
}