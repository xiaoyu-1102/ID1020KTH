
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lab3 {

          // creates a hash code
          public static int getHashValue(String s, int hashSize) {
              return (s.hashCode() & 0x7fffffff) % hashSize;
          }


          public static void main(String args[]) {
              int groups = 10;

              int[] arr = new int[groups];

              File myObj = new File("file.txt");
              Scanner myReader = null;
              try {
                  myReader = new Scanner(myObj);
              } catch (FileNotFoundException e) {
                  e.printStackTrace();
                  return;
              }

              while (myReader.hasNext()) {
                  String word = myReader.next();

                  int hash = getHashValue(word, groups);
                  arr[hash]++;
              }

              int sum=0;

              for(int i = 0; i<groups; i++){
                  System.out.println(i + ": " + arr[i]);
                  sum+=arr[i];
              }
              System.out.println("sum：" + sum);


      }
}
