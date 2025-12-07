package FileReaderJava;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try(FileReader fr = new FileReader("DesignPattern/ObserverDesignPattern/Explain.txt")){
            int ch;
            while((ch = fr.read()) != -1){
                System.out.print((char) ch);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
