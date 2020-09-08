import java.io.IOException;

public class lab3 {
    public static void main(String[] args) {
        System.out.println("Input your content ");

        DoubleLinkFIFO<Character> queue = new DoubleLinkFIFO<Character>();

        while(true)
        {
            char n = 0;
            try {
                n = (char)System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(n ==  '\n')
                break;

            queue.enqueue(n);
            System.out.println(queue.toString());
        }

        while(true){
            if(queue.isEmpty())
                break;
            char c = queue.dequeue();
            System.out.print(c);
            System.out.println(queue.toString());

        }
    }
}
