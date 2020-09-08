import java.io.IOException;

public class lab2_1 {

    static public void foo (){
        char arr[] = new char[20];

        int i = 0;
        for(i=0;i<20;i++){
            char c = 0;
            try {
                c = (char)System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(c ==  '\n')
                break;

            arr[i] = c;
        }

        for(int j=i-1; j>=0;j--){
            System.out.print(arr[j]);
        }
    }

    public static void main (String args[]){
        System.out.println("Write something");
        foo();
    }
}
