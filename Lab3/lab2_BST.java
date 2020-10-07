/*
This program will test function get and put in binary search tree,
it will return the words with highest frequency in given certain range
of input file, also will give running time.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class lab2_BST {

    private static boolean is_letter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }


    public static void main(String[] args)
    {

        int minlen = Integer.parseInt(args[0]);
        BST<String, Integer> bst = new BST<String, Integer>();

        long startTime = System.nanoTime();

        try {
            File myObj = new File("file.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNext()) {
                String word = myReader.next();
                if (word.length() > 0) {
                    if (word.length() > minlen) {
                        //System.out.println(word);
                        if (!bst.contains(word)) {
                            bst.put(word, 1);
                        } else {
                            bst.put(word, bst.get(word) + 1);
                        }
                    }
                }

                if (bst.size() >= 1000) break;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String max = "";
        bst.put(max, 0);
        for (String str : bst.keys()) {
            if (bst.get(str) > bst.get(max)) {
                max = str;
            }
        }

        long endTime = System.nanoTime();

        System.out.println("Total execution time: "
                + (endTime - startTime )/1000000);


        System.out.println(max + " " + bst.get(max));

    }
}
