/*
This program will test function get and put in binary search,
it will return the words with highest frequency in given certain range
of input file, also will give running time.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class lab2_ST {

    private static boolean is_letter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }


    public static void main(String[] args)
    {

        int minlen = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<String, Integer>(10000);

        long startTime = System.nanoTime();

        try {
            File myObj = new File("file.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNext()) {
                String word = myReader.next();
                if (word.length() > 0) {
                    if (word.length() > minlen) {
                        //System.out.println(word);
                        if (!st.contains(word)) {
                            st.put(word, 1);
                        } else {
                            st.put(word, st.get(word) + 1);
                        }
                    }
                }

                    if (st.size() >= 1000) break;
                }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String max = "";
        st.put(max, 0);
        for (int j =0; j<st.size(); j++) {
            String str = st.getKeypos(j);

            if (st.get(str) > st.get(max)) {
                max = str;
            }
        }

        long endTime = System.nanoTime();

        System.out.println("Total execution time: "
                + (endTime - startTime )/1000000);


        System.out.println("most used word is: "+ max + " " + st.get(max)+" times");

    }
}
