import java.io.IOException;

public class lab2 {

    public static void main(String[] args) {
        System.out.println("Input your content ");

        Stack<Character> stack = new Stack<Character>(20);

        for(int i = 0; i < 20; i++)
        {
            char n = 0;
            try {
                n = (char)System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(n ==  '\n')
                break;

            stack.push(n);
        }

        for(int i = 0; i<20; i++){
            if(stack.isEmpty())
                break;
            char c = stack.pop();
            System.out.print(c);
        }
    }

}
