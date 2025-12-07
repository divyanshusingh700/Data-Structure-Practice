package FileReaderJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) throws FileNotFoundException {
        try(Scanner sc = new Scanner(new File("DesignPattern/ObserverDesignPattern/Explain.txt"))){
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
