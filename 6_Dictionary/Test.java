import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        // Collection<String> coll = new ArrayList<>();
        List<String> coll = new ArrayList<>();

        coll.add("Celine");
        coll.add("James");
        coll.add("Jason");
        coll.add("Robert");
        coll.add("Bob");

        Iterator<String> iterator = coll.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List<String> col = new LinkedList<>();

        col.add("Celine");
        col.add("James");
        col.add("Jason");
        col.add("Robert");
        col.add("Bob");

        Iterator<String> iter = col.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        HashSet<String> hs = new HashSet<>();

        hs.add("Celine");
        hs.add("James");
        hs.add("Jason");
        hs.add("Robert");
        hs.add("Bob");

        Iterator<String> it = hs.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        coll.stream().filter(s -> s.contains("C")).map(s -> s + "a").forEach(System.out::println);
        col.stream().forEach(System.out::println);
        hs.stream().forEach(System.out::println);

        coll.forEach(System.out::println);

    }
}