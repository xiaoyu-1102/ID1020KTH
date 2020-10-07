import java.util.Scanner;
public class lab3 {

    private static void arrayReverse(char[]arr) {

        int num = arr.length / 2;
        System.out.println("The number of reverse pair is:" + num);
        for (int i = 0; i < arr.length / 2 + 1; i++) {
            int j = arr.length - i - 1;
            if (i != j) {
                System.out.println("[" + i + "," + arr[i] + "], [" + j + "," + arr[j] + "]");
            } else {
                System.out.println("[" + i + "," + arr[i] + " inverse with itself"+"]");
            }
        }
    }


    public static void main (String[] args){
        System.out.println("print your array");
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        char[] arr = str.toCharArray();
        arrayReverse(arr);
    }
}
