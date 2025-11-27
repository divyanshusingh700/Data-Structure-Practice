package DesignPattern.AdapterDesignPattern;
import java.util.Arrays;
import java.util.List;


/*
 What it adapts: converts an array (e.g., T[]) to a List<T> view.
 Why it’s an Adapter: the returned List implements java.util.List and delegates get, set, size, etc., to the underlying array.
 It provides the List interface around an array.
 */
public class ArraysAsListAdapter {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};
        List<String> list = Arrays.asList(arr);

        System.out.println(list.get(1)); // b
        list.set(1, "B");               // allowed
        System.out.println(arr[1]);     // B  (backed by array)

        try {
            list.add("d");              // throws UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Can't add: fixed-size list");
        }
    }
}