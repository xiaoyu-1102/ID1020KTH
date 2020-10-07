import java.util.Arrays;
import java.util.Scanner;

public class lab2 {
    private static int num_swap=0;

    private static void insertionSort(int arr[]){
        for(int i =1;i<arr.length;i++){
            for(int j=i;j>0 && arr[j-1]>arr[j];j--){
                exch(arr,j,j-1);
            }
        }
    }

    private static void exch(int arr[], int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        num_swap++;
    }


    public static void main(String[] args) {

        System.out.println("define the size");
        Scanner scan = new Scanner (System.in);
        int size = scan.nextInt();

        int arr[] = new int[size];

        for(int i=0; i < size; i++){
            System.out.println("give numbers one by one");
            int num = scan.nextInt();
            arr[i] = num;
        }

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println("Number of swaps: " + num_swap);

    }

}
