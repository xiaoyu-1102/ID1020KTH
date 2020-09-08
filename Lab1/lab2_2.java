import java.io.IOException;
import java.util.Scanner;

public class lab2_2 {
    static Scanner scan = new Scanner (System.in);

    static public void foo () {
        char ch = 0;
        try {
            ch = (char)System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ch != '\n') {
            foo();
            System.out.print(ch);
        }

    }

    public static void main (String args[]){
        System.out.println("Print Something");
        foo();
    }
}
