/*
This program will search given words in file,
give the position where the words in, also measure
the running time.
 */


import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab4 {
    public static void main(String[] args) {

        ST<String, List<Integer>> st = new ST<>(4000000);

        File myObj = new File("file.txt");

        InputStream in = null;
        try {
            in = new FileInputStream(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        Charset encoding = Charset.defaultCharset();
        Reader reader = new InputStreamReader(in, encoding);
        Reader buffer = new BufferedReader(reader);

        int r;
        int pos = 0;
        int minsize = 3;
        StringBuilder sb = new StringBuilder();

        while (true) {
            try {
                if ((r = buffer.read()) == -1) break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

            char ch = (char) r;
            pos++;

            if (Character.isLetter(ch)) {
                sb.append(ch);
            } else if (sb.length() > 0) {

                if (sb.toString().length() >= minsize) {
                    String word = sb.toString();
                    //System.out.println(word);

                    if (!st.contains(word)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(pos - word.length() - 1);
                        st.put(word, list);
                    } else {
                        List<Integer> list = st.get(word);
                        list.add(pos - word.length() - 1);
                    }
                }

                sb = new StringBuilder();
            }
        }

        String word = "That";

        long startTime = System.nanoTime();
        List<Integer> positions = st.get(word);
        long endTime = System.nanoTime();

        System.out.println("Total execution time(ns): "
                + (endTime - startTime )/1000);

        System.out.println(word + " positions: " + positions.toString());



    }
}