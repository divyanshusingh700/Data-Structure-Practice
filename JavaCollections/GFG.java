package JavaCollections;
import java.io.*;
import java.util.*;

class GFG {
    static List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    static List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                list2.add(i);   // automatically synchronized
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try { t1.join(); t2.join(); } catch (Exception e) {}

        System.out.println(list2.size());  // Always 2000 ✔
    }
}
// 8. When NOT to use synchronizedList?

// Avoid when:

// ❌ High concurrency
// ❌ Many reads/writes
// ❌ Performance matters

// Use CopyOnWriteArrayList or ConcurrentLinkedQueue instead.